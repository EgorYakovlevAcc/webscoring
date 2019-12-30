package com.example.demo.exception;

public class NullMessageException extends MessageException {
    public NullMessageException() {
        setErrorCode("EX_001");
        setErrorMessage("Empty parameter is send. Please clearify list of necessary path variables");
    }
}
