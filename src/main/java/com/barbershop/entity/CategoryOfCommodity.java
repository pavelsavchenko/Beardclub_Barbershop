package com.barbershop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class CategoryOfCommodity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "category")
	private String nameOfCategory;
	
	@OneToMany(mappedBy = "categoryOfCommodity", cascade = CascadeType.REMOVE)

	private List<Subcategory> subcategoties = new ArrayList<Subcategory>();
	
	
	
	public CategoryOfCommodity() {
		// TODO Auto-generated constructor stub
	}

	public CategoryOfCommodity(String nameOfCategory) {
		super();
		this.nameOfCategory = nameOfCategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfCategory() {
		return nameOfCategory;
	}

	public void setNameOfCategory(String nameOfCategory) {
		this.nameOfCategory = nameOfCategory;
	}

	public List<Subcategory> getSubcategoties() {
		return subcategoties;
	}

	public void setSubcategoties(List<Subcategory> subcategoties) {
		this.subcategoties = subcategoties;
	}

	@Override
	public String toString() {
		return "CategoryOfCommodity [id=" + id + ", nameOfCategory=" + nameOfCategory + ", subcategoties="
				+ subcategoties + "]";
	}



}
