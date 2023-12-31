package org.example;

import java.util.stream.Stream;

public class LinearCongruentialGenerator {

    public static Stream<Long> generateStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (1L << 48);

        long seed = 42L;
        Stream<Long> generatedStream = generateStream(seed, a, c, m);

        long sum = generatedStream.limit(10).mapToLong(Long::longValue).sum();

        System.out.println("Sum of the first 10 elements: " + sum);
    }
}
