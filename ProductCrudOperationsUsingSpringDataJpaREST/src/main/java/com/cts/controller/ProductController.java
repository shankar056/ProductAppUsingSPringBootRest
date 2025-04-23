package com.cts.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

import lombok.NoArgsConstructor;
 
@RestController //@Controller+@RequestResponseBody
@RequestMapping("/products") // http://localhost:8080/products
@NoArgsConstructor
public class ProductController {
 
	@Autowired
	ProductService service;

	@GetMapping("/getMsg") // @RequestMapping(value="/getMsg",method=RequestMethod.GET) (or)//http://localhost:8080/products/getMsg
	public String sayHello() {
		return "Heloo bruh";
	}
	
	@PostMapping("/saveproduct") // http://localhost:8080/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}
	
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	@GetMapping("/getproduct/{pid}")
	public Product fetchProduct(@PathVariable ("pid")  int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
	@DeleteMapping("/removeproduct/{pid}") // http://localhost:8080/products/removeproduct
	public String removeProduct(@PathVariable ("pid") int productId) {
		return service.removeProduct(productId);
	}
	@GetMapping("/getallproducts")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
		
	}
	@PostMapping("/getallproductsbycategory/{pcategory}")
	public List<Product> getAllProductsByCategory(@PathVariable ("pcategory") String productCategory){
		return service.getAllProductsByCategory(productCategory);
	}
	@PostMapping("/getallproductsgreaterthangivenprice/{price}")
	public List<Product> getAllProductsGreaterThanGivenPrice(@PathVariable("price") int givenPrice) {
		return service.getAllProductsGreaterThanGivenPrice(givenPrice);
	}
	@GetMapping("/getallproductsbetweengivenrange/{ip}/{fp}")
	public List<Product> getAllProductsBetween(@PathVariable("ip") int initialPrice, @PathVariable("fp") int finalPrice) {
		return service.getAllProductsBetween(initialPrice, finalPrice);
	}
		
}
 
 