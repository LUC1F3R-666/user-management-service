package com.starter.usermanagement.controller;

import com.starter.usermanagement.model.User;
import com.starter.usermanagement.service.UserService;
import java.util.List;
import com.starter.usermanagement.dto.UserRequest;
import com.starter.usermanagement.dto.UserResponse;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserResponse> getUsers(Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @PatchMapping("/{id}")
    public UserResponse patchUser(@PathVariable Long id,
                             @RequestBody UserRequest request) {
        return userService.patchUser(id, request);
    }
    
    @GetMapping("/search")
    public Page<UserResponse> searchUsers(@RequestParam String query,
                                      Pageable pageable) {
        return userService.searchUsers(query, pageable);
    }


}

