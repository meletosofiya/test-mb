package com.metro.problemSolving.two.problem2;

import java.util.Objects;

public class Stock {

    private String id; // unique if of every stock

    private String name; //stock name for eg maverick, infy

    private Double totalValue; //total value of all stock units

    private Long availableUnits; // number of units available

    private Double totalExpectedProfitPerMonth;  //represents total profit that can be earned on available units

    public Stock(String id, String name, Double totalValue, Long availableUnits, Double totalExpectedProfitPerMonth) {
        this.id = id;
        this.name = name;
        this.totalValue = totalValue;
        this.availableUnits = availableUnits;
        this.totalExpectedProfitPerMonth = totalExpectedProfitPerMonth;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Long getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(Long availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Double getTotalExpectedProfitPerMonth() {
        return totalExpectedProfitPerMonth;
    }

    public void setTotalExpectedProfitPerMonth(Double totalExpectedProfitPerMonth) {
        this.totalExpectedProfitPerMonth = totalExpectedProfitPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) && Objects.equals(name, stock.name) && Objects.equals(totalValue, stock.totalValue) && Objects.equals(availableUnits, stock.availableUnits) && Objects.equals(totalExpectedProfitPerMonth, stock.totalExpectedProfitPerMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, totalValue, availableUnits, totalExpectedProfitPerMonth);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", totalValue=" + totalValue +
                ", availableUnits=" + availableUnits +
                ", totalExpectedProfitPerMonth=" + totalExpectedProfitPerMonth +
                '}';
    }
}
