package com.barbershop.serviceimpl;

import java.util.List;

import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.barbershop.dao.BarberOrderDao;
import com.barbershop.dao.BarberServiceDao;
import com.barbershop.entity.BarberOrder;
import com.barbershop.entity.ServicesOfBarber;
import com.barbershop.service.ServicesOfBarberService;

@Service
public class ServicesOfBarberServiceImpl implements ServicesOfBarberService {
	
	@Autowired
	private BarberServiceDao barberServiceDao;
	
	@Autowired
	private BarberOrderDao barberOrderDao;

	@Autowired
	@Qualifier("serviceOfBarberValidator")
	private Validator validator;
	
	public void save(ServicesOfBarber barberService) throws Exception {

		validator.validate(barberService);
		barberServiceDao.save(barberService);
		
	}

	public List<ServicesOfBarber> findAll() {
		
		return barberServiceDao.findAll();
	}

	public ServicesOfBarber findOne(int id) {
	
		return barberServiceDao.getOne(id);
	}

	public void delete(int id) {
		
		barberServiceDao.delete(id);
		
	}

	public void update(ServicesOfBarber barberService) {
	
		barberServiceDao.save(barberService);
		
	}

	@Override
	public Page<ServicesOfBarber> findAllPages(Pageable pageable) {
		return barberServiceDao.findAll(pageable);
	}

	@Override
	public ServicesOfBarber findServiceOfBarberWithBarbers(int id) {

		return barberServiceDao.findServiceOfBarberWithBarbers(id);
	}

	@Override
	public List<ServicesOfBarber> servicesWithBarbers() {
		return barberServiceDao.servicesWithBarbers();
	}
}
