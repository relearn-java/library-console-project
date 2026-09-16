package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User,Long>{
    Optional<User> findByEmail(String email);
}
