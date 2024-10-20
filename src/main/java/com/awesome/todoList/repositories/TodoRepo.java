package com.awesome.todoList.repositories;

import com.awesome.todoList.model.Todo;
import com.awesome.todoList.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepo extends JpaRepository<Todo, Integer> {

    //Retrieve To do lists for a user
    List<Todo> findByAppUser(AppUser appUser);
}
