package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User findUserById(Long id);
    User findUserByUsername(String username);
    void delete (User user);
    void deleteUserById(Long id);
    void save(User user);
}
