package com.kientran.websellfood.Dto;

import com.kientran.websellfood.Entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ItemDto {

	private Integer Id;
	
	private int Quantity;
	
	private Double Price;
	
}
