package com.lighthome.store.domain;

import java.util.List;

public class BrandItems {
	
	private List<Items> items;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
}
