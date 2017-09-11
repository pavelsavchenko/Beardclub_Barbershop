package com.barbershop.service;

import java.util.List;

import com.barbershop.entity.BarberOrder;
import com.barbershop.entity.ServicesOfBarber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ServicesOfBarberService {
	
	void save(ServicesOfBarber barberService) throws Exception;
	List <ServicesOfBarber> findAll();
	ServicesOfBarber findOne(int id);
	void delete(int id);
	void update(ServicesOfBarber barberService);
	List<ServicesOfBarber> servicesWithBarbers();

	Page<ServicesOfBarber> findAllPages(Pageable pageable);
	ServicesOfBarber findServiceOfBarberWithBarbers(int id);

}
