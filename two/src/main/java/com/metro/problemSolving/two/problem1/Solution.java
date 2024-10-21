package com.metro.problemSolving.two.problem1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

    public static List<Car> getSuitableCar(List<Car> availableCars, Double price) {

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

    public static void main(String[] args) {

        // best cars list to customer based on need
        List<Car> list = new ArrayList<>();
        list.add(new Car(1l, Double.valueOf(1000), "Tata", "Tata Tiago", Double.valueOf(10.09), Double.valueOf(2.0)));
        list.add(new Car(12l, Double.valueOf(2000), "Tata", "Tata Tiago1", Double.valueOf(10.09), Double.valueOf(2.0)));
        list.add(new Car(14l, Double.valueOf(3000), "Tata", "Tata Tiago2", Double.valueOf(10.09), Double.valueOf(2.0)));
        System.out.println(getSuitableCar(list, Double.valueOf(1000)));

    }
}
