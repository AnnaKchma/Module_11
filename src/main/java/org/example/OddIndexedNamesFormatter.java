package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddIndexedNamesFormatter {

    public static String formatOddIndexedNames(List<String> names) {
        List<String> oddIndexedNames = IntStream.range(1, names.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.toList());

        return String.join(", ", oddIndexedNames);
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Alice", "Mark", "Sarah");
        String formattedOddIndexedNames = formatOddIndexedNames(names);
        System.out.println(formattedOddIndexedNames);
    }
}