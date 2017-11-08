package edu.java8bp.optional;

import edu.java8bp.User;

import java.util.Collections;
import java.util.Optional;

public class StrictCheckOfValuePressence {

    // Ugly
    class ManualCheckForPressenceToThrowException {
        public String getUserName(Long userId) {
            Optional<User> user = findById(userId);

            if (user.isPresent()) {
                return user.get().getName();
            }
            throw new IllegalStateException("User not found");
        }

        public void deleteUser(Long userId) {
            Optional<User> user = findById(userId);
            if (user.isPresent()) {
                delete(user.get());
            }
        }

        private void delete(User user) {
            // delete from database
        }
    }

    // Good
    class OrElseThrowUsage {
        public String getUserName(Long userId) {
            return findById(userId)
                    .orElseThrow(() -> new IllegalStateException("User not found"))
                    .getName();
        }

        public void deleteUser(Long userId) {
            findById(userId).ifPresent(this::delete);
        }

        private void delete(User user) {
            // delete from database
        }
    }

    private Optional<User> findById(Long userId) {
        //search in DB
        return Optional.of(new User(1L, "John Doe", 22, Collections.emptySet()));
    }


}
