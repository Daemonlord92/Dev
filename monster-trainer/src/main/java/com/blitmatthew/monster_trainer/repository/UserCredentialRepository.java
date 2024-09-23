package com.blitmatthew.monster_trainer.repository;

import com.blitmatthew.monster_trainer.entity.UserCredential;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserCredentialRepository extends ListCrudRepository<UserCredential, Long> {
    Optional<UserCredential> findByEmail(String email);
}
