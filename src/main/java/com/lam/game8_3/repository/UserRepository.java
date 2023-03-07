package com.lam.game8_3.repository;

import com.lam.game8_3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByName(String name);
    User getUserByName(String name);
    User getUserById(Integer id);
}
