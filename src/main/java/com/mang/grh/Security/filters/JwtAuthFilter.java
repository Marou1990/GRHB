package com.mang.grh.Security.filters;

import java.io.IOException;

import com.mang.grh.Security.services.JwtService;
import com.mang.grh.Security.services.UserInfoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {


    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserInfoUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("2-> attemptAuthentification");
        String token = null;
        String username = null;
        String header = request.getHeader("Authorization");
        System.out.println("--doFilterInternal header::  "+header);
        //System.out.println("--doFilterInternal header.startsWith::  "+header.startsWith("Bearer "));
        if(null != header && header.startsWith("Bearer ")) {
            token = header.substring(7);
            username = jwtService.extractUsername(token);
        }

        if(null != username && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("3-> loadUserByUsername : jwt filter --> userdetailservice");
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            System.out.println("6-> get the user and roles ");
            System.out.println("7-> cheek password ");
            if(jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                userToken.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userToken);
                System.out.println("8-> successfull authentification ");
            }
        }
        filterChain.doFilter(request, response);
    }
}
