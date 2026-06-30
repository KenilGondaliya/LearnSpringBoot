package com.SpringCoreConcepts.demo;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    Database database;
    Configurations configurations;
    public UserService(Database database, Configurations configurations){
        this.database = database;
        this.configurations = configurations;
    };
    public void saveUser(String user){
        System.out.println("UserService is saving user: " + user + " with Property   " + configurations.getType());
        database.save(user);
    }
}
