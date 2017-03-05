package com.lighthome.store.domain;

import java.util.List;

public class ItemCategoriesInfo {
	
	private List<ItemsCategory> categories;
	
	public ItemCategoriesInfo(List<ItemsCategory> categories) {
		super();
		this.categories = categories;
	}


	public List<ItemsCategory> getCategories() {
		return categories;
	}
}
