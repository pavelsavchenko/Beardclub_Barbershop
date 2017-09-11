package com.barbershop.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import com.barbershop.entity.Commodity;
import com.barbershop.entity.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barbershop.entity.CategoryOfCommodity;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryOfCommodityDao extends JpaRepository<CategoryOfCommodity, Integer> {

        @Query("select distinct c from CategoryOfCommodity c left join fetch c.subcategoties")
        List<CategoryOfCommodity> categoryWithSubcategory();

        @Query("select distinct c from CategoryOfCommodity c left join fetch c.subcategoties where c.id=:id")
        CategoryOfCommodity findCategoryWithSubcategory(@Param("id") int id);

        CategoryOfCommodity findByNameOfCategory(String category);
}
