package com.scaler.productservicejune24.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    //private int id;
    private String categoryName;
    private String categoryDesc;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    //explicitly made Eager to check if it executes join, else LAZY by default
    //this name is the object of Product class Category table
    private List<Product> products;     //by default Lazy as collection obj
}
