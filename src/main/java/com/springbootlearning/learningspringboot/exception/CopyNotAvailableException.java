package com.springbootlearning.learningspringboot.exception;

public class CopyNotAvailableException extends LibraryException {
    public CopyNotAvailableException(Long copyId) {
        super("L'exemplaire " + copyId + " n'est pas disponible");
    }
}
