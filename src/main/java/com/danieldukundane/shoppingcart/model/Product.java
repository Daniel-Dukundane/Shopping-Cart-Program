package com.danieldukundane.shoppingcart.model;

import javax.persistence.*;

@Table
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Integer numberOfProducts;

    private Double cost;

    private Double totalCost;


    public Product() {
    }

    public Product(String productName, Integer numberOfProducts, Double cost, Double totalCost) {
        this.productName = productName;
        this.numberOfProducts = numberOfProducts;
        this.cost = cost;
        this.totalCost = totalCost;
    }

    public Product(Long id, String productName, Integer numberOfProducts, Double cost, Double totalCost) {
        this.id = id;
        this.productName = productName;
        this.numberOfProducts = numberOfProducts;
        this.cost = cost;
        this.totalCost = totalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
