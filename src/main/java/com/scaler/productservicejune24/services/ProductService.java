package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProduct();
}
