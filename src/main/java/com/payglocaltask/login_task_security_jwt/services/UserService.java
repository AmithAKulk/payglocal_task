package com.payglocaltask.login_task_security_jwt.services;

import com.payglocaltask.login_task_security_jwt.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    void deleteUser(Long userId);
}