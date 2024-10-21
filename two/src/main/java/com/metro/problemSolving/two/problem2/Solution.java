package com.metro.problemSolving.two.problem2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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
    public static List<Stock> getProfitableStock(List<Stock> availableStock, Double profit) {
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

    public static void main(String[] args) {

        // profitable stocks based on price
        List<Stock> availableStock = new ArrayList<>();
        availableStock.add(new Stock("34A56598", "SpiceJet ", Double.valueOf(1000000000), 200l, Double.valueOf(50.5)));
        availableStock.add(new Stock("34A56598", "Bajaj ", Double.valueOf(100000000), 205l, Double.valueOf(50.1)));
        availableStock.add(new Stock("34A55598", "Wipro ", Double.valueOf(1000000000), 20l, Double.valueOf(10.5)));
        System.out.println(getProfitableStock(availableStock, Double.valueOf(50)));

    }
}
