package com.springboot.simplespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.response.ResponseStructure;
import com.springboot.simplespringboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	  
	@RequestMapping(value="/getMyData")
	public String getData()
	{
		return "Good Morning India";
	}
	
	
	/*
	 * insertproduct
	 */

	@PostMapping(value="/insertProduct")
	public Product insertProduct(@RequestBody Product product)
	{
		return productService.insertProduct(product);
	}
	
	
	/*
	 * insert multiple data 
	 */

	@PostMapping(value="/insertMultipleProduct")
	public List<Product> insertMultipleProducts(@RequestBody List<Product> products)
	{
		
		return productService.insertMultipleProducts(products);
	}
	
	/*
	 * deleteProduct
	 */
	@DeleteMapping(value="/deleteProduct/{productId}")
	public ResponseStructure<Product> deleteProductById(@PathVariable int productId)
	{
		return productService.deleteProductById(productId);
	}
	
	/*'
	 *getproduct
	 */
	@GetMapping(value="/getProductById/{productId}")
	public ResponseStructure<Product> getProductById(@PathVariable int productId)
	{
		return productService.getProductById(productId);
	}
	

	/*
	 * getAll data
	 */

	@GetMapping(value="/getAllProduct")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	
	/*
	 * update product
	 */
	
	@PutMapping(value="/updateProduct")
	public Product updateProductById(@RequestBody Product product)
	{
		return productService.updateProductById(product);
	}

}
