package com.anshul.interiormanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.anshul.interiormanagementsystem.entity.Item;
import com.anshul.interiormanagementsystem.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item")
	public String getItem(Model model) {
		List<Item> items = itemService.getAllItem();
		model.addAttribute("listitem", items);
		return "item";
	}
	
	@PostMapping("/addItem")
	public String addItem(@ModelAttribute Item item) {
		item.setUpdateDate(item.getDate());
		itemService.saveItem(item);
		return "redirect:/item";
	}
	
	@GetMapping("/additem")
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		return "addItem";
	}
	
	@GetMapping("/item/edit/{id}")
	public String updateItem(@PathVariable String id, Model model) {
		Long ida = Long.parseLong(id);
		model.addAttribute("item", itemService.getItemById(ida));
		return "editItem";
	}
	
	@PostMapping("/item/{id}")
	public String updateItem(@PathVariable String id, @ModelAttribute Item item, Model model) {
		Long ida = Long.parseLong(id);
		Item i = itemService.getItemById(ida);
		i.setName(item.getName());
		i.setBrand(item.getBrand());
		i.setQty(item.getQty());
		i.setPrice(item.getPrice());
		i.setMrp(item.getMrp());
		i.setGst(item.getGst());
		i.setUpdateDate(item.getDate());
		
		itemService.updateItem(i);
		return "redirect:/item";
	}
	
	@GetMapping("item/delete/{id}")
	public String deleteItem(@PathVariable Long id) {
		Item i = itemService.getItemById(id);
		itemService.deleteItem(i);
		return "redirect:/item";
	}
}
