package com.scaler.productservicejune24;

import com.scaler.productservicejune24.Models.Category;
import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.projections.ProductWithIdAndTitle;
import com.scaler.productservicejune24.repositories.CategoryRepository;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceJune24ApplicationTests {

    @Autowired			//<--- explanation below
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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

	@Test
	void testFetchTypesQueries()
	{
		Optional<Product> p = productRepository.findById(1);	//executes join as Eager
		System.out.println("Debug");
		Optional<Category> cat = categoryRepository.findById(1L);	//doesn't execute join as Lazy
		// executes join when explicitly made EAGER.
		System.out.println("Debug 2");

	}
}
/**
 *Why Constructor Injection Can Cause Issues :
 * Constructor Dependency Requirements: If you use constructor injection in your test class, you are requiring the test framework (JUnit) to provide those dependencies when it instantiates the test class. However, JUnit does not have the knowledge or capability to resolve and provide these dependencies; that is Spring's responsibility.
 * No-Argument Constructor Requirement: JUnit expects a no-argument constructor to create an instance of the test class. If the test class only has a constructor with parameters (for dependency injection), JUnit will not be able to instantiate it, leading to errors.
 * Field Injection as a Solution :
 * Field injection avoids this issue because it separates the instantiation of the test class from the injection of its dependencies:
 *
 * JUnit Instantiates the Class: JUnit uses the no-argument constructor to create an instance of your test class.
 * Spring Injects Dependencies: After the instance is created, Spring performs dependency injection and populates the fields annotated with @Autowired.
 */