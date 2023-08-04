package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseSortedNames {

    public static List<String> getUpperCaseSortedNames(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted((name1, name2) -> name2.compareTo(name1)) // Sort in descending order
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Alice", "Mark", "Sarah");
        List<String> upperCaseSortedNames = getUpperCaseSortedNames(names);
        System.out.println(upperCaseSortedNames);
    }
}