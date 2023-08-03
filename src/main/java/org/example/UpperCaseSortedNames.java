package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpperCaseSortedNames {

    public static List<String> getUpperCaseSortedNames(List<String> names) {
        // Convert names to uppercase
        List<String> upperCaseNames = new ArrayList<>();
        for (String name : names) {
            upperCaseNames.add(name.toUpperCase());
        }

        // Sort names in descending order (Z to A)
        upperCaseNames.sort(Collections.reverseOrder());

        return upperCaseNames;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Alice", "Mark", "Sarah");
        List<String> upperCaseSortedNames = getUpperCaseSortedNames(names);
        System.out.println(upperCaseSortedNames);
    }
}
