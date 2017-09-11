package com.barbershop.dao;

import com.barbershop.entity.ServicesOfBarber;
import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entity.BarberOrder;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BarberOrderDao extends JpaRepository<BarberOrder, Integer>{

}
