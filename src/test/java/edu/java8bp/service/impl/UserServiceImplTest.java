package edu.java8bp.service.impl;

import edu.java8bp.model.User;
import edu.java8bp.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void shouldCorrectlyFindByName() {

        Optional<User> found = userService.findByName("dasd");

        assertThat(found).hasValueSatisfying(user ->
            assertThat(user).isEqualTo(new User("John", 22))
        );
    }

}