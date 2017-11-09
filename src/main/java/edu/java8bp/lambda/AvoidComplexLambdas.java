package edu.java8bp.lambda;

import edu.java8bp.Permission;
import edu.java8bp.Role;
import edu.java8bp.User;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AvoidComplexLambdas {

    private final Set<User> users = new HashSet<>();

    // Ugly
    class UsingComplexLambdaInPlace {
        public Set<User> findEditors() {
            return users.stream()
                    .filter(u ->
                            u.getRoles()
                                    .stream()
                                    .anyMatch(r -> r.getPermissions().contains(Permission.EDIT)))
                    .collect(Collectors.toSet());
        }
    }


    // Good
    class ComplexityExtractToMethod {
        public Set<User> findEditors() {
            return users.stream()
                    .filter(hasPermission(Permission.EDIT))
//                    .filter(this::hasEditPermission)
                    .collect(Collectors.toSet());
        }

        private Predicate<User> hasPermission(Permission permission) {
            return user -> user.getRoles().stream().map(Role::getPermissions)
                    .anyMatch(p -> p.contains(permission));
        }

        private boolean hasEditPermission(User user) {
            return hasPermission(Permission.EDIT).test(user);
        }
    }

}
