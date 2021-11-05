package com.smart.dao;

import com.smart.entities.User;
import com.smart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserDaoImpl implements IUserDao{

    @Autowired
    private UserRepository userRepository;

    // Desc. finding All users
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Desc. Adding user
    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
