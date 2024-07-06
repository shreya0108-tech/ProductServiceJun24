package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.services.FakeStoreService;
import com.scaler.productservicejune24.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductbyId(@PathVariable("id") Long id) throws ProductNotFoundException {
        //throw new RuntimeException("Something went wrong");
        /*ResponseEntity<Product> resp = null;
        try {
            Product product = productService.getSingleProduct(id);
            resp = new ResponseEntity<>(
                    product,
                    HttpStatus.OK);
        }
        catch(RuntimeException ex) {
            resp = new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);      //here no need to pass service call
        }*/
        ResponseEntity<Product> resp = null;
        Product product = productService.getSingleProduct(id);
        resp = new ResponseEntity<>(product, HttpStatus.OK);
        return resp;
    }

    @GetMapping()
    public List<Product> getAllProducts()
    {
        return productService.getAllProduct();
        //return fakeStoreService.getAllProduct();
    }

    //http://localhost:8080/product/1
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product)
    {
        return updateProduct(id,product);
    }

    //http://localhost:8080/product/1
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable int id, @RequestBody Product product)
    {
        return replaceProduct(id,product);
    }

    //if we want to handle the exception using exception handler, we can do it in the
    //controller also.
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayOutBounds()
    {
        ResponseEntity<String> resp = new ResponseEntity<>(
                "Array Out of Bounds Exception",
                HttpStatus.BAD_REQUEST
        );
        return resp;
    }
}
