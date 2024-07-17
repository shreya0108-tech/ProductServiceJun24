package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Category;
import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.repositories.CategoryRepository;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    SelfProductService(ProductRepository pr, CategoryRepository cr)
    {
        this.productRepository = pr;
        this.categoryRepository = cr;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //return null;
        Optional<Product> productOptional = productRepository.findById(productId);

        /*
        Optional work as a bucket to store the object and also it provides that convenience to check
        if that object is empty or not so that the Runtime Exception NullPointerException can be avoided.
        * */
        if(productOptional.isEmpty())
        {
            throw new ProductNotFoundException("Product with the id "+productId+" doesn't exist");
        }

        return productOptional.get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        Category cat = product.getCategory();
        if(cat.getId() == null )
        {
            cat = categoryRepository.save(cat);
            product.setCategory(cat);
        }
        return productRepository.save(product);
    }

    /*ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

}
