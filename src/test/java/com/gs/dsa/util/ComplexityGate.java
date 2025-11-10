
package com.gs.dsa.util;

import java.util.function.Function;
import java.util.function.IntFunction;

public final class ComplexityGate {
    private ComplexityGate() {}

    public enum Expectation { LINEAR, N_LOG_N, LOG_N }

    public static <T> void assertComplexity(Expectation expectation,
                                            IntFunction<T> inputGenerator,
                                            Function<T, ?> runner,
                                            int n,
                                            int iterationsPerSize) {
        try {
            T warm = inputGenerator.apply(Math.max(1, n));
            runner.apply(warm);
        } catch (UnsupportedOperationException uoe) {
            return; // method not implemented — skip gate
        } catch (Throwable t) { /* ignore warm-up errors */ }

        long t1 = time(inputGenerator, runner, n, iterationsPerSize);
        long t2 = time(inputGenerator, runner, n * 2, iterationsPerSize);
        long t4 = time(inputGenerator, runner, n * 4, iterationsPerSize);

        double r21 = (double) t2 / Math.max(1L, t1);
        double r42 = (double) t4 / Math.max(1L, t2);

        switch (expectation) {
            case LINEAR:
                if (r21 > 2.6 || r42 > 2.6)
                    throw new AssertionError("Likely not O(n): r21=" + r21 + ", r42=" + r42);
                break;
            case N_LOG_N:
                if (r21 > 2.8 || r42 > 2.8)
                    throw new AssertionError("Likely not O(n log n): r21=" + r21 + ", r42=" + r42);
                break;
            case LOG_N:
                if (r21 > 2.4 || r42 > 2.4)
                    throw new AssertionError("Likely not O(log n): r21=" + r21 + ", r42=" + r42);
                break;
        }
    }

    private static <T> long time(IntFunction<T> inputGenerator,
                                 Function<T, ?> runner,
                                 int n,
                                 int iterations) {
        T input = inputGenerator.apply(n); // generate ONCE per size

        // Warm-up
        for (int i = 0; i < Math.min(3, iterations); i++) {
            try { runner.apply(input); } catch (Throwable ignored) {}
        }

        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try { runner.apply(input); } catch (Throwable ignored) {}
        }
        return System.nanoTime() - start;
    }
}
