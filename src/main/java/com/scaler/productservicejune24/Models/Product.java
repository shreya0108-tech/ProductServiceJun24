package com.scaler.productservicejune24.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    //private long id;
    private String titles;
    private double price;
    private String description;
    private Category category;
    private String label;
}
