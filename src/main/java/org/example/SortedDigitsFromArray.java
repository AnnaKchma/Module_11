package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedDigitsFromArray {

    public static String getSortedDigitsFromArray(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::valueOf)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
