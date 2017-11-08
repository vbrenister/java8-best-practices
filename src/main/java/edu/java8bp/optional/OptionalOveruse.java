package edu.java8bp.optional;

import edu.java8bp.Role;

import java.util.Optional;

public class OptionalOveruse {

    // Ugly
    class NullProtectionOverEngineering {
        public Role copyRole(Role role) {
            Role copy = new Role();

            Optional.ofNullable(role.getName())
                    .ifPresent(copy::setName);

            copy.setPermissions(role.getPermissions());
            return copy;
        }
    }

    // Good
    class SimpleConditionalCopying {
        public Role copyRole(Role role) {
            Role copy = new Role();

            if (role.getName() != null) {
                copy.setName(role.getName());
            }

            copy.setPermissions(role.getPermissions());
            return copy;
        }
    }

}
