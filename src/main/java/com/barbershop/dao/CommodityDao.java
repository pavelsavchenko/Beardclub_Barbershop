package com.barbershop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barbershop.entity.Commodity;
import org.springframework.data.repository.query.Param;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {

	@Query("select distinct c from Commodity c left join fetch c.subcategoty")
	List<Commodity> commodityWithSubcategories();

	@Query("select distinct c from Commodity c left join fetch c.subcategoty where c.id=:id")
	Commodity commodityWithSubcategories(@Param("id") int id);

	@Query(value = "select distinct c from Commodity c left join fetch c.subcategoty",
			countQuery = "select count(c.id) from Commodity c")
	Page<Commodity> commodityWithSubcategoryPages(Pageable pageable);

	Commodity findByNameOfCommodity(String name);

	@Query("select distinct c from Commodity c left join fetch c.users where c.id=:id")
	Commodity commodityWithUsers(@Param("id") int id);
}
