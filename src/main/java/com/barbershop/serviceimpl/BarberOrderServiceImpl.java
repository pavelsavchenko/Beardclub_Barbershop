package com.barbershop.serviceimpl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import com.barbershop.dao.BarberServiceDao;
import com.barbershop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dao.BarberOrderDao;
import com.barbershop.entity.BarberOrder;
import com.barbershop.entity.ServicesOfBarber;
import com.barbershop.entity.User;
import com.barbershop.service.BarberOrderService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BarberOrderServiceImpl implements BarberOrderService {
	
	@Autowired
	private BarberOrderDao barberOrderDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private BarberServiceDao barberServiceDao;

	
	public void save(BarberOrder barberOrder) {
		
		barberOrderDao.save(barberOrder);
		
	}

	public List<BarberOrder> findAll() {
		
		return barberOrderDao.findAll();
	}

	public BarberOrder findOne(int id) {
		
		return barberOrderDao.getOne(id);
	}

	public void delete(int id) {
		
		barberOrderDao.delete(id);
		
	}

	public void update(BarberOrder barberOrder) {
		
		barberOrderDao.save(barberOrder);
		
	}

	@Override
	public void addToBarberOrder(Principal principal, int id) {

		User user = userDao.findUserWithService(Integer.parseInt(principal.getName()));

		ServicesOfBarber servicesOfBarber = barberServiceDao.findOne(id);

		user.getServicesOfBarbers().add(servicesOfBarber);

		userDao.save(user);
	}

	@Override
	@Transactional
	public void deleteFromBarberOrder(int userId, int serviceId) {

		User user = userDao.findUserWithService(userId);

		ServicesOfBarber servicesOfBarber = barberServiceDao.findOne(serviceId);

		user.getServicesOfBarbers().remove(servicesOfBarber);

		userDao.save(user);

	}

	@Override
	@Transactional
	public void entryToBarber(int userId, BarberOrder barberOrder, String data) {

		barberOrderDao.saveAndFlush(barberOrder);

		barberOrder.setDateOrder(LocalDate.parse(data));

		User user = userDao.findUserWithService(userId);

		barberOrder.setUser(user);

		for (ServicesOfBarber servicesOfBarber : user.getServicesOfBarbers()) {

			barberOrder.getBarberService().add(servicesOfBarber);

			barberOrderDao.save(barberOrder);
		}

		user.getServicesOfBarbers().clear();

		userDao.save(user);
	}
}
