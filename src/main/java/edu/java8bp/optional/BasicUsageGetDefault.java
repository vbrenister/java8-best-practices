package edu.java8bp.optional;

import edu.java8bp.User;

import java.util.Optional;

public class BasicUsageGetDefault {
    // Old
    class BeforeJava8 {
        public String getUserName(User user) {
            return (user != null && user.getName() != null) ? user.getName() : "default";
        }
    }

    // Ugly
    class UsingOptionalIsPresent {
        public String getUserName(User user) {
            if (Optional.ofNullable(user).isPresent()) {
                if (Optional.ofNullable(user.getName()).isPresent()) {
                    return user.getName();
                }
            }
            return "default";
        }
    }

    // Good
    class UsingOrElse {
        public String getUserName(User user) {
            return Optional.ofNullable(user)
                            .map(User::getName)
                            .orElse("default");
        }
    }
}
