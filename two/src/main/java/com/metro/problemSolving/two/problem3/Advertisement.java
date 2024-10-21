package com.metro.problemSolving.two.problem3;

import java.util.Objects;

public class Advertisement {

    private String id;
    private Double price;
    private Integer height;
    private String title;
    private String content;

    public Advertisement(String id, Double price, Integer height, String title, String content) {
        this.id = id;
        this.price = price;
        this.height = height;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Objects.equals(id, that.id) && Objects.equals(price, that.price) && Objects.equals(height, that.height) && Objects.equals(title, that.title) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, height, title, content);
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", height=" + height +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
