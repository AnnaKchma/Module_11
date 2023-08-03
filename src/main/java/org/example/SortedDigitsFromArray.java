package org.example;

import java.util.ArrayList;
import java.util.List;

public class SortedDigitsFromArray {

    public static String getSortedDigitsFromArray(String[] array) {
        // Combine all elements into a single string
        StringBuilder combinedString = new StringBuilder();
        for (String element : array) {
            combinedString.append(element);
        }

        List<Integer> digits = new ArrayList<>();
        for (char ch : combinedString.toString().toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.add(Character.getNumericValue(ch));
            }
        }

        // Sort the digits
        digits.sort(Integer::compareTo);

        var sortedStrings = new ArrayList<String>();
        for (int digit : digits) {
            sortedStrings.add(String.valueOf(digit));
        }

        return String.join(", ", sortedStrings);
    }

    public static void main(String[] args) {
        String[] array = { "1, 2, 0", "4, 5" };
        String sortedDigits = getSortedDigitsFromArray(array);
        System.out.println(sortedDigits);
    }
}
