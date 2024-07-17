package com.scaler.productservicejune24.repositories;

import com.scaler.productservicejune24.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // it should contain all the CRUD operations/methods related to Product model
    //we will not be implementing all these methods on our own. We'll be using JPA
    //repository.
    //JpaRepository<Product, Long> here, the first arg is which model the repository
    //will contain the methods of, and second is the datatype of its PK

    Optional<Product> findById(long id);

    @Override
    List<Product> findAll();

    @Override
    void deleteById(Long id);

    List<Product> findByPriceGreaterThan(Double price);
    //internally - select * from Products where price > ? ;

    List<Product> findProductByTitlesLike(String word);
    //internally - select * from Products where title like binary '%zzzz%' ;

    List<Product> findByTitlesLikeIgnoreCase(String word);
    //internally - select * from Products where title like '%zzzz%' ;

    List<Product> findTop5ByTitles(String word);
    //internally - select * from Products where title like '%%' LIMIT 5;

    List<Product> findProductByTitlesAndPriceGreaterThan(String word, Double price);

    List<Product> findProductByTitlesContainsOrderById(String word);
}

/*
* 1. Repository should be an interface
* 2. Repository should extend JPA repository in order to implement the methods.
* */