package com.springbootlearning.learningspringboot.exception;


public class LibraryException extends RuntimeException {
    public LibraryException(String message) {
        super(message);
    }
}