package com.lighthome.store.web.controller;


import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.lighthome.store.domain.*;
import com.lighthome.store.service.StoreService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class StoreController {
	
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private StoreService itemsCategoryService;
	
	@GetMapping(value="/")
	public String home(Locale locale, Model model) {
		return "static/home.html";
	}
	
	@GetMapping(value="/category", produces="application/json")
	@ResponseBody
	public ItemCategoriesInfo getItemCategories() {
		List<ItemsCategory> itemsCategory = itemsCategoryService.findAll();
		return new ItemCategoriesInfo(itemsCategory);
	}
	
	@GetMapping(value ="/category/{category}", produces="application/json")
	@ResponseBody
	public Brands getBrandsInfo(@PathVariable("category") Long categoryid) {
		Brands brands = new Brands();
		brands.setCategory(categoryid);
		brands.setBrands(itemsCategoryService.getBrandsByCategoryID(categoryid));
		return brands;
	}
	
	@GetMapping(value ="/category/{category}/brand/{brand}", produces="application/json")
	@ResponseBody
	public BrandItems getItemsByCategoryIdAndBrandId(@PathVariable("category") Long categoryId,
			@PathVariable("brand") Long brandId) {
		
		BrandItems items = new BrandItems();
		items.setItems(itemsCategoryService.getItemsByCategoryIdAndBrandId(categoryId, brandId));
		items.setDescription(itemsCategoryService.getBrandDescriptionByBrandId(brandId));
		
		return items;
	}
}
