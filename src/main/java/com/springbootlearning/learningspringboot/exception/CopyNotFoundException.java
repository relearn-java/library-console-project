package com.springbootlearning.learningspringboot.exception;


public class CopyNotFoundException extends LibraryException {
    public CopyNotFoundException(Long copyId) {
        super("Exemplaire introuvable : " + copyId);
    }
}
