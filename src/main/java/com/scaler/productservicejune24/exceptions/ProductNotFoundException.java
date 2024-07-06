package com.scaler.productservicejune24.exceptions;

import com.scaler.productservicejune24.Models.Product;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String str)
    {
        super(str);
    }
}
