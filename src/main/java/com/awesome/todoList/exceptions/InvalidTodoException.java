package com.awesome.todoList.exceptions;

public class InvalidTodoException extends RuntimeException {

    public InvalidTodoException(String todo) {
        super(todo);
    }
}
