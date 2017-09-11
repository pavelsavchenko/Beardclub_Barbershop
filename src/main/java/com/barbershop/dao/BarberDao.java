package com.barbershop.dao;

import java.util.List;

import com.barbershop.entity.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barbershop.entity.Barber;
import com.barbershop.entity.CategoryOfCommodity;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface BarberDao extends JpaRepository<Barber, Integer> {
	
	@Query("select distinct b from Barber b left join fetch b.barberServices")
	List<Barber> barberWithServices();

	@Query("select distinct b from Barber b left join fetch b.barberServices where b.id =:id")
	Barber barberWithServices(@Param("id") int id);

	@Query(value = "select distinct b from Barber b left join fetch b.barberServices",
			countQuery = "select count(b.id) from Barber b")
	Page<Barber> barberWithServicesPages(Pageable pageable);
}
