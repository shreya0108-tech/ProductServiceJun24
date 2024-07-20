package com.scaler.productservicejune24.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    //private long id;
    private String titles;
    private Double price;
    private String description;
    @ManyToOne(cascade = CascadeType.REMOVE)   //saves category if doesn't exist while adding/updating
    //a product
    private Category category;      //by default Eager as non-collection
    private String label;
}
