package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProduct();
    Product updateProduct(Long id,Product product) throws ProductNotFoundException;
    Product replaceProduct(Long id,Product product) throws ProductNotFoundException;
    void deleteProduct(Long id);
    Product addNewProduct(Product product);
}
