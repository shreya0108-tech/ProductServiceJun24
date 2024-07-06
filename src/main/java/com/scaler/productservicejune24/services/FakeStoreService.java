package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.Models.Category;
import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.configurations.ApplicationConfig;
import com.scaler.productservicejune24.dtos.FakeStoreDTO;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
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
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //throw new ArithmeticException("Something went wrong");
        //throw new ArrayIndexOutOfBoundsException("Out of Bounds");
        //call fakestore service to fetch product with given id
        FakeStoreDTO fakeStoreDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+productId,//+"/",
                FakeStoreDTO.class
        );
        if(fakeStoreDTO == null)
        {
            throw new ProductNotFoundException("Product is not available with id "+
                    productId);
        }
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

    @Override
    public Product updateProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreDTO.class);
        HttpMessageConverterExtractor<FakeStoreDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreDTO.class, restTemplate.getMessageConverters());
        FakeStoreDTO fakeStoreDTO = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PATCH, requestCallback, responseExtractor);
        return convertFakeStoreToProduct(fakeStoreDTO);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product);
        FakeStoreDTO fakeStoreDTO = (FakeStoreDTO) restTemplate.execute("https://fakestoreapi.com/products/"+id,
                HttpMethod.PUT, requestCallback, (ResponseExtractor)null);
        return convertFakeStoreToProduct(fakeStoreDTO);
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
        //p.setCategory(fakeStoreDTO.getCategory());
        return p;
    }
}
