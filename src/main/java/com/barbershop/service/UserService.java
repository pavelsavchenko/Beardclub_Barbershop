package com.barbershop.service;

import java.security.Principal;
import java.util.List;

import com.barbershop.entity.BarberOrder;
import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.entity.Commodity;
import com.barbershop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface UserService {
	
	void save(User user) throws Exception;
	List <User> findAll();
	User findOne(int id);
	void delete(int id);
	void update(User user) throws Exception;
	
	void addCommodityToUser(User user, Commodity commodity);

	void addUsertoBarberOrder(User user, BarberOrder barberOrder);

	List<User> userWithCommodity();

	User findUserWithCommodity(int id);

	User findUserWithOrdersShop(int id);

	User findUserWithBarberOrders(int id);

	User findUserWithService(int id);

	User findByUuid(String uuid);

	Page<User> findAllPages(Pageable pageable);


}
