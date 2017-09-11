package com.barbershop.service;

import java.util.List;

import com.barbershop.entity.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;


public interface CommodityService {
	
	void save(Commodity commodity, MultipartFile image) throws Exception;
	List <Commodity> findAll();
	Commodity findOne(int id);
	void delete(int id);
	void update(int commodityId, String nameOfCommodity, String price, int subcategoryId) throws Exception;
	void update(int commodityId, String nameOfCommodity, String price, int subcategoryId, MultipartFile image) throws Exception;
	List<Commodity> findCommodityWithSubcategory();
	Commodity commodityWithSubcategories(int id);
	Commodity commodityWithUsers(int id);


	Page<Commodity> commodityWithSubcategoryPages(Pageable pageable);
}
