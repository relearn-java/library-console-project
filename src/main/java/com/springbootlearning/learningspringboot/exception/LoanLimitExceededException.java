package com.springbootlearning.learningspringboot.exception;


public class LoanLimitExceededException extends LibraryException {
    public LoanLimitExceededException(int limit) {
        super("Limite d'emprunts atteinte (" + limit + " maximum)");
    }
}