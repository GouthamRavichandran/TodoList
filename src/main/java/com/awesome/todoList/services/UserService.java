package com.awesome.todoList.services;

import com.awesome.todoList.exceptions.InvalidPasswordException;
import com.awesome.todoList.exceptions.InvalidUserException;
import com.awesome.todoList.model.AppUser;
import com.awesome.todoList.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AppUserRepo appUserRepo;

    //User login method
    public AppUser userLogin(String userName, String password) {
        //Invalid or no such user
        AppUser appUser = appUserRepo.findByUserName(userName)
                .orElseThrow(() -> new InvalidUserException("No such User found."));

        // Password error
        if (!appUser.getPassword().equals(password)) {
            throw new InvalidPasswordException("Password invalid. Please try again.");
        }

        // Return User after successful login
        return appUser;
    }

    // Find user by id
    public AppUser getUserById(int userId) {
        return appUserRepo.findById(userId)
                .orElseThrow(() -> new InvalidUserException("No such User found."));
    }
}
