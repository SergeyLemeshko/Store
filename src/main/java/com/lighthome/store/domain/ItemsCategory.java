package com.lighthome.store.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ITEMS_CATEGORY")
@NamedQueries({
	@NamedQuery(name="ItemsCategory.findAll", query="Select ic from ItemsCategory ic")
})
public class ItemsCategory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private List<Items> items;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
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
	
	
	@OneToMany(mappedBy="category")
	@JsonIgnore
	public List<Items> getItems() {
		return items;
	}


	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ItemsCategory [id=" + id + ", name=" + name + "]";
	}
}
