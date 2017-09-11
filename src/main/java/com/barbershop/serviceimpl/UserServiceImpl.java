package com.barbershop.serviceimpl;

import java.util.List;

import com.barbershop.dao.BarberServiceDao;
import com.barbershop.dao.CommodityDao;
import com.barbershop.entity.*;
import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.barbershop.dao.BarberOrderDao;
import com.barbershop.dao.UserDao;
import com.barbershop.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BarberOrderDao barberOrderDao;

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	private BarberServiceDao barberServiceDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator1;


	@Autowired
	@Qualifier("userUpdateValidator")
	private Validator validator2;

	@Autowired
	private BCryptPasswordEncoder encoder;



	public void save(User user) throws Exception {
		
		user.setName(user.getName().toUpperCase());


		validator1.validate(user);
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
			userDao.save(user);

		
	}

	public List<User> findAll() {
		
		return userDao.findAll();
	}

	public User findOne(int id) {
		
		return userDao.getOne(id);
	}

	public void delete(int id) {
	
		userDao.delete(id);;
	}

	

	public void update(User user) throws Exception {

		validator2.validate(user);
		userDao.save(user);
		
	}

	@Override
	public void addCommodityToUser(User user, Commodity commodity) {
		
		user.getCommodities().add(commodity);
		
	}

	@Override
	public void addUsertoBarberOrder(User user, BarberOrder barberOrder) {
		
		barberOrder.setUser(user);
		barberOrderDao.save(barberOrder);
		
	}

	@Override
	public List<User> userWithCommodity() {
		// TODO Auto-generated method stub
		return userDao.userWithCommodity() ;
	}

	@Override
	public User findByUuid(String uuid) {

		return userDao.findByUuid(uuid);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return userDao.findByNameOrPhoneNumber(s);
	}

	@Override
	public Page<User> findAllPages(Pageable pageable) {
		return userDao.findAll(pageable);
	}

	@Override
	public User findUserWithCommodity(int id) {

		User user = userDao.findUserWithCommodity(id);

		User returnedUser = new User();
		returnedUser.setId(user.getId());
		returnedUser.setName(user.getName());
		returnedUser.setPhoneNumber(user.getPhoneNumber());
		returnedUser.setEmail(user.getEmail());

		for(int i=0; i<user.getCommodities().size(); i++){

			Commodity commodity = new Commodity(user.getCommodities().get(i).getId(),
					user.getCommodities().get(i).getNameOfCommodity(),
					user.getCommodities().get(i).getPrice(),
					user.getCommodities().get(i).getDesription());

			commodity.setPathImage(user.getCommodities().get(i).getPathImage());

			returnedUser.getCommodities().add(commodity);
		}

		int counter = 0;

		for (Commodity commodity: user.getCommodities()) {

			returnedUser.getCommodities().get(counter).setSubcategoty(commodityDao.
							commodityWithSubcategories(commodity.getId()).getSubcategoty());

			counter++;

		}
		return returnedUser;
	}

	@Override
	public User findUserWithOrdersShop(int id) {

		return userDao.findUserWithOrdersShop(id);
	}

	@Override
	public User findUserWithBarberOrders(int id) {

		return userDao.findUserWithBarberOrders(id);
	}

	@Override
	public User findUserWithService(int id) {

		User user = userDao.findUserWithService(id);

		User returnedUser = new User();

		returnedUser.setId(user.getId());
		returnedUser.setName(user.getName());
		returnedUser.setPhoneNumber(user.getPhoneNumber());
		returnedUser.setEmail(user.getEmail());

		for(int i=0; i<user.getServicesOfBarbers().size(); i++){


			returnedUser.getServicesOfBarbers().add(new ServicesOfBarber(user.getServicesOfBarbers().get(i).getId(),
					user.getServicesOfBarbers().get(i).getNameOfBarberService(),
					user.getServicesOfBarbers().get(i).getPrice()));
		}

		int counter = 0;

		for (ServicesOfBarber servicesOfBarber: user.getServicesOfBarbers()) {

			returnedUser.getServicesOfBarbers().get(counter).setBarbers(
					barberServiceDao.findServiceOfBarberWithBarbers(servicesOfBarber.getId()).getBarbers());

			counter++;

		}
		return returnedUser;
	}
}
