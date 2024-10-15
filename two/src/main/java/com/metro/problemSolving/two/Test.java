package com.metro.problemSolving.two;

import com.metro.problemSolving.entity.Advertisement;
import com.metro.problemSolving.entity.Car;
import com.metro.problemSolving.entity.Stock;
import com.metro.problemSolving.service.Impl;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {


        // best cars list to customer based on need
        Impl impl = new Impl();
        List<Car> list = new ArrayList<>();
        list.add(new Car(1l, Double.valueOf(1000), "Tata", "Tata Tiago", Double.valueOf(10.09), Double.valueOf(2.0)));
        list.add(new Car(1l, Double.valueOf(1000), "Tata", "Tata Tiago", Double.valueOf(10.09), Double.valueOf(2.0)));
        list.add(new Car(1l, Double.valueOf(1000), "Tata", "Tata Tiago", Double.valueOf(10.09), Double.valueOf(2.0)));
        System.out.println(impl.getSuitableCar(list, Double.valueOf(1000)));


        // profitable stocks based on price
        List<Stock> availableStock = new ArrayList<>();
        availableStock.add(new Stock("34A56598","SpiceJet ",Double.valueOf(1000000000),200l,Double.valueOf(50.5)));
        availableStock.add(new Stock("34A56598","Bajaj ",Double.valueOf(100000000),205l,Double.valueOf(50.1)));
        availableStock.add(new Stock("34A55598","Wipro ",Double.valueOf(1000000000),20l,Double.valueOf(10.5)));

        System.out.println( impl.getProfitableStock( availableStock, Double.valueOf(50)));


        // profitable number of advertisement in a given height

        List<Advertisement> availableAdvertisement = new ArrayList<>();
        availableAdvertisement.add(new Advertisement("Ad1",Double.valueOf(20),10,"Swiggy","25% Offer For all product"));
        availableAdvertisement.add(new Advertisement("Ad2",Double.valueOf(20),30,"EatSure ","2% Offer For all product"));
        availableAdvertisement.add(new Advertisement("Ad3",Double.valueOf(20),60,"BigBasket ","Free delivery For all product"));

        System.out.println(impl.getProfitableAdvertisementInGivenPage(availableAdvertisement, 10));

        // string is balanced or not
        System.out.println( impl.findAGivenStringIsBalanced("[[}"));

        // search a file by using BFS
        System.out.println( impl.searchFile("C:/Users/abc/demo","test.txt"));

        // vowels start end with in string combination
        impl.printVowelsStringCombination("abc","");

    }
}
