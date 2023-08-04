package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedDigitsFromArray {

    public static String getSortedDigitsFromArray(String[] array) {
        Stream<Integer> digitStream = Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::valueOf)
                .sorted();

        return digitStream.map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        String[] array = { "1, 2, 0", "4, 5" };
        String sortedDigits = getSortedDigitsFromArray(array);
        System.out.println(sortedDigits);
    }
}
