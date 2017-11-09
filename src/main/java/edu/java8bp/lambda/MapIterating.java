package edu.java8bp.lambda;

import edu.java8bp.User;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapIterating {

    // Ugly
    class UsingOldGoodEntrySet {
        public Map<String, String> getUserNames(Map<String, User> users) {
            Map<String, String> userNames = new HashMap<>();

            users.entrySet().forEach(user ->
                    userNames.put(user.getKey(), user.getValue().getName()));

            return userNames;
        }
    }

    // Good
    class UsingMapForEach {
        public Map<String, String> getUserNames(Map<String, String> users) {
            Map<String, String> userNames = new HashMap<>();
            users.forEach((key, value) -> userNames.put(key, value));
//            users.forEach(userNames::put);
            return userNames;
        }
    }

    // Good
    class UsingMapTransform {
        public Map<String, String> getUserNames(Map<String, User> users) {
            return users.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getName()));
        }
    }
}
