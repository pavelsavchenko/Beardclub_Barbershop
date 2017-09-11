package com.barbershop.service;

import java.util.List;

import com.barbershop.entity.Barber;
import com.barbershop.entity.BarberOrder;
import com.barbershop.entity.Commodity;
import com.barbershop.entity.ServicesOfBarber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface BarberService {
	
	void save(Barber barber, MultipartFile image) throws Exception;
	List <Barber> findAll();
	Barber findOne(int id);
	void delete(int id);
	void update(Barber barber);
	void addBarberServiceToBarber(Barber barber, ServicesOfBarber servicesOfBarber);

	
	List<Barber> findBarberWithServices();
	Barber barberWithServices(int id);

	void updateBarber(int barber_id, String firstName, String lastName, String position);
	void updateBarber(int barber_id, String firstName, String lastName, String position, MultipartFile image);
	void  updateBarber(int barber_id, int services_id);
	Page<Barber> barberWithServices(Pageable pageable);
}
