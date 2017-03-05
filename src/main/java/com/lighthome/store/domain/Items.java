package com.lighthome.store.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ITEMS")
@NamedQueries({@NamedQuery(name="Items.getItemsByCategoryIdAndBrandId", 
		query="Select i from Items i where i.category.id = :cid and i.brand.id =:bid")})
public class Items implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String image;
	private Integer count;
	private Brand brand;
	private boolean enable;

	private ItemsCategory category;
	
	

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="PRICE")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Column(name="IMAGE")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Column(name="ENABLE")
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BRAND_ID")
	@JsonIgnore
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORY_ID")
	@JsonIgnore
	public ItemsCategory getCategory() {
		return category;
	}
	public void setCategory(ItemsCategory category) {
		this.category = category;
	}
	
	@Column(name="COUNT")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", image=" + image
				+ ", count=" + count + ", brand=" + brand + ", category="
				+ category + "]";
	}
	
}
