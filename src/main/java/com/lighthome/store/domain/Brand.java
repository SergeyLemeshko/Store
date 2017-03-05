package com.lighthome.store.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="BRAND")
@NamedQueries({
	@NamedQuery(name="Brands.getBrandsByCategoryId", 
				query="SELECT DISTINCT b FROM Brand b "
						+ "LEFT JOIN b.items i "
						+ "WHERE i.category.id = :CATEGORY_ID")})
@SqlResultSetMapping(
        name = "BrandInfoMapping",
        classes = @ConstructorResult(
                targetClass = BrandInfo.class,
                columns = {
                    @ColumnResult(name = "id", type=Long.class),
                    @ColumnResult(name = "name"),
                    @ColumnResult(name = "count", type=Integer.class)}))

public class Brand implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String description;
	private List<Items> items;
	private int count;
	
	


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
	
	@OneToMany(mappedBy="brand", fetch=FetchType.LAZY)
	@JsonIgnore
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	
//	@Column(name="COUNT", insertable=false, updatable=false)
//	public int getCount() {
//		return count;
//	}
//	
//	public void setCount(int count) {
//		this.count = count;
//	}
	
	@Column(name="DESCRIPTION")
	@Basic(fetch=FetchType.LAZY)
	@JsonIgnore
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
}
