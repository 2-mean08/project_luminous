package com.luminous.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luminous.domain.Item;
import com.luminous.repository.ItemRepository;

@Service
@Transactional(readOnly = true)
public class ItemService {
	
private final ItemRepository itemRepository;
	
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	@Transactional
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	public List<Item> findItems(){
		return itemRepository.findAll();
	}
	public Item findOne(Long item_id) {
		return itemRepository.findOne(item_id);
	}
}
