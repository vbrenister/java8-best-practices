package edu.java8bp.lambda;

import edu.java8bp.User;

import java.util.Optional;

public class LazyCalculationsImprovePerformance {
    private UserService userService;

    interface UserService {
        Optional<User> findByName(String name); // Get from database

        Optional<User> findByNameFromArchive(String name); // Get from archive database
    }

    // Bad
    class NoLazyCalculations {
        public User findByName(String name) {
            return userService
                    .findByName(name)
                    .orElse(userService
                            .findByNameFromArchive(name)
                            .orElseThrow(IllegalAccessError::new));
        }
    }

    // Good
    class UsingLazyCalculation {
        public User findByName(String name) {
            return userService
                    .findByName(name)
                    .orElseGet(() ->
                            userService
                                    .findByNameFromArchive(name)
                                    .orElseThrow(IllegalAccessError::new));
        }
    }

}
