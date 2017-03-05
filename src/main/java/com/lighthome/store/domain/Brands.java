package com.lighthome.store.domain;

import java.util.List;

public class Brands {
	
	private Long category;

	private List<BrandInfo> brands;

	public Long getCategory() {
		return category;
	}
	
	public void setCategory(Long category) {
		this.category = category;
	}
	
	public List<BrandInfo> getBrands() {
		return brands;
	}

	public void setBrands(List<BrandInfo> brands) {
		this.brands = brands;
	}

}
