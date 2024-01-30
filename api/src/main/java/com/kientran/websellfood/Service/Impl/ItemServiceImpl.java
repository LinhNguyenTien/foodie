package com.kientran.websellfood.Service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kientran.websellfood.Dto.ItemDto;
import com.kientran.websellfood.Entity.Item;
import com.kientran.websellfood.Entity.Product;
import com.kientran.websellfood.Exception.ResourceNotFoundException;
import com.kientran.websellfood.Repository.ItemRepository;
import com.kientran.websellfood.Repository.ProductRepository;
import com.kientran.websellfood.Service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ItemDto createItem(ItemDto itemDto, Integer productId) {
		Product product = this.productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product ", "productId", productId));
		Item item = this.modelMapper.map(itemDto, Item.class);
		item.setProduct(product);
		
		Item newItem = this.itemRepository.save(item);
		return this.modelMapper.map(newItem, ItemDto.class);
	}

	@Override
	public ItemDto updateItem(ItemDto itemDto, Integer itemId) {
		Item item = this.itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item ", "ItemId", itemId));
		item.setQuantity(itemDto.getQuantity());
		item.setPrice(itemDto.getPrice());

		Item updateItem = this.itemRepository.save(item);
				
		return this.modelMapper.map(updateItem, ItemDto.class);
	}

	@Override
	public void deleteItem(Integer itemId) {
		Item item = this.itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item", "ItemId", itemId));
		this.itemRepository.delete(item);
		
	}

}
