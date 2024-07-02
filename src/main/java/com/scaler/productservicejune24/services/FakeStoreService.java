package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Category;
import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.configurations.ApplicationConfig;
import com.scaler.productservicejune24.dtos.FakeStoreDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreService implements  ProductService{

    RestTemplate restTemplate;
    public FakeStoreService(RestTemplate rst) {
        this.restTemplate = rst;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        //call fakestore service to fetch product with given id
        FakeStoreDTO fakeStoreDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+productId,//+"/",
                FakeStoreDTO.class
        );
        return convertFakeStoreToProduct(fakeStoreDTO);
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreDTO[] fakeStoreDTO =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products",
                  FakeStoreDTO[].class
                );
        List<Product> products = new ArrayList<>();
        for(FakeStoreDTO fakeStoreDTO1 : fakeStoreDTO)
        {
            products.add(convertFakeStoreToProduct(fakeStoreDTO1));
        }
        return products;
    }

    Product convertFakeStoreToProduct(FakeStoreDTO fakeStoreDTO)
    {
        Product p = new Product();
        p.setPrice(fakeStoreDTO.getPrice());
        p.setId(fakeStoreDTO.getId1());
        p.setTitles(fakeStoreDTO.getTitle());
        p.setLabel(fakeStoreDTO.getDescription());
        Category c = new Category();
        c.setCategoryName(fakeStoreDTO.getCategory());
        c.setCategoryDesc(fakeStoreDTO.getDescription());
        p.setCategory(c);
        return p;
    }
}
