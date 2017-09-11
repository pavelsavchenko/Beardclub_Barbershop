package com.barbershop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Barber {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String position;
	private String firstName;
	private String lastName;
	private String pathImage;


	@ManyToMany
	@JoinTable(name = "barberies_servecis", joinColumns = @JoinColumn(name = "id_barbers"), 
				inverseJoinColumns = @JoinColumn(name = "id_barber_service"))
	private List<ServicesOfBarber> barberServices = new ArrayList<ServicesOfBarber>();
	
	public Barber() {
		// TODO Auto-generated constructor stub
	}

	public Barber(String position, String firstName, String lastName) {
		super();
		this.position = position;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public List<ServicesOfBarber> getBarberServices() {
		return barberServices;
	}

	public void setBarberServices(List<ServicesOfBarber> barberServices) {
		this.barberServices = barberServices;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public String toString() {
		return "Barber [id=" + id + ", position=" + position + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", barberServices=" + barberServices + "]";
	}



}
