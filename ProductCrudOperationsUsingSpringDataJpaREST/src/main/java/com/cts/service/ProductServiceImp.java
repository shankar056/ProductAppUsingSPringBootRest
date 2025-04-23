package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

@Service("productService")
public class ProductServiceImp implements ProductService {
	Logger log = LoggerFactory.getLogger(ProductServiceImp.class);
	@Autowired
	ProductRepository repository;

	@Override
	public String saveProduct(Product product) {
		log.info("In ProductServiceImp saveProduct method");
		Product prod = repository.save(product);
		if (prod != null) {
			return "Product Saved Successfully";
		} else {
			return "Something Went Wrong";
		}
	}

	@Override
	public Product updateProduct(Product product) {
		Product prod = repository.save(product);
		return prod;
	}

	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "Product Deleted Successfully";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound{
		Optional<Product> optional = repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("Product ID is Invalid..");

	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> getAllProductsByCategory(String productCategory) {
		return repository.findByProductCategory(productCategory);
	}

	@Override
	public List<Product> getAllProductsGreaterThanGivenPrice(int givenPrice) {
		return repository.findByProductPriceGreaterThan(givenPrice);
	}

}
