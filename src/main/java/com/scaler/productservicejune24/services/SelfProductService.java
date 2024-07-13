package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements  ProductService {

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }
}
