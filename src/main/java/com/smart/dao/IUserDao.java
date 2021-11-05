package com.smart.dao;

import com.smart.entities.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IUserDao {
    public List<User> findAllUsers();

    User addUser(User u);

    Optional<User> findUserById(int id);

    void deleteUserById(int id);
}
