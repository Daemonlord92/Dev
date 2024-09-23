package com.blitmatthew.monster_trainer.exception;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String message){
        super(message);
    }
}
