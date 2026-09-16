package com.springbootlearning.learningspringboot.exception;


public class UserNotFoundException extends LibraryException {
    public UserNotFoundException(Long userId) {
        super("Utilisateur introuvable : " + userId);
    }
}
