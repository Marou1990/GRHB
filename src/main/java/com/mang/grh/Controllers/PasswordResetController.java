package com.mang.grh.Controllers;


import com.mang.grh.Repositories.Registration.PasswordResetTokenRepository;
import com.mang.grh.Repositories.Registration.UserRepository;
import com.mang.grh.entities.Registration.PasswordResetToken;
import com.mang.grh.entities.Registration.User;
import com.mang.grh.services.Adminstration.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/reset")
public class PasswordResetController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    private PasswordEncoder passwordEncoder;

    public PasswordResetController(UserService userService, UserRepository userRepository, PasswordResetTokenRepository tokenRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        try {
            userService.sendEmail(userEmail, token);
        }catch(Exception ex ){ }
        return ResponseEntity.ok("Password reset email sent");
    }


    @PostMapping("/save-password")
    public ResponseEntity<String> savePassword(@RequestParam("token") String token, @RequestParam("password") String password) {
        PasswordResetToken passToken = tokenRepository.findByToken(token);
        if (passToken == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token");
        }
        if (passToken.getExpiryDate().before(new Date())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token has expired");
        }
        User user = passToken.getUser();
        System.out.println(passwordEncoder.encode(password));
        user.setPassword(passwordEncoder.encode(password)); // Ideally, encrypt the password here
        userRepository.save(user);
        return ResponseEntity.ok("Password updated successfully");
    }

}
