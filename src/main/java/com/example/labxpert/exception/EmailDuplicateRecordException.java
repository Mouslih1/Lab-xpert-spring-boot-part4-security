package com.example.labxpert.exception;

public class EmailDuplicateRecordException extends RuntimeException {
    public EmailDuplicateRecordException(String message){
        super(message);
    }
}
