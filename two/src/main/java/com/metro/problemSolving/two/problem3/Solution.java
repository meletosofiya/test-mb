package com.metro.problemSolving.two.problem3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

    public static List<Advertisement> getProfitableAdvertisementInGivenPage(List<Advertisement> availableAdvertisement, Integer lengthOfSite) {

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

    public static void main(String[] args) {

        // profitable number of advertisement in a given height
        List<Advertisement> availableAdvertisement = new ArrayList<>();
        availableAdvertisement.add(new Advertisement("Ad1", Double.valueOf(20), 10, "Swiggy", "25% Offer For all product"));
        availableAdvertisement.add(new Advertisement("Ad2", Double.valueOf(20), 30, "EatSure ", "2% Offer For all product"));
        availableAdvertisement.add(new Advertisement("Ad3", Double.valueOf(20), 60, "BigBasket ", "Free delivery For all product"));
        System.out.println(getProfitableAdvertisementInGivenPage(availableAdvertisement, 10));

    }
}
