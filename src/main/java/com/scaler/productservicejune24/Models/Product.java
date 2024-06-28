package com.scaler.productservicejune24.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    //private int id;
    private String name;
    private double price;
    private int quantity;
    private Category category;
}
