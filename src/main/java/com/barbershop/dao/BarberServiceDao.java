package com.barbershop.dao;

import com.barbershop.entity.Commodity;
import com.barbershop.entity.Subcategory;
import com.barbershop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entity.ServicesOfBarber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarberServiceDao extends JpaRepository<ServicesOfBarber, Integer> {

    ServicesOfBarber findByNameOfBarberService(String name);

    @Query("select distinct s from ServicesOfBarber s left join fetch s.barbers where s.id=:id")
    ServicesOfBarber findServiceOfBarberWithBarbers(@Param("id") int id);

    @Query("select distinct s from ServicesOfBarber s left join fetch s.users where s.id=:id")
    ServicesOfBarber serviceOfBarberWithUsers(@Param("id") int id);

    @Query("select distinct s from ServicesOfBarber s left join fetch s.barbers")
    List<ServicesOfBarber> servicesWithBarbers();

    @Query("select distinct s from ServicesOfBarber s left join fetch s.barberOrders")
    List<ServicesOfBarber> servicesWithOrders();
}
