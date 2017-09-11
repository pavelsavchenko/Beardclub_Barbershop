package com.barbershop.service;

import java.util.List;

import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.entity.Commodity;
import com.barbershop.entity.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface SubcategoryService {
	
	void save(Subcategory subcategory) throws Exception;

	List <Subcategory> findAll();

	Subcategory findOne(int id);

	void delete(int id);

	void update(int subcategoryId, String nameOfSubcategory, int categoryId) throws Exception;

	void update(int subcategoryId, int categoryId) throws Exception;

	void addCommodityToSubcategory(Subcategory subcategory, Commodity commodity);

	List<Subcategory> findSubcategoryWithCategory();

	Subcategory findSubcategoryWithCategory( int id);

	Page<Subcategory> findAllPages(Pageable pageable);

	Subcategory subcategoryWithCategory(int id);
}
