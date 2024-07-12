package com.scaler.productservicejune24.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    //private int id;
    private String categoryName;
    private String categoryDesc;
}
