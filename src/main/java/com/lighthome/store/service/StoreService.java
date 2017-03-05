package com.lighthome.store.service;

import java.util.List;

import com.lighthome.store.domain.*;

public interface StoreService {
	
	public List<ItemsCategory> findAll();
	
	public ItemsCategory findByID(Long id);
	
	public void save(ItemsCategory itemsCategory);
	
	public void delete(ItemsCategory itemsCategory);
	
	public List<BrandInfo> getBrandsByCategoryID(Long categoryId);
	
	public List<Items> getItemsByCategoryIdAndBrandId(Long categoryId, Long brandId);
	
	public String getBrandDescriptionByBrandId(Long id);
	

}
