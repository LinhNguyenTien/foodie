package com.kientran.websellfood.Service;

import java.util.List;

import com.kientran.websellfood.Dto.ProductDto;


public interface ProductService {

	ProductDto createProduct(ProductDto productDto, Integer categoryId);
	
	ProductDto updateProduct(ProductDto productDto, Integer productId);
	
	void deleteProduct(Integer productId);

	ProductDto getProductById(Integer productId);
	
	List<ProductDto> getProductsByCategory(Integer categoryId);
	
	public List<ProductDto> getAllProducts(); 
	
}
