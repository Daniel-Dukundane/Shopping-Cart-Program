package com.danieldukundane.shoppingcart.serviceImplementation;

import com.danieldukundane.shoppingcart.model.Cart;
import com.danieldukundane.shoppingcart.model.Product;
import com.danieldukundane.shoppingcart.repositories.CartRepository;
import com.danieldukundane.shoppingcart.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CartServicesImplementationTest {

    @Mock
    CartRepository cartRepository;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    CartServicesImplementation cartServicesImplementation;

    @Test
    public  void createShoppingCart(){

        List<Product> productList = new ArrayList<>();

        productList.add(
                new Product("Book",2, 600d, 1200d)
        );

        when(cartRepository.save(ArgumentMatchers.any(Cart.class))).thenReturn(
                new Cart(productList,1200d)
        );

        assertEquals(1200d,cartServicesImplementation.save(new Cart(productList,1200d)).getTotalCost());

    }


    @Test
    public void returnAllCarts(){
        List<Product> productList = new ArrayList<>();

        productList.add(
                new Product("Book",2, 600d, 1200d)
        );

        when(cartRepository.findAll()).thenReturn(Arrays.asList(
                new Cart(1l,productList,1200d),
                new Cart(2l,productList,1500d)
                ));


        assertThat(cartRepository.findAll().size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void checkEmptyCart(){

        List<Product> productList = new ArrayList<>();

        Cart defaultCart = new Cart(1l,productList,0d);

        when(cartRepository.findById(defaultCart.getId())).thenReturn(Optional.of(defaultCart));

        assertEquals(0, cartServicesImplementation.cartDetails(defaultCart.getId()).getTotalCost());

    }

    @Test
    public void addNewProduct () {

        Product product = new Product(1l,"Brush",3, 1000d, 3000d);

        List<Product> productList = new ArrayList<>();

        productList.add(
                new Product(1l,"Book",2, 600d, 1200d)
        );

        Cart defaultCart = new Cart(1l,productList,1200d);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        when(cartRepository.findById(defaultCart.getId())).thenReturn(Optional.of(defaultCart));

        assertEquals(0,
                cartServicesImplementation
                        .addNewProduct(defaultCart.getId(),product.getId())
                        .getProductList().size());

    }

    @Test
    public void removeProductFromCart () {

        Product product = new Product(1l,"Book",2, 600d, 1200d);

        List<Product> productList = new ArrayList<>();

        productList.add(
                new Product(1l,"Book",2, 600d, 1200d)
        );

        Cart defaultCart = new Cart(1l,productList,1200d);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        when(cartRepository.findById(defaultCart.getId())).thenReturn(Optional.of(defaultCart));

        assertThat(
                cartServicesImplementation
                        .remoteItem(defaultCart.getId(),product.getId())
                        .getProductList().size())
                .isEqualTo(0);

    }

}
