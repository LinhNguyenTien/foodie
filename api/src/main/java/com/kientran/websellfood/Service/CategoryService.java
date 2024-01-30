package com.kientran.websellfood.Service;

import java.util.List;

import com.kientran.websellfood.Dto.CategoryDto;


public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	void deleteCaterogy(Integer categoryId);
	
	List<CategoryDto> getCategories();
	
	CategoryDto getCategory(Integer categoryId);

}
