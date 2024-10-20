package com.awesome.todoList.repositories;

import com.awesome.todoList.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    // Find a user by username
    Optional<AppUser> findByUserName(String userName);
}
