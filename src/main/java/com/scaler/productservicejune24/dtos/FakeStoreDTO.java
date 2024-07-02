package com.scaler.productservicejune24.dtos;

import com.scaler.productservicejune24.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDTO {
    private String image;
    private long id1;
    private String title;
    private double price;
    private String category;
    private String description;

}
