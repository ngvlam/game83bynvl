package com.lam.game8_3.service;

import com.lam.game8_3.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User saveUser(User user);

    public Boolean isExistsUser(String name);
    public User getUserByName(String name);
    public User getUserById(Integer id);
}
