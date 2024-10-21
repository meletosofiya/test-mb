package com.metro.problemSolving.two.problem5;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Print a vowels start end with in string combination
     * <p>
     * Best Case : O(1)
     * Worst Case Time Complex: O(n * n!) where n represents for loop and n! represents factorial
     * Auxiliary Space: O(n)
     *
     * @param input  string
     * @param output string
     * @return void
     */
    public static void printVowelsStringCombination(String input, String output) {

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        // If string is empty && Contain Vowels at start end
        if (input.length() == 0 && vowels.contains(output.charAt(0)) && vowels.contains(output.charAt(output.length() - 1))) {
            System.out.println(output);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            // Recursive call
            printVowelsStringCombination(input.substring(0, i) +
                    input.substring(i + 1), output + input.charAt(i));
        }


    }


    public static void main(String[] args) {

        // vowels start end with in string combination
        printVowelsStringCombination("abc", "");

    }
}
