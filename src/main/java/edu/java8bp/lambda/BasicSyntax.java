package edu.java8bp.lambda;

import edu.java8bp.User;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

import static edu.java8bp.lambda.BasicSyntax.Uncheck.uncheckRunnable;

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


//    private Function<String, Class> loader = s -> Class.forName(s);

    static final class Uncheck {
        interface UncheckedFunction<T, R> {
            R apply(T t) throws Exception;
        }

        interface UncheckedRunnable {
            void run() throws Exception;
        }

        static public Function<String, Class> uncheckFunction(Uncheck.UncheckedFunction<String, Class> withException) {
            return s -> {
                try {
                    return withException.apply(s);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };
        }

        static public Runnable uncheckRunnable(Uncheck.UncheckedRunnable withException) {
            return () -> {
                try {
                    withException.run();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };
        }
    }


    private Function<String, Class> checkedLoader = Uncheck.uncheckFunction(s -> Class.forName(s));

    private void doSomething() {
        uncheckRunnable(() -> {
            System.out.println("Doing something");
            Thread.sleep(1000);
        });
    }
}
