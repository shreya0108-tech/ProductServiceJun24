package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Category;
import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.repositories.CategoryRepository;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
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
    public Page<Product> getAllProduct(int pageNumber, int pageSize) {
        /*Sort.by("price").ascending().and(Sort.by("Title").ascending().
        and(Sort.by("Quantity").ascending()))*/
        return productRepository.findAll(
                PageRequest.of(pageNumber, pageSize,
                        Sort.by("price").ascending()));
    }

    //PATCH
    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> prOpt = productRepository.findById(id);
        if(prOpt.isEmpty())
        {
            throw new ProductNotFoundException("Product with id "+id+" doesn't exist");
        }
        Product productobj = prOpt.get();
        if(product.getPrice() != null)
        {
            productobj.setPrice(product.getPrice());
        }
        if(product.getLabel() != null) {
            productobj.setLabel(product.getLabel());
        }
        return productRepository.save(productobj);
    }

    //PUT
    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> propt = productRepository.findById(id);
        if(propt.isEmpty())
        {
            throw new ProductNotFoundException("Product with id "+id+" doesn't exist");
        }
        Product probj = propt.get();
        if(product.getTitles() != null)
        {
            probj.setTitles(product.getTitles());
        }
        if(product.getPrice() != null)
        {
            probj.setPrice(product.getPrice());
        }
        if(product.getDescription() != null)
        {
            probj.setDescription(product.getDescription());
        }
        Category cat = product.getCategory();
        if(cat.getId() == null )
        {
            cat = categoryRepository.save(cat);
            probj.setCategory(cat);
        }
        if(product.getLabel() != null) {
            probj.setLabel(product.getLabel());
        }
        return productRepository.save(probj);
    }

    //DELETE
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    //POST
    @Override
    public Product addNewProduct(Product product) {
//        Category cat = product.getCategory();
//        if(cat.getId() == null )
//        {
//            cat = categoryRepository.save(cat);
//            product.setCategory(cat);
//        }
        return productRepository.save(product);
    }

    /*ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

}
