package com.SpringRest.SpringRest.service;

import com.SpringRest.SpringRest.dto.CreateUserDto;
import com.SpringRest.SpringRest.dto.UserDto;
import com.SpringRest.SpringRest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDto getUserById(String id) {
        return userRepository.findUserById(id);
    }

    public UserDto createUser(CreateUserDto createUserDto) {
        return userRepository.save(createUserDto);
    }

    public UserDto updateUser(CreateUserDto updateUserDto, String id) {
        if (userRepository.findUserById(id) == null) return null;
        return userRepository.update(updateUserDto, id);
    }

    public void deleteUserById(String id) {
        if (userRepository.findUserById(id) == null) return;
        userRepository.delete(id);
    }
}
