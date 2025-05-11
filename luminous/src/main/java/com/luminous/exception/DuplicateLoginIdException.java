package com.luminous.exception;

public class DuplicateLoginIdException extends RuntimeException {
	public DuplicateLoginIdException(String message) {
        super(message);
    }

}
