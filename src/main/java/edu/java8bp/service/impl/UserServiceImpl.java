package edu.java8bp.service.impl;

import edu.java8bp.model.User;
import edu.java8bp.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> findByName(String name) {
        return Optional.of(new User("John", 22));
    }
}
