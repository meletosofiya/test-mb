package com.metro.problemSolving.entity;

import java.util.Objects;

public class Car {

   private Long id;

   private  Double price;

   private String brand;

   private  String model;

   private  Double mileageInKM;

   private Double rating;

   public Car(Long id, Double price, String brand, String model, Double mileageInKM, Double rating) {
      this.id = id;
      this.price = price;
      this.brand = brand;
      this.model = model;
      this.mileageInKM = mileageInKM;
      this.rating = rating;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public Double getMileageInKM() {
      return mileageInKM;
   }

   public void setMileageInKM(Double mileageInKM) {
      this.mileageInKM = mileageInKM;
   }

   public Double getRating() {
      return rating;
   }

   public void setRating(Double rating) {
      this.rating = rating;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Car car = (Car) o;
      return Objects.equals(id, car.id) && Objects.equals(price, car.price) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(mileageInKM, car.mileageInKM) && Objects.equals(rating, car.rating);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, price, brand, model, mileageInKM, rating);
   }

   @Override
   public String toString() {
      return "Car{" +
              "id=" + id +
              ", price=" + price +
              ", brand='" + brand + '\'' +
              ", model='" + model + '\'' +
              ", mileageInKM=" + mileageInKM +
              ", rating=" + rating +
              '}';
   }
}
