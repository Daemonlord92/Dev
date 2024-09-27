package com.blitmatthew.monster_trainer.service;

import com.blitmatthew.monster_trainer.dto.AuthRequest;
import com.blitmatthew.monster_trainer.dto.PostNewUser;

public interface UserCredentialService {
    void createUser(PostNewUser postNewUser);
    String login(AuthRequest authRequest);
}
