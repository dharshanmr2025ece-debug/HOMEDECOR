package com.ecodecor.model;

public class Product {

    private int id;
    private String name;
    private String category;
    private String material;
    private double price;
    private int ecoScore;
    private String style;

    public Product() {
    }

    public Product(int id, String name, String category, String material,
                   double price, int ecoScore, String style) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.material = material;
        this.price = price;
        this.ecoScore = ecoScore;
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public int getEcoScore() {
        return ecoScore;
    }

    public String getStyle() {
        return style;
    }
}