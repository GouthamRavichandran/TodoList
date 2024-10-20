package com.awesome.todoList.controller;

import com.awesome.todoList.model.AppUser;
import com.awesome.todoList.model.LoginRequest;
import com.awesome.todoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AppUserController {

        @Autowired
        private UserService userService;

        public AppUserController(UserService userService) {
            this.userService = userService;
        }

    @PostMapping("/login")
    public ResponseEntity<AppUser> loginUser(@RequestBody LoginRequest loginRequest) {
        AppUser appUser = userService.userLogin(loginRequest.getUserName(), loginRequest.getPassword());
        return ResponseEntity.ok(appUser);
    }
}
