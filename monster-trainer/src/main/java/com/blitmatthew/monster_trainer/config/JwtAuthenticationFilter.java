package com.blitmatthew.monster_trainer.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        //Pulling the Authorization Header out of the request head
        final String authHeader = request.getHeader("Authorization");
        final String jwt, username;

        //if the Authorization header is null or doesn't start with the Bearer keyword it pass
        //back to the SecurityFilterChain
        if(authHeader == null || !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request,response);
            return;
        }

        //Here we will separate the JWT from the extra keyword, so we can verify the token
        jwt = authHeader.substring(7);
        //Extracting the Username from the JWT Payload
        username = jwtService.extractUsername(jwt);
        //if Username is not null and SecurityContextHolder is not holding an authorization
        //start the process setting up a new SecurityContext
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            //Checking to see if the JWT token is Valid by username and by Expiration
            if(jwtService.isTokenValid(jwt, userDetails)) {
                //Creating an AuthenticationToken to be used to tell the app what this user can do
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails.getUsername(), null, userDetails.getAuthorities()
                );
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                //Creating the SecurityContext with the AuthenticationToken to tell what the user can do
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        //Returning back to the SecurityFilterChain
        filterChain.doFilter(request, response);
    }
}
