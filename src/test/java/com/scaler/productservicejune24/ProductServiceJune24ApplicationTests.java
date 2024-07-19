package com.scaler.productservicejune24;

import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.projections.ProductWithIdAndTitle;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceJune24ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	//HQL
	@Test
	void testHQLQuery()
	{
		List<ProductWithIdAndTitle> list= productRepository.RandomSearch(1);
		for(ProductWithIdAndTitle pr : list)
		{
			System.out.println(pr.getId()+" "+pr.getTitle());
		}
	}

	//SQL
	@Test
	void testSQLQuery()
	{
		List<Product> plist = productRepository.RandomSearchUsingSql();
		for(Product pr : plist)
		{
			System.out.println("SQL "+pr.getId()+" "+pr.getPrice());
		}
	}
}
