package edu.java8bp.streams;


import edu.java8bp.User;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AvoidLoopsInStreams {
    private final Set<User> users = new HashSet<>();

    // Ugly
    class UseExternalCounter {
        public double countAverageRolesPerUser() {
            if (users.isEmpty()) {
                return 0;
            }
            AtomicInteger totalCount = new AtomicInteger();
            users.forEach(u -> totalCount.addAndGet(u.getRoles().size()));
            return totalCount.doubleValue() / users.size();
        }
    }
    
    // Good
    class ApplyMappingsToTargetType {
        public double countAverageRolesPerUser() {
            return users.stream()
                    .mapToDouble(u -> u.getRoles().size())
                    .average()
                    .orElse(0);
        }
    }
}
