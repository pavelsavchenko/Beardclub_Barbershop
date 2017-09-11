package com.barbershop.entity;

import com.barbershop.service.BarberService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class BarberOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime dateTime;
	private LocalDate dateOrder;
	
	@ManyToOne
	private User user;

	@ManyToMany
	@JoinTable(name = "order_services", joinColumns = @JoinColumn(name = "id_barber_order"),
			inverseJoinColumns = @JoinColumn(name = "id_barber_service"))
	private List<ServicesOfBarber> barberService = new ArrayList<ServicesOfBarber>();
	
	public BarberOrder() {
		// TODO Auto-generated constructor stub
	}

	public BarberOrder(LocalDateTime dateTime) {
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

	public LocalDate getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(LocalDate dateOrder) {
		this.dateOrder = dateOrder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public List<ServicesOfBarber> getBarberService() {
		return barberService;
	}

	public void setBarberService(List<ServicesOfBarber> barberService) {
		this.barberService = barberService;
	}





}
