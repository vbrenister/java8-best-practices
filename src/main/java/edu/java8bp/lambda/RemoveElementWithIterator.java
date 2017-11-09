package edu.java8bp.lambda;

import edu.java8bp.Permission;
import edu.java8bp.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class RemoveElementWithIterator {
    private final Set<User> users = new HashSet<>();


    // Old and Ugly
    class RemoveElementUsingIterator {
        public void removeUsersWithPermission(Permission permission) {
            Iterator<User> iterator = users.iterator();

            while (iterator.hasNext()) {
                User user = iterator.next();
                if (hasRoleWithPermission(user, permission)) {
                    iterator.remove();
                }
            }
        }

        private boolean hasRoleWithPermission(User user, Permission permission) {
            return user.getRoles()
                    .stream()
                    .anyMatch(r -> r.getPermissions().contains(permission));
        }
    }

    // Good
    class RemoveWithPredicate {
        public void removeUsersWithPermission(Permission permission) {
            users.removeIf(hasRoleWithPermission(permission));
        }

        Predicate<User> hasRoleWithPermission(Permission permission) {
            return u -> u.getRoles()
                    .stream()
                    .anyMatch(r -> r.getPermissions().contains(permission));
        }
    }


}
