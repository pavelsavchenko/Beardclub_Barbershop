package com.barbershop.dao;

import com.barbershop.entity.OrdersShop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pavelsavchenko on 19.06.17.
 */
public interface OrderShopDao  extends JpaRepository<OrdersShop, Integer> {
}
