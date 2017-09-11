package com.barbershop.service;

import java.security.Principal;
import java.util.List;

import com.barbershop.entity.BarberOrder;

public interface BarberOrderService  {

	void save(BarberOrder barberOrder);
	List <BarberOrder> findAll();
	BarberOrder findOne(int id);
	void delete(int id);
	void update(BarberOrder barberOrder);

	void addToBarberOrder(Principal principal, int id);

	void deleteFromBarberOrder(int userId, int serviceId);

	void entryToBarber(int userId, BarberOrder barberOrder, String data) throws Exception;
	
	
}
