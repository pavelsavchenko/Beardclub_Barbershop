package com.barbershop.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.barbershop.dao.CategoryOfCommodityDao;
import com.barbershop.dao.SubcategoryDao;
import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.entity.Subcategory;
import com.barbershop.service.CategoryOfCommodityService;
import com.barbershop.service.SubcategoryService;

@Service
public class CategoryOfCommodityServiceImpl implements CategoryOfCommodityService{

		@Autowired
		private CategoryOfCommodityDao categoryOfCommodityDao;
		@Autowired
		private SubcategoryDao subcategoryDao;

		@Autowired
		@Qualifier("categoryOfCommodityValidator")
		private Validator validator;

	public void save(CategoryOfCommodity categoryOfCommodity) throws Exception {
		
		categoryOfCommodity.setNameOfCategory(categoryOfCommodity.getNameOfCategory().toUpperCase());
		validator.validate(categoryOfCommodity);
		categoryOfCommodityDao.save(categoryOfCommodity);
		
	}

	public List<CategoryOfCommodity> findAll() {
		
		return categoryOfCommodityDao.findAll();
	}

	public CategoryOfCommodity findOne(int id) {
		
		return categoryOfCommodityDao.getOne(id);
	}

	public void delete(int id) {


			categoryOfCommodityDao.delete(id);
		
	}

	public void update(CategoryOfCommodity categoryOfCommodity) throws Exception {

		validator.validate(categoryOfCommodity);
		categoryOfCommodityDao.save(categoryOfCommodity);
		
	}

	@Override
	public List<CategoryOfCommodity> categoryWithSubcategory() {

		return categoryOfCommodityDao.categoryWithSubcategory();
	}

	@Override
	public void addSubcategoryToCategoryOfCommodity(CategoryOfCommodity categoryOfCommodity, Subcategory subcategory) {
		
		
		subcategory.setCategoryOfCommodity(categoryOfCommodity);
		subcategoryDao.save(subcategory);
		
	}


	@Override
	public Page<CategoryOfCommodity> findAllPages(Pageable pageable) {
		return categoryOfCommodityDao.findAll(pageable);
	}

	@Override
	public CategoryOfCommodity findCategoryWithSubcategory(int id) {
		return categoryOfCommodityDao.findCategoryWithSubcategory(id);
	}

}
