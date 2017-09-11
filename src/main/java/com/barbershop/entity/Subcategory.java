package com.barbershop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Subcategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Subcategory")
	private String nameOfSubcategory;
	
	@OneToMany(mappedBy = "subcategoty", cascade = CascadeType.REMOVE)
	private List<Commodity> commodities = new ArrayList<Commodity>();
	
	@ManyToOne
	private CategoryOfCommodity categoryOfCommodity;
	
	
	public Subcategory() {
		// TODO Auto-generated constructor stub
	}

	public Subcategory(String nameOfSubcategory) {
		super();
		this.nameOfSubcategory = nameOfSubcategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfSubcategory() {
		return nameOfSubcategory;
	}

	public void setNameOfSubcategory(String nameOfSubcategory) {
		this.nameOfSubcategory = nameOfSubcategory;
	}

	public CategoryOfCommodity getCategoryOfCommodity() {
		return categoryOfCommodity;
	}

	public void setCategoryOfCommodity(CategoryOfCommodity categoryOfCommodity) {
		this.categoryOfCommodity = categoryOfCommodity;
	}
	
	
	
}
