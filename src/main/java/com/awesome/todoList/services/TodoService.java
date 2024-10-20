package com.awesome.todoList.services;

import com.awesome.todoList.exceptions.InvalidTodoException;
import com.awesome.todoList.model.Todo;
import com.awesome.todoList.model.AppUser;
import com.awesome.todoList.repositories.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    public Todo createTodo(AppUser appUser, String description) {
        Todo todo = new Todo();
        todo.setDescription(description);
        todo.setStatus(false); // Ongoing task
        todo.setActive(true); // Existing (not deleted) task
        todo.setAppUser(appUser);
        return todoRepo.save(todo);
    }

    // Method to permanently delete a task
    public void deleteTodo(int todoId) {
        Todo todo = todoRepo.findById(todoId)
                .orElseThrow(() -> new InvalidTodoException("Good news! That Todo might have already been deleted."));
        todo.setActive(false); // Deleted To do Item
        todoRepo.delete(todo); //Permanent deletion of item
    }

    // Update the active or inactive status of a task
    public Todo updateTodoStatus(int todoId, boolean status) {
        Todo todo = todoRepo.findById(todoId)
                .orElseThrow(() -> new InvalidTodoException("Oh oh! That Todo might have already been deleted. No sweat, just create a new one if needed."));

        todo.setStatus(status); // Update the completion status
        return todoRepo.save(todo);
    }

    // Find all tasks for a specific user
    public List<Todo> getTodoListByUser(AppUser appUser) {
        return todoRepo.findByAppUser(appUser);
    }
}
