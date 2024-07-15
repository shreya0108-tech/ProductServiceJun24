package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService {

    /*ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //fetch the product with the given id from the db
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        //fetch all the products from the db
        return List.of();
    }
}
