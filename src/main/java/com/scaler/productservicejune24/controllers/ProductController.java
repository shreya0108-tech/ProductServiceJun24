package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.dtos.FakeStoreDTO;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.services.FakeStoreService;
import com.scaler.productservicejune24.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    ProductController(@Qualifier("selfProductService") ProductService ps) {
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
    public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id,product);
    }

    //http://localhost:8080/product/1
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id)
    {
        productService.deleteProduct(id);
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product)
    {
        return productService.addNewProduct(product);
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
