package com.SpringRest.SpringRest.repository;

import com.SpringRest.SpringRest.dto.CreateUserDto;
import com.SpringRest.SpringRest.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class UserRepository {
    List<UserDto> users = new ArrayList<>();

    public UserRepository() {
        users.add(new UserDto(UUID.randomUUID().toString(),"Kenil", "kenilgondaliya@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(),"Deep", "deepandghan@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(),"Darshit", "darshitsavaj@gmail.com"));
    }

    public List<UserDto> findAll(){
        return this.users;
    }

    public UserDto findUserById(String id) {
        for (UserDto user: users){
            if (Objects.equals(user.getId(),id)){
                return user;
            }
        }
        return null;
    }

    public UserDto save(CreateUserDto createUserDto) {
        UserDto user = new UserDto(UUID.randomUUID().toString(), createUserDto.getName(), createUserDto.getEmail());
        users.add(user);
        return user;
    }

    public UserDto update(CreateUserDto updateUserDto, String id) {
        UserDto user = findUserById(id);
        if (user != null) {
            user.setName(updateUserDto.getName());
            user.setEmail(updateUserDto.getEmail());
            return user;
        }
        return null;
    }

    public void delete(String id) {
        users.removeIf(userDto -> userDto.getId().equals(id));
    }
}