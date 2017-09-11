package com.barbershop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Commodity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "commodity")
	private String nameOfCommodity;
	private String price;
	@Type(type = "text")
	private String desription;

	private String pathImage;

	@ManyToOne
	private Subcategory subcategoty;
	
	@ManyToMany
	@JoinTable(name = "user_commodities", joinColumns = @JoinColumn(name = "id_commodity"),
				inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users = new ArrayList<User>();
	
	@ManyToMany
	@JoinTable(name = "orders_shop_commodity", joinColumns = @JoinColumn(name = "commodity_id"), 
				inverseJoinColumns = @JoinColumn(name = "orders_shop_id"))
	private List<OrdersShop> ordersShops = new ArrayList<>();
	
	public Commodity() {
		// TODO Auto-generated constructor stub
	}

	public Commodity(String nameOfCommodity, String price, String desription) {
		super();
		this.nameOfCommodity = nameOfCommodity;
		this.price = price;
		this.desription = desription;
	}

	public Commodity(int id, String nameOfCommodity, String price, String desription) {
		super();
		this.id=id;
		this.nameOfCommodity = nameOfCommodity;
		this.price = price;
		this.desription = desription;
	}

	public Commodity(int id, String nameOfCommodity, String price) {
		this.id = id;
		this.nameOfCommodity = nameOfCommodity;
		this.price = price;

	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfCommodity() {
		return nameOfCommodity;
	}

	public void setNameOfCommodity(String nameOfCommodity) {
		this.nameOfCommodity = nameOfCommodity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}
	
	public Subcategory getSubcategoty() {
		return subcategoty;
	}

	public void setSubcategoty(Subcategory subcategoty) {
		this.subcategoty = subcategoty;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}


	@Override
	public String toString() {
		return "Commodity{" +
				"id=" + id +
				", nameOfCommodity='" + nameOfCommodity + '\'' +
				", price=" + price +
				", desription='" + desription + '\'' +
				", subcategoty=" + subcategoty +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Commodity commodity = (Commodity) o;

		if (id != commodity.id) return false;
		if (nameOfCommodity != null ? !nameOfCommodity.equals(commodity.nameOfCommodity) : commodity.nameOfCommodity != null)
			return false;
		if (price != null ? !price.equals(commodity.price) : commodity.price != null) return false;
		if (desription != null ? !desription.equals(commodity.desription) : commodity.desription != null) return false;
		return pathImage != null ? pathImage.equals(commodity.pathImage) : commodity.pathImage == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (nameOfCommodity != null ? nameOfCommodity.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (desription != null ? desription.hashCode() : 0);
		result = 31 * result + (pathImage != null ? pathImage.hashCode() : 0);
		return result;
	}
}
