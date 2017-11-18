package edu.java8bp.streams;

import edu.java8bp.User;

import java.util.Collection;
import java.util.Objects;

import static java.util.Optional.ofNullable;

public class SameOldCodeStyleWithNewConstructs {
    // Ugly
    class NoMoreThanSameOldLoopWithIf {
        public void registerUsers(Collection<User> users) {
            users.stream().forEach(user ->
                    ofNullable(user).ifPresent(u -> {
                        //register user
                    })
            );
        }
    }

    // Good
    class NewStreamStyleWithMethodReference {
        public void registerUsers(Collection<User> users) {
            users.stream()
                    .filter(Objects::nonNull)
                    .forEach(this::registerUser);
        }

        private void registerUser(User user) {
            //register user
        }
    }
}
