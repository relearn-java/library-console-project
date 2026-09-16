package com.springbootlearning.learningspringboot.exception;


public class UserSuspendedException extends LibraryException {
    public UserSuspendedException(Long userId) {
        super("L'utilisateur " + userId + " est suspendu");
    }
}
