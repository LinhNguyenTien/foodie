package com.kientran.websellfood.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kientran.websellfood.Dto.ItemDto;
import com.kientran.websellfood.Response.ApiResponse;
import com.kientran.websellfood.Service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/add/{productId}")
	public ResponseEntity<ItemDto> createProduct(@RequestBody ItemDto itemDto,
			@PathVariable Integer productId) {
		ItemDto createItem = this.itemService.createItem(itemDto, productId);
		return new ResponseEntity<ItemDto>(createItem, HttpStatus.CREATED);
	}
	
	@PutMapping("/{itemId}")
	public ResponseEntity<ItemDto> updateItem(@RequestBody ItemDto itemDto,
			@PathVariable Integer itemId) {
		ItemDto updatedItem = this.itemService.updateItem(itemDto, itemId);
		return new ResponseEntity<ItemDto>(updatedItem, HttpStatus.OK);
	}
	
	@DeleteMapping("/{itemId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer itemId) {
		this.itemService.deleteItem(itemId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Item is deleted successfully!", true),
				HttpStatus.OK);
	}
	
}
