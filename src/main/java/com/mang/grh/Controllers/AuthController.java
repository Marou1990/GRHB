package com.mang.grh.Controllers;

import com.mang.grh.Repositories.Registration.RoleRepository;
import com.mang.grh.Repositories.Registration.UserRepository;
import com.mang.grh.Security.config.AuthRequest;
import com.mang.grh.Security.config.AuthResponse;
import com.mang.grh.Security.services.JwtService;
import com.mang.grh.Security.services.UserDetailsImpl;
import com.mang.grh.entities.Registration.ERole;
import com.mang.grh.entities.Registration.Role;
import com.mang.grh.entities.Registration.User;
import com.mang.grh.payload.request.SignupRequest;
import com.mang.grh.payload.response.JwtResponse;
import com.mang.grh.payload.response.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private
    PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private RoleRepository roleRepository ;

    public AuthController(JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> Authentifier(@RequestBody AuthRequest authRequest) {
        String Tokengenerated = null;
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            System.out.println("Authentifier authentication.isAuthenticated() :: "+authentication.isAuthenticated());
            if(authentication.isAuthenticated()) {
                //concatener le username avec le code de teledeclaration
                SecurityContextHolder.getContext().setAuthentication(authentication);
                UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                List<String> roles = userDetails.getAuthorities().stream()
                        .map(item -> item.getAuthority())
                        .collect(Collectors.toList());

                Tokengenerated = jwtService.generateToken(authRequest.getUsername());
                System.out.println("----- Tokengenerated ---- :: "+Tokengenerated);
                AuthResponse response = new AuthResponse();
                response.setStatus("OK");
                response.setToken(Tokengenerated);
                response.setId(userDetails.getId());
                response.setEmail(userDetails.getEmail());
                response.setRoles(roles);
                response.setUsername(userDetails.getUsername());
                return new ResponseEntity<AuthResponse>(response, HttpStatus.OK);

            }else {
                System.out.println("Authentifier exception "+authentication.isAuthenticated());
                throw new UsernameNotFoundException("Invalid User");
            }
        }catch(Exception e)
        {
            System.out.println("exception  :: "+e);
            AuthResponse response = new AuthResponse();
            response.setStatus("Failed");
            response.setMessage("Invalid Credentials");
            return new ResponseEntity<AuthResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
