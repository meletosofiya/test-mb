package com.metro.problemSolving.two.problem4;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    /**
     * find a given string is balanced or not
     * <p>
     * Worst Case Time Complex: O(n) where n represents the input String length
     * Auxiliary Space: O(n)
     *
     * @param inputString
     * @return true or false
     */
    public static boolean findAGivenStringIsBalanced(String inputString) {

        Map<String, String> tagMapper = new HashMap<>();
        tagMapper.put("[", "]");
        tagMapper.put("{", "}");
        tagMapper.put("(", ")");

        Deque<String> data = new LinkedList<>();

        for (int i = 0; i < inputString.length(); i++) {
            if (tagMapper.containsKey(String.valueOf(inputString.charAt(i)))) {
                data.push(String.valueOf(inputString.charAt(i)));
            } else {
                if (tagMapper.get(data.pop()) == String.valueOf(inputString.charAt(i))) {
                    data.poll();
                }
            }

        }

        return data.size() == 0;
    }

    public static void main(String[] args) {

        // string is balanced or not
        System.out.println(findAGivenStringIsBalanced("[[}"));

    }
}
