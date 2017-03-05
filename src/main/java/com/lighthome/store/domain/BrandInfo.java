package com.lighthome.store.domain;

public class BrandInfo {
	
	private Long id;
	private String name;
	private Integer count;
	
	
	public BrandInfo(Long id, String name, Integer count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getCount() {
		return count;
	}
}
