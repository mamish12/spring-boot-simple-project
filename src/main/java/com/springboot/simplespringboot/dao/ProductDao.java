package com.springboot.simplespringboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.repository.ProductRepository;

@Repository // database code likhne ke liye hota h
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	/*
	 * insertProduct Method
	 */

	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}

	/*
	 * insert multiple data
	 */

	public List<Product> insertMultipleProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	/*
	 * deleteProduct
	 */

	public void deleteProductById(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			productRepository.delete(optional.get());
		}
	}

	/*
	 * getProductId
	 */
	public Product getProductById(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	/*
	 * getAll data
	 */

	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	
	/*
	 * update product
	 */
	
	public Product updateProductById(Product product)
	{
		Product product2=getProductById(product.getProductId());
		
		if(product2!=null)
		{
			product2.setProductName(product.getProductName());
			product2.setProductColor(product.getProductColor());
			product2.setProductPrice(product.getProductPrice());
			
			return productRepository.save(product2);
		}
		else
		{
			return null;
		}
	}
}
