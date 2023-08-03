package org.example;

import java.util.List;

class OddIndexedNamesFormatter {

    public static String formatOddIndexedNames(List<String> names) {
        StringBuilder formattedNames = new StringBuilder();

        for (int i = 0; i < names.size(); i++) {
            // Check if the index is odd (1, 3, 5, ...)
            if (i % 2 == 1) {
                String name = names.get(i);
                formattedNames.append((i + 1) + ". " + name + ", ");
            }
        }

        // Remove the trailing comma and space from the last name
        if (formattedNames.length() > 0) {
            formattedNames.delete(formattedNames.length() - 2, formattedNames.length());
        }

        return formattedNames.toString();
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Alice", "Mark", "Sarah");
        String formattedOddIndexedNames = formatOddIndexedNames(names);
        System.out.println(formattedOddIndexedNames);
    }
}
