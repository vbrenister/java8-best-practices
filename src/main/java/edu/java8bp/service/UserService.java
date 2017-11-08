package edu.java8bp.service;

import edu.java8bp.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByName(String name);

}
