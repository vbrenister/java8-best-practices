package edu.java8bp.lambda;

import edu.java8bp.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListSorting {

    // Verbose
    class BeforeJava8 {
        public void sortUsersByAge(List<User> users) {
            Collections.sort(users, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return Integer.compare(o1.getAge(), o2.getAge());
                }
            });
        }
    }

    // Ugly
    class UsingLambda {
        public void sortUsersByAge(List<User> users) {
            users.sort((o1, o2) -> Long.compare(o1.getAge(), o2.getAge()));
        }
    }

    // Good
    class UsingExistingComparators {
        public void sortUsersByAge(List<User> users) {
            users.sort(Comparator.comparingLong(User::getAge));
        }
    }

    // Good?
    class UsingStreamSort {
        public List<User> getSortedUsersByAge(List<User> users) {
            return users
                    .stream()
                    .sorted() // Does it work ???
                    .collect(Collectors.toList());
        }
    }

    // Good
    class UsingStreamSortWithComparator {
        public List<User> getSortedUsersByAge(List<User> users) {
            return users
                    .stream()
                    .sorted(Comparator
                            .comparing(User::getName)
                            .thenComparing(User::getId)
                            .reversed()
                    )
                    .collect(Collectors.toList());
        }
    }
}
