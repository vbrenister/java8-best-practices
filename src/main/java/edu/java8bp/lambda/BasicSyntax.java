package edu.java8bp.lambda;

import edu.java8bp.User;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class BasicSyntax {

    // Verbose
    private Comparator<User> oldStyle = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            return u1.getName().compareTo(u2.getName());
        }
    };

    // Code noise
    private Comparator<User> explicitTypes = (User u1, User u2) -> u1.getName().compareTo(u2.getName());

    // Prefer
    private Comparator<User> inferTypes = (u1, u2) -> u1.getName().compareTo(u2.getName());

    // Code noise
    private Predicate<User> uselessPara = (users) -> users.getAge() > 20;

    // Prefer
    private Predicate<User> cleanPredicate = users -> users.getAge() > 20;

    // Code noise
    private Predicate<User> explicitReturn = users -> {
        boolean result = users.getAge() > 20;
        return result;
    };

    // Redundant
    private Function<String, String> toLowerCase = s -> s.toLowerCase();

    // Prefer
    private Function<String, String> toLowerCaseMethodRef = String::toLowerCase;

}
