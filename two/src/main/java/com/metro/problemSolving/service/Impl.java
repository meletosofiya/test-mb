package com.metro.problemSolving.service;

import com.metro.problemSolving.entity.Advertisement;
import com.metro.problemSolving.entity.Car;
import com.metro.problemSolving.entity.Stock;

import java.io.File;
import java.util.*;

public class Impl {

    /**
     * provide a best cars list to customer based on need ,
     * uses Greedy Algorithm
     * 1)Finds Best result in every Stage
     * 2) Add to final Solution
     * Repeat from Step 1)
     * <p>
     * Worst Case Scenario Time Complexity  O(n Log(n,2))
     * Auxiliary Space (not including Input Space):   O(n)
     *
     * @param availableCars available cars from which activities have to be chosen
     * @param price         minimum required price
     * @return available cars based on price
     */

    public List<Car> getSuitableCar(List<Car> availableCars, Double price) {

        List<Car> desiredCarsBasedOnPrice = new ArrayList<>(availableCars.size());
        // sorting in ascending order
        List<Car> sortedCarsBasedOnPrice = availableCars.stream().sorted((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice())).toList();
        // finding possible solution in each stage
        for (Car car : sortedCarsBasedOnPrice) {
            if (car.getPrice() <= price) {
                desiredCarsBasedOnPrice.add(car);
            } else {
                return desiredCarsBasedOnPrice;
            }
        }
        return desiredCarsBasedOnPrice;
    }


    /**
     * find the profitable stocks based on price
     * uses Greedy Algorithm
     * 1) Finds Best result in every Stage
     * 2) Add to final Solution
     * Repeat from Step 1)
     * <p>
     * Worst Case Scenario Time Complexity  O(n Log(n,2)) where n is the length of available Stock collection
     * Auxiliary Space (not including Input Space):   O(n)
     *
     * @param availableStock available stock
     * @param profit         available profit
     * @return List of Stocks in car
     */
    public List<Stock> getProfitableStock(List<Stock> availableStock, Double profit) {
        List<Stock> maxProfitableStock = new ArrayList<>(availableStock.size());
        // sorting in ascending order
        List<Stock> sortedCarsBasedOnPrice = availableStock.stream().sorted((o1, o2) -> Double.compare(o1.getTotalExpectedProfitPerMonth(), o2.getTotalExpectedProfitPerMonth())).toList();
        System.out.println(sortedCarsBasedOnPrice);
        // finding possible solution in each stage
        for (Stock stock : sortedCarsBasedOnPrice) {
            if (stock.getTotalExpectedProfitPerMonth() <= profit) {
                maxProfitableStock.add(stock);
            } else {
                return maxProfitableStock;
            }
        }
        System.out.println("Desired Cars Based On profit" + maxProfitableStock);
        return maxProfitableStock;
    }


    /**
     * get profitable number of advertisement in a given height,
     * uses Greedy Algorithm
     * 1)Finds Best result in every Stage
     * 2) Add to final Solution
     * Repeat from Step 1)
     * <p>
     * Worst Case Scenario Time Complexity  O(n Log(n,2))
     * Best Case Scenario Time Complexity O(n Log(n,2))
     * Average Case Scenario Time Complexity O(n Log(n,2))
     * Auxiliary Space (not including Input Space):   O(n)
     *
     * @param availableAdvertisement available advertisement
     * @param lengthOfSite           length of site
     * @return list of profitable advertisement
     */

    public List<Advertisement> getProfitableAdvertisementInGivenPage(List<Advertisement> availableAdvertisement, Integer lengthOfSite) {

        List<Advertisement> sortedAdvertisement = availableAdvertisement.stream().sorted((o1, o2) -> o1.getHeight() - o2.getHeight()).toList();
        Integer bestCombination = 0;
        List<Advertisement> bestProfitableAdvertisement = new ArrayList<>(availableAdvertisement.size());

        for (int i = 0; i < sortedAdvertisement.size(); i++) {
            Integer result = 0;
            List<Advertisement> profitableAdvertisement = new ArrayList<>(availableAdvertisement.size());
            for (int j = i + 1; j < sortedAdvertisement.size(); i++) {
                result += sortedAdvertisement.get(j).getHeight();
                profitableAdvertisement.add(sortedAdvertisement.get(j));
                if (result == lengthOfSite || result > lengthOfSite) {
                    if (result == lengthOfSite) {
                        System.out.println(profitableAdvertisement);

                        if (bestCombination < profitableAdvertisement.size()) {
                            bestCombination = profitableAdvertisement.size();
                            bestProfitableAdvertisement.addAll(profitableAdvertisement);
                        }
                    }
                    break;
                }

            }

        }

        return bestProfitableAdvertisement;
    }

    /**
     * find a given string is balanced or not
     * <p>
     * Worst Case Time Complex: O(n) where n represents the input String length
     * Auxiliary Space: O(n)
     *
     * @param inputString
     * @return true or false
     */
    public boolean findAGivenStringIsBalanced(String inputString) {

        Map<String, String> tagMapper = new HashMap<>();
        tagMapper.put("[", "]");
        tagMapper.put("{", "}");
        tagMapper.put("(", ")");

        Deque<String> data = new LinkedList<>();

        for (int i = 0; i < inputString.length(); i++) {
            if (tagMapper.keySet().contains(inputString.charAt(i) + "")) {
                data.push(inputString.charAt(i) + "");
            } else {
                if (tagMapper.get(data.pop()) == inputString.charAt(i) + "") {
                    data.poll();
                }
            }

        }

        if (data.size() == 0)
            return true;
        return false;
    }


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
    public Optional<String> searchFile(String startPath, String fileName) {

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


    /**
     * Print a vowels start end with in string combination
     * <p>
     * Best Case : O(1)
     * Worst Case Time Complex: O(n * n!) where n represents for loop and n! represents factorial
     * Auxiliary Space: O(n)
     *
     * @param input string
     * @param output string
     * @return void
     */
    public void printVowelsStringCombination(String input, String output) {

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


}
