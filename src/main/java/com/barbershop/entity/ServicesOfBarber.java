package com.barbershop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class ServicesOfBarber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NameService")
	private String nameOfBarberService;
	private String price;
	
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "barberies_servecis", joinColumns = @JoinColumn(name = "id_barber_service"), 
				inverseJoinColumns = @JoinColumn(name = "id_barbers"))
	private List<Barber> barbers = new ArrayList<Barber>();
	
	@ManyToMany
	@JoinTable(name = "order_services", joinColumns = @JoinColumn(name = "id_barber_service"),
			inverseJoinColumns = @JoinColumn(name = "id_barber_order"))
	private List<BarberOrder> barberOrders = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "barber_services_to_user", joinColumns = @JoinColumn(name = "id_barber_service"),
			inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users = new ArrayList<User>();
	
	public ServicesOfBarber() {
		// TODO Auto-generated constructor stub
	}

	public ServicesOfBarber(String nameOfBarberService, String price) {
		super();
		this.nameOfBarberService = nameOfBarberService;
		this.price = price;
	}

	public ServicesOfBarber(int id, String nameOfBarberService, String price) {
		super();
		this.id=id;
		this.nameOfBarberService = nameOfBarberService;
		this.price = price;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfBarberService() {
		return nameOfBarberService;
	}

	public void setNameOfBarberService(String nameOfBarberService) {
		this.nameOfBarberService = nameOfBarberService;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Barber> getBarbers() {
		return barbers;
	}

	public void setBarbers(List<Barber> barbers) {
		this.barbers = barbers;
	}

	@Override
	public String toString() {
		return  nameOfBarberService + " "+ price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ServicesOfBarber that = (ServicesOfBarber) o;

		if (id != that.id) return false;
		if (nameOfBarberService != null ? !nameOfBarberService.equals(that.nameOfBarberService) : that.nameOfBarberService != null)
			return false;
		return price != null ? price.equals(that.price) : that.price == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (nameOfBarberService != null ? nameOfBarberService.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}
}
