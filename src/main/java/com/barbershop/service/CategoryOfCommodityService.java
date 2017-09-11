package com.barbershop.service;

import java.util.List;


import com.barbershop.entity.Barber;
import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.entity.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface CategoryOfCommodityService {
	
	void save(CategoryOfCommodity categoryOfCommodity) throws Exception;
	List <CategoryOfCommodity> findAll();
	CategoryOfCommodity findOne(int id);
	void delete(int id);
	void update(CategoryOfCommodity categoryOfCommodity) throws Exception;
	
	void addSubcategoryToCategoryOfCommodity(CategoryOfCommodity categoryOfCommodity, Subcategory subcategory);

	List<CategoryOfCommodity> categoryWithSubcategory();

	CategoryOfCommodity findCategoryWithSubcategory(int id);

	Page<CategoryOfCommodity> findAllPages(Pageable pageable);



	}
