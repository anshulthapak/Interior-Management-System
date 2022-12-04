package com.anshul.interiormanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anshul.interiormanagementsystem.entity.Item;
import com.anshul.interiormanagementsystem.repo.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}
	
	public List<Item> saveAllItem(List<Item> items){
		return (List<Item>) itemRepo.saveAll(items).stream().sorted((x,y) -> x.getUpdateDate().compareTo(y.getUpdateDate()));
	}
	
	public Item getItemById(Long id) {
		return itemRepo.findById(id).orElse(null);
	}
	
//	public Item getItemByName(String name, String brand) {
//		return itemRepo.findByNameAndBrand(name,brand);
//	}
	
	public List<Item> getAllItem(){
		return itemRepo.findAll(Sort.by(Sort.Direction.DESC,"updateDate"));
	}
	
	public void updateItem(Item i) {
		itemRepo.save(i);
	}
	
	public void deleteItem(Item i) {
		itemRepo.delete(i);
	}
}
