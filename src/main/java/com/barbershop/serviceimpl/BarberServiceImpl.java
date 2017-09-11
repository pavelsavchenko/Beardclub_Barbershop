package com.barbershop.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.barbershop.dao.BarberServiceDao;
import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.barbershop.dao.BarberDao;
import com.barbershop.dao.BarberOrderDao;
import com.barbershop.entity.Barber;
import com.barbershop.entity.BarberOrder;
import com.barbershop.entity.ServicesOfBarber;
import com.barbershop.service.BarberService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BarberServiceImpl implements BarberService {
		
		@Autowired
		private BarberDao barberDao;
		
		@Autowired
		private BarberOrderDao barberOrderDao;

		@Autowired
		private BarberServiceDao barberServiceDao;

		@Autowired
		@Qualifier("barberValidator")
		private Validator validator;
		
		
	
	public void save(Barber barber, MultipartFile image) throws Exception {

		validator.validate(barber);
		barberDao.saveAndFlush(barber);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ barber.getLastName() + "/" + image.getOriginalFilename();

		barber.setPathImage("resources/" + barber.getLastName() + "/" + image.getOriginalFilename());

		File filePath = new File(path);

		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}
		barber.setFirstName(barber.getFirstName().toUpperCase());
		barber.setLastName(barber.getLastName().toUpperCase());
		barberDao.save(barber);
		
	}

	public List<Barber> findAll() {
		
		return barberDao.findAll();
	}

	public Barber findOne(int id) {
		
		return barberDao.getOne(id);
	}

	public void delete(int id) {
		
		barberDao.delete(id);
		
	}

	public void update(Barber barber) {
		
		barberDao.save(barber);
			
	}


	@Override
	public void addBarberServiceToBarber(Barber barber, ServicesOfBarber servicesOfBarber) {
		
		barber.getBarberServices().add(servicesOfBarber);
		barberDao.save(barber);
		
	}

	@Override
	public List<Barber> findBarberWithServices() {
		// TODO Auto-generated method stub
		return barberDao.barberWithServices();
	}

	@Override
	public Barber barberWithServices(int id) {
		return barberDao.barberWithServices(id);
	}

	@Override
	public void updateBarber(int barber_id, String firstName, String lastName, String position) {

		Barber barber = barberDao.barberWithServices(barber_id);

		if(!barber.getFirstName().equals(firstName)){
			barber.setFirstName(firstName);
		}
		if(!barber.getLastName().equals(lastName)){
			barber.setLastName(lastName);
		}
		if(!barber.getPosition().equals(position)){
			barber.setPosition(position);
		}

		barberDao.save(barber);
	}

	@Override
	public void updateBarber(int barber_id, String firstName, String lastName, String position, MultipartFile image) {
		Barber barber = barberDao.barberWithServices(barber_id);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ barber.getLastName() + "/" + image.getOriginalFilename();

		barber.setPathImage("resources/" + barber.getLastName() + "/" + image.getOriginalFilename());

		File filePath = new File(path);

		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		if(!barber.getFirstName().equals(firstName)){
			barber.setFirstName(firstName);
		}
		if(!barber.getLastName().equals(lastName)){
			barber.setLastName(lastName);
		}
		if(!barber.getPosition().equals(position)){
			barber.setPosition(position);
		}

		barberDao.save(barber);
	}

	@Override
	public void updateBarber(int barber_id, int services_id) {

		Barber barber = barberDao.barberWithServices(barber_id);
		for (ServicesOfBarber servicesOfBarber : barber.getBarberServices()) {

			if(servicesOfBarber.getId() == services_id){
				servicesOfBarber.setBarbers(null);
			}
			barberServiceDao.save(servicesOfBarber);
		}
	}

	@Override
	public Page<Barber> barberWithServices(Pageable pageable) {
		return barberDao.barberWithServicesPages(pageable);
	}
}
