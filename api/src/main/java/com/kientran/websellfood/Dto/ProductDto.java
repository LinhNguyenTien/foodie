package com.kientran.websellfood.Dto;

import com.kientran.websellfood.Entity.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class ProductDto {

	private Integer Id;
	private String Name;
	private Double Price;
	private String Description;
	private String URL_image_product;
	private Category category;
}
