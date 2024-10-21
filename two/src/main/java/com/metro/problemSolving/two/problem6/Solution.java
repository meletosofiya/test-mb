package com.metro.problemSolving.two.problem6;

import java.io.File;
import java.util.*;

public class Solution {


    /**
     * Search a file by using BFS
     * <p>
     * Worst Case Time Complex: O(n,2) where n represents the total files from root startPath
     * Auxiliary Space: O(n)
     *
     * @param startPath
     * @param fileName
     * @return found file path as optional
     */
    public static Optional<String> searchFile(String startPath, String fileName) {

        Deque<File> visitedStack = new LinkedList<>();
        File start = new File(startPath);
        if (start.isFile() && startPath.equalsIgnoreCase(fileName)) {
            return Optional.of(startPath);
        }

        while (visitedStack.size() != 0) {
            File visited = visitedStack.pop();
            File[] files = visited.listFiles();
            for (File file : files) {
                if (file.isFile() && file.getName().equalsIgnoreCase(fileName)) {
                    return Optional.of(file.getAbsolutePath());
                }
                visitedStack.push(file);
            }
        }
        return Optional.empty();
    }


    public static void main(String[] args) {

        // search a file by using BFS
        System.out.println(searchFile("C:/Users/abc/demo","test.txt"));

    }
}
