package com.barbershop.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class OrdersShop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime dateTime;
	private int resultPrice;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	@JoinTable(name = "orders_shop_commodity", joinColumns = @JoinColumn(name = "orders_shop_id"), 
				inverseJoinColumns = @JoinColumn(name = "commodity_id"))
	private List<Commodity> commodities = new ArrayList<>();
	
	
	public OrdersShop() {
		// TODO Auto-generated constructor stub
	}

	public OrdersShop(LocalDateTime dateTime) {
		super();
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}


	public int getResultPrice() {
		return resultPrice;
	}

	public void setResultPrice(int resultPrice) {
		this.resultPrice = resultPrice;
	}
}
