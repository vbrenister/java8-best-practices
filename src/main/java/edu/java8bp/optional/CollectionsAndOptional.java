package edu.java8bp.optional;

import edu.java8bp.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CollectionsAndOptional {
    public static final String ADMIN_ROLE = "admin";

    // Ugly
    class TooVerbose {

        public User findAnyAdmin() {
            Optional<List<User>> users = findUserByRole(ADMIN_ROLE);

            if (users.isPresent() && !users.get().isEmpty()) {
                return users.get().get(0);
            }

            throw new IllegalStateException("No admins found");
        }

        Optional<List<User>> findUserByRole(String role) {
            // real search in database
            return Optional.empty();
        }

    }

    // Good
    class NiceAndClean {

        public User findAnyAdmin() {
            return findUserByRole(ADMIN_ROLE)
                    .stream()
                    .findAny()
                    .orElseThrow(() -> new IllegalStateException("No admins found"));
        }

        List<User> findUserByRole(String role) {
            return Collections.emptyList();
        }
    }


}
