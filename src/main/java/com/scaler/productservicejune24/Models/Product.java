package com.scaler.productservicejune24.Models;

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
    @ManyToOne
    private Category category;
    private String label;
}
