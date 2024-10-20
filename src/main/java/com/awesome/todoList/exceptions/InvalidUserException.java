package com.awesome.todoList.exceptions;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String user){
        super(user);
    }
}
