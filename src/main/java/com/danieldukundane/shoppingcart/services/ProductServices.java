package com.danieldukundane.shoppingcart.services;

import com.danieldukundane.shoppingcart.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServices {

    public List<Product> getAll();

    public Product getProductById();

}
