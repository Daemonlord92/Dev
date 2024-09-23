package com.blitmatthew.monster_trainer.config;

import com.blitmatthew.monster_trainer.exception.UserNotFoundException;
import com.blitmatthew.monster_trainer.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class ApplicationConfig {
    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userCredentialRepository.findByEmail(username).orElseThrow(() -> {
           throw new UserNotFoundException("User with email of " + username + " not found!");
        });
    }
}
