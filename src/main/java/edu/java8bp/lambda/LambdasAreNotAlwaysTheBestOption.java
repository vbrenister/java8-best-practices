package edu.java8bp.lambda;

import java.util.Optional;

public class LambdasAreNotAlwaysTheBestOption {

    // Ugly
    class UneededLambdasUsage {
        public void processAndPrint(String name) {
            Optional.ofNullable(name)
                    .map(s -> s.toLowerCase())
                    .map(s -> doProcess(s))
                    .ifPresent(s -> System.out.println(s));
        }

        private String doProcess(String name) {
            return "Mr. " + name;
        }
    }

    // Good
    class ReplaceWithMethodReference {
        public void processAndPrint(String name) {
            Optional.ofNullable(name)
                    .map(String::toLowerCase)
                    .map(this::doProcess)
                    .ifPresent(System.out::println);
        }

        private String doProcess(String name) {
            return "Mr. " + name;
        }
    }

}
