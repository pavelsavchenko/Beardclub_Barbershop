package com.barbershop.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.entity.User;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query("select distinct u from User u left join fetch u.commodities")
	List<User> userWithCommodity();

	@Query("select distinct u from User u left join fetch u.commodities where u.id=:id")
	User findUserWithCommodity(@Param("id") int id);

	@Query("select distinct u from User u left join fetch u.servicesOfBarbers where u.id=:id")
	User findUserWithService(@Param("id") int id);

	@Query("select distinct u from User u left join fetch u.barberOrders")
	List<User> userWithOrders();

	@Query("select u from User u left join fetch u.ordersShops o left join fetch o.commodities where u.id=:id")
	User findUserWithOrdersShop(@Param("id") int id);

	@Query("select u from User u left join fetch u.barberOrders o left join fetch o.barberService where u.id=:id")
	User findUserWithBarberOrders(@Param("id") int id);

	User findByName(String name);

	@Query("select u from  User  u where u.name =:param or u.phoneNumber =:param")
	User findByNameOrPhoneNumber(@Param("param") String param);

	User findByEmail(String email);

	@Query ("select u from User u where u.uuid=:uuid")
	User findByUuid(@Param("uuid") String uuid);
}
