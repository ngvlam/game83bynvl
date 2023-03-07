package com.lam.game8_3.service.impl;

import com.lam.game8_3.model.User;
import com.lam.game8_3.repository.UserRepository;
import com.lam.game8_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean isExistsUser(String name) {
        return userRepository.existsByName(name);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

}
