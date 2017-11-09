package edu.java8bp.lambda;

import java.util.function.Function;

public class FunctionInterface {

//    private Function<String, Class> loader = s -> Class.forName(s);

//    private Runnable doSomething = () -> {
//        System.out.println("Doing something");
//        Thread.sleep(1000);
//    };

    private Function<String, Class> loader = uncheckFunction(s -> Class.forName(s));

    private Runnable doSomething = uncheckRunnable(() -> {
        System.out.println("Do something");
        Thread.sleep(1000);
    });

    private <T, R> Function<T, R> uncheckFunction(CheckedFunction<T, R> fn) {
        return t -> {
            try {
                return fn.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    private Runnable uncheckRunnable(CheckedRunnable fn) {
        return () -> {
            try {
                fn.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

}

@FunctionalInterface
interface CheckedRunnable {
    void run() throws Exception;
}

@FunctionalInterface
interface CheckedFunction<T, R> {
    R apply(T t) throws Exception;
}
