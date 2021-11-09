package com.danieldukundane.shoppingcart.controller;

import com.danieldukundane.shoppingcart.serviceImplementation.CartServicesImplementation;
import com.danieldukundane.shoppingcart.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@CrossOrigin

public class CartController {

    @Autowired
    private CartServicesImplementation cartServicesImplementation;

    @GetMapping
    public List<Cart> getAll(){

        return cartServicesImplementation.getAll();

    }

    @GetMapping("/{id}")
    public Cart getById(@RequestParam Long id){

        return cartServicesImplementation.cartDetails(id);

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cart newCart){

        Cart savedCart = cartServicesImplementation.save(newCart);

        return ResponseEntity.ok(savedCart);

    }

    @PostMapping("/add-new-product/{cartId}/{productId}}")
    public ResponseEntity<?> addNewProduct(@RequestParam Long cartId, @RequestParam Long productId){

        Cart savedCart = cartServicesImplementation.addNewProduct(cartId,productId);

        return ResponseEntity.ok(savedCart);

    }

    @PostMapping("/remove-product/{cartId}/{productId}}")
    public ResponseEntity<?> removeProduct(@RequestParam Long cartId, @RequestParam Long productId){

        Cart savedCart = cartServicesImplementation.remoteItem(cartId,productId);

        return ResponseEntity.ok(savedCart);

    }


}
