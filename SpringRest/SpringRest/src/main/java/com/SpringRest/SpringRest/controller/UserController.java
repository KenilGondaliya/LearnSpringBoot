package com.SpringRest.SpringRest.controller;

import com.SpringRest.SpringRest.dto.CreateUserDto;
import com.SpringRest.SpringRest.dto.UserDto;
import com.SpringRest.SpringRest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.status(200).body(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        return  ResponseEntity.status(200).body(this.userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(200).body(userService.createUser(createUserDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody CreateUserDto updateUserDto, @PathVariable String id) {
        return ResponseEntity.status(200).body(userService.updateUser(updateUserDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
