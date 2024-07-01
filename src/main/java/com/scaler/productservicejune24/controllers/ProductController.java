package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.services.FakeStoreService;
import com.scaler.productservicejune24.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //FakeStoreService fakeStoreService = new FakeStoreService();
    ProductService productService;
    ProductController(ProductService ps) {
        //this.productService = new FakeStoreService();
        this.productService = ps;
    }
    //http://localhost:8080/product/1
    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable("id") Long id)
    {
        return productService.getSingleProduct(id);
        //return fakeStoreService.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts()
    {
        return productService.getAllProduct();
        //return fakeStoreService.getAllProduct();
    }
}
