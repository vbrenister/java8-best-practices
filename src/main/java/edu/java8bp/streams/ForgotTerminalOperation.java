package edu.java8bp.streams;

import java.util.stream.IntStream;

public class ForgotTerminalOperation {
    // Bad
    public void willDoNothingInReality() {
        IntStream.range(1, 5)
                .peek(System.out::println)
                .peek(i -> {
                    if (i == 5)
                        throw new RuntimeException("bang");
                });
    }
}
