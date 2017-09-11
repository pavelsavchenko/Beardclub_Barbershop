package com.barbershop.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.barbershop.dao.SubcategoryDao;
import com.barbershop.entity.Subcategory;
import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.barbershop.dao.CommodityDao;
import com.barbershop.entity.Commodity;
import com.barbershop.service.CommodityService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	private SubcategoryDao subcategoryDao;

	@Autowired
	@Qualifier("commodityValidator")
	private Validator validator;

	@Autowired
	@Qualifier("commodityUpdateValidator")
	private Validator commodityUpdateValidator;
	
	
	public void save(Commodity commodity, MultipartFile image) throws Exception {

		validator.validate(commodity);

		commodityDao.saveAndFlush(commodity);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ commodity.getNameOfCommodity() + "/" + image.getOriginalFilename();

		commodity.setPathImage("resources/" + commodity.getNameOfCommodity() + "/" + image.getOriginalFilename());



		File filePath = new File(path);

		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}
		commodity.setNameOfCommodity(commodity.getNameOfCommodity().toUpperCase());

		commodityDao.save(commodity);
		
	}

	public List<Commodity> findAll() {
		
		return commodityDao.findAll();
	}

	public Commodity findOne(int id) {
		
		return commodityDao.getOne(id);
	}

	public void delete(int id) {
		
		commodityDao.delete(id);
		
	}


	@Override
	public void update(int commodityId, String nameOfCommodity, String price,  int subcategoryId) throws Exception {

		Commodity commodity = commodityDao.commodityWithSubcategories(commodityId);

		if(!commodity.getNameOfCommodity().equals(nameOfCommodity)){
			commodity.setNameOfCommodity(nameOfCommodity);
		}
		if(!commodity.getPrice().equals(price)){
			commodity.setPrice(price);
		}

		if(commodity.getSubcategoty().getId() != subcategoryId){
			Subcategory subcategory = subcategoryDao.findSubcategoryWithCategory(subcategoryId);
			commodity.setSubcategoty(subcategory);
		}

		commodityUpdateValidator.validate(commodity);
		commodityDao.save(commodity);
	}

	@Override
	public void update(int commodityId, String nameOfCommodity, String price, int subcategoryId, MultipartFile image) throws Exception {
		Commodity commodity = commodityDao.commodityWithSubcategories(commodityId);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ commodity.getNameOfCommodity() + "/" + image.getOriginalFilename();

		commodity.setPathImage("resources/" + commodity.getNameOfCommodity() + "/" + image.getOriginalFilename());



		File filePath = new File(path);

		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		if(!commodity.getNameOfCommodity().equals(nameOfCommodity)){
			commodity.setNameOfCommodity(nameOfCommodity);
		}
		if(!commodity.getPrice().equals(price)){
			commodity.setPrice(price);
		}

		if(commodity.getSubcategoty().getId() != subcategoryId){
			Subcategory subcategory = subcategoryDao.findSubcategoryWithCategory(subcategoryId);
			commodity.setSubcategoty(subcategory);
		}

		commodityUpdateValidator.validate(commodity);
		commodityDao.save(commodity);
	}

	@Override
	public List<Commodity> findCommodityWithSubcategory() {
		// TODO Auto-generated method stub
		return commodityDao.commodityWithSubcategories();
	}

	@Override
	public Page<Commodity> commodityWithSubcategoryPages(Pageable pageable) {
		return commodityDao.commodityWithSubcategoryPages(pageable);
	}

	@Override
	public Commodity commodityWithSubcategories(int id) {
		return commodityDao.commodityWithSubcategories(id);
	}

	@Override
	public Commodity commodityWithUsers(int id) {
		return commodityDao.commodityWithUsers(id);
	}
}
