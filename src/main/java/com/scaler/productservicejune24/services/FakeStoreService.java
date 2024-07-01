package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class FakeStoreService implements  ProductService{

    @Override
    public Product getSingleProduct(Long productId) {
        return new Product();
    }

    @Override
    public List<Product> getAllProduct() {
        return new ArrayList<>();
    }
}
