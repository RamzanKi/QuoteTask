package com.example.trialtask.service;

import com.example.trialtask.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(long id);
    public void deleteUser(long id);
    public User createUser(String email, String password, String name);
}
