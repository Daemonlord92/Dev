package com.blitmatthew.monster_trainer.service;

import com.blitmatthew.monster_trainer.config.JwtService;
import com.blitmatthew.monster_trainer.dto.AuthRequest;
import com.blitmatthew.monster_trainer.dto.PostNewUser;
import com.blitmatthew.monster_trainer.entity.UserCredential;
import com.blitmatthew.monster_trainer.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialServiceImpl implements UserCredentialService{

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(PostNewUser postNewUser) {
        UserCredential userCredential = new UserCredential();
        userCredential.setEmail(postNewUser.email());
        userCredential.setPassword(passwordEncoder.encode(postNewUser.password()));
        userCredential.setRoles(postNewUser.role());
        userCredentialRepository.save(userCredential);
    }

    @Override
    public String login(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authRequest.email(),
                authRequest.password()
        );
        authenticationManager.authenticate(authenticationToken);
        String jwt = jwtService.generateToken(authRequest.email());
        return jwt;
    }
}
