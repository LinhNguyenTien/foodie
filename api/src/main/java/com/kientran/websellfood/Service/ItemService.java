package com.kientran.websellfood.Service;

import com.kientran.websellfood.Dto.ItemDto;

public interface ItemService {
	
	ItemDto createItem(ItemDto itemDto, Integer productId);
	
	ItemDto updateItem(ItemDto itemDto, Integer productId);
	
	void deleteItem(Integer itemId);
}
