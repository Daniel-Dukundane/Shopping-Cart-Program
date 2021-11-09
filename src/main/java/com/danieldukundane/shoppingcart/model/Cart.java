package com.danieldukundane.shoppingcart.model;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Product> productList;

    private Double totalCost;

    public Cart() {
    }

    public Cart(Long id, List<Product> productList, Double totalCost) {
        this.id = id;
        this.productList = productList;
        this.totalCost = totalCost;
    }

    public Cart(List<Product> productList, Double totalCost) {
        this.productList = productList;
        this.totalCost = totalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
