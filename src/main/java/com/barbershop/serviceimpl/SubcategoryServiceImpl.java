package com.barbershop.serviceimpl;

import java.util.List;

import com.barbershop.dao.CategoryOfCommodityDao;
import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.barbershop.dao.CommodityDao;
import com.barbershop.dao.SubcategoryDao;
import com.barbershop.entity.Commodity;
import com.barbershop.entity.Subcategory;
import com.barbershop.service.SubcategoryService;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {
	
	@Autowired
	private SubcategoryDao subcategoryDao;
	
	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	private CategoryOfCommodityDao categoryOfCommodityDao;


	@Autowired
	@Qualifier("subcategoryValidator")
	private Validator validator;

	@Autowired
	@Qualifier("subcategoryUpdateValidator")
	private Validator updateValidator;
	
	public void save(Subcategory subcategory) throws Exception {
		
		subcategory.setNameOfSubcategory(subcategory.getNameOfSubcategory().toUpperCase());
		validator.validate(subcategory);
		subcategoryDao.save(subcategory);
		
	}

	public List<Subcategory> findAll() {
		
		return subcategoryDao.findAll();
	}

	public Subcategory findOne(int id) {
		
		return subcategoryDao.getOne(id);
	}

	public void delete(int id) {
		
		subcategoryDao.delete(id);
		
	}

	@Override
	public void update(int subcategoryId, String nameOfSubcategory, int categoryId) throws Exception {

		Subcategory subcategory = subcategoryDao.findSubcategoryWithCategory(subcategoryId);

		if(!subcategory.getNameOfSubcategory().equals(nameOfSubcategory)){
			subcategory.setNameOfSubcategory(nameOfSubcategory);
		}

		if(subcategory.getCategoryOfCommodity().getId() != categoryId){
			CategoryOfCommodity categoryOfCommodity = categoryOfCommodityDao.findCategoryWithSubcategory(categoryId);

			subcategory.setCategoryOfCommodity(categoryOfCommodity);
		}
		updateValidator.validate(subcategory);
		subcategoryDao.save(subcategory);
	}

	@Override
	public void addCommodityToSubcategory(Subcategory subcategory, Commodity commodity) {
		
		commodity.setSubcategoty(subcategory);
		commodityDao.save(commodity);
		
	}

	@Override
	public List<Subcategory> findSubcategoryWithCategory() {

		return subcategoryDao.subcategoryWithCategory();
	}

	@Override
	public Page<Subcategory> findAllPages(Pageable pageable) {
		return subcategoryDao.subcategoryWithCommodityPages(pageable);
	}

	@Override
	public Subcategory findSubcategoryWithCategory(int id) {
		return subcategoryDao.findSubcategoryWithCategory(id);
	}

	@Override
	public Subcategory subcategoryWithCategory(int id) {
		return subcategoryDao.subcategoryWithCategory(id);
	}

	@Override
	public void update(int subcategoryId, int categoryId) throws Exception {

		Subcategory subcategory = subcategoryDao.findSubcategoryWithCategory(subcategoryId);

		if(subcategory.getCategoryOfCommodity().getId() != categoryId){
			CategoryOfCommodity categoryOfCommodity = categoryOfCommodityDao.findCategoryWithSubcategory(categoryId);

			subcategory.setCategoryOfCommodity(categoryOfCommodity);
		}
		subcategoryDao.save(subcategory);
	}
}
