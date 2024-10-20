package com.awesome.todoList.exceptions;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String password){
        super(password);
    }
}
