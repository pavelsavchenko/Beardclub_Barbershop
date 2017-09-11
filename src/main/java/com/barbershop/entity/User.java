package com.barbershop.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import javax.persistence.*;

@Entity
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String password;

	private boolean enable;
	private String uuid;

	@Enumerated
	private  Role role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<BarberOrder>  barberOrders = new HashSet<BarberOrder>();
	
	@ManyToMany
	@JoinTable(name = "user_commodities", joinColumns = @JoinColumn(name = "id_user"), 
				inverseJoinColumns = @JoinColumn(name = "id_commodity"))
	private List<Commodity> commodities = new ArrayList<Commodity>();

	@ManyToMany
	@JoinTable(name = "barber_services_to_user", joinColumns = @JoinColumn(name = "id_user"),
			inverseJoinColumns = @JoinColumn(name = "id_barber_service"))
	private List<ServicesOfBarber> servicesOfBarbers = new ArrayList<ServicesOfBarber>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<OrdersShop> ordersShops = new HashSet<OrdersShop>();
	
	
	public User() {
		
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User(String name, String phoneNumber, String email, String password) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber(){ return  phoneNumber; }

	public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ServicesOfBarber> getServicesOfBarbers() {
		return servicesOfBarbers;
	}

	public void setServicesOfBarbers(List<ServicesOfBarber> servicesOfBarbers) {
		this.servicesOfBarbers = servicesOfBarbers;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public Set<OrdersShop> getOrdersShops() {
		return ordersShops;
	}

	public void setOrdersShops(Set<OrdersShop> ordersShops) {
		this.ordersShops = ordersShops;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<BarberOrder> getBarberOrders() {
		return barberOrders;
	}

	public void setBarberOrders(Set<BarberOrder> barberOrders) {
		this.barberOrders = barberOrders;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.name()));
		return authorities;
	}

	@Override
	public String getUsername() {
		return String.valueOf(id);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enable;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", " +
				"name=" + name + ", " +
				"phoneNumber=" + phoneNumber + ", " +
				"email=" + email + ", " +
				"password=" + password
				+ ", commodities=" + commodities + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (enable != user.enable) return false;
		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
		if (email != null ? !email.equals(user.email) : user.email != null) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		if (uuid != null ? !uuid.equals(user.uuid) : user.uuid != null) return false;
		if (role != user.role) return false;
		if (barberOrders != null ? !barberOrders.equals(user.barberOrders) : user.barberOrders != null) return false;
		if (commodities != null ? !commodities.equals(user.commodities) : user.commodities != null) return false;
		if (servicesOfBarbers != null ? !servicesOfBarbers.equals(user.servicesOfBarbers) : user.servicesOfBarbers != null)
			return false;
		return ordersShops != null ? ordersShops.equals(user.ordersShops) : user.ordersShops == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (enable ? 1 : 0);
		result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
		result = 31 * result + (role != null ? role.hashCode() : 0);
		result = 31 * result + (barberOrders != null ? barberOrders.hashCode() : 0);
		result = 31 * result + (commodities != null ? commodities.hashCode() : 0);
		result = 31 * result + (servicesOfBarbers != null ? servicesOfBarbers.hashCode() : 0);
		result = 31 * result + (ordersShops != null ? ordersShops.hashCode() : 0);
		return result;
	}

	//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//
//		User user = (User) o;
//
//		if (id != user.id) return false;
//		if (enable != user.enable) return false;
//		if (name != null ? !name.equals(user.name) : user.name != null) return false;
//		if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
//		if (email != null ? !email.equals(user.email) : user.email != null) return false;
//		if (password != null ? !password.equals(user.password) : user.password != null) return false;
//		if (uuid != null ? !uuid.equals(user.uuid) : user.uuid != null) return false;
//		if (role != user.role) return false;
//		if (barberOrders != null ? !barberOrders.equals(user.barberOrders) : user.barberOrders != null) return false;
//		if (commodities != null ? !commodities.equals(user.commodities) : user.commodities != null) return false;
//		return ordersShops != null ? ordersShops.equals(user.ordersShops) : user.ordersShops == null;
//	}
//
//	@Override
//	public int hashCode() {
//		int result = id;
//		result = 31 * result + (name != null ? name.hashCode() : 0);
//		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
//		result = 31 * result + (email != null ? email.hashCode() : 0);
//		result = 31 * result + (password != null ? password.hashCode() : 0);
//		result = 31 * result + (enable ? 1 : 0);
//		result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
//		result = 31 * result + (role != null ? role.hashCode() : 0);
//		result = 31 * result + (barberOrders != null ? barberOrders.hashCode() : 0);
//		result = 31 * result + (commodities != null ? commodities.hashCode() : 0);
//		result = 31 * result + (ordersShops != null ? ordersShops.hashCode() : 0);
//		return result;
//	}
}
