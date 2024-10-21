package com.awesome.todoList.controller;

import com.awesome.todoList.model.Todo;
import com.awesome.todoList.model.AppUser;
import com.awesome.todoList.services.TodoService;
import com.awesome.todoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    // Create a new To do
    @PostMapping("/{userId}")
    public ResponseEntity<Todo> createTodo(@PathVariable int userId,
                                           @RequestBody Todo newTodo) {
        AppUser appUser = userService.getUserById(userId); // To map user to Todo
        Todo createdTodo = todoService.createTodo(appUser, newTodo.getDescription());
        return ResponseEntity.ok(createdTodo);
    }

    // Get all Todos for a specific user
    @GetMapping("/{userId}")
    public ResponseEntity<List<Todo>> getTodosByUser(@PathVariable int userId) {
        AppUser appUser = userService.getUserById(userId); // Fetch todos if user id exists
        List<Todo> todos = todoService.getTodoListByUser(appUser);
        return ResponseEntity.ok(todos);
    }

    // Update To do status
    @PutMapping("/status/{todoId}")
    public ResponseEntity<Todo> updateTodoStatus(@PathVariable int todoId,
                                                 @RequestBody Todo updatedTodo) {
        Todo todoStatus = todoService.updateTodoStatus(todoId, updatedTodo);
        return ResponseEntity.ok(updatedTodo);
    }

    //Edit a To do
    @PutMapping("/edit/{todoId}")
    public ResponseEntity<Todo> editTodo(@PathVariable int todoId, @RequestBody Todo editedTodo) {
        Todo todo = todoService.editTodo(todoId, editedTodo);
        return ResponseEntity.ok(todo);
    }


    // Delete a To do task
    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.noContent().build();
    }
}
