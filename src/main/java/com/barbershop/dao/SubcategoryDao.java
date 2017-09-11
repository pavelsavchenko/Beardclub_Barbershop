package com.barbershop.dao;

import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.entity.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entity.Subcategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubcategoryDao extends JpaRepository<Subcategory, Integer>{

    @Query("select distinct s from Subcategory s left join fetch s.categoryOfCommodity")
    List<Subcategory> subcategoryWithCategory();

    @Query(value = "select distinct s from Subcategory s left join fetch s.categoryOfCommodity",
            countQuery = "select count(s.id) from Commodity s")
    Page<Subcategory> subcategoryWithCommodityPages(Pageable pageable);

    Subcategory findByNameOfSubcategory(String subcategoryName);

    @Query("select distinct s from Subcategory s left join fetch s.categoryOfCommodity where s.id=:id")
    Subcategory findSubcategoryWithCategory(@Param("id") int id);

    @Query("select distinct s from Subcategory s left join fetch s.categoryOfCommodity where s.id=:id")
    Subcategory subcategoryWithCategory(@Param("id") int id);
}
