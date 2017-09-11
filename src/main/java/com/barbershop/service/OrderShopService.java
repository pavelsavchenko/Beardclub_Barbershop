package com.barbershop.service;

import com.barbershop.entity.OrdersShop;

import java.security.Principal;
import java.util.List;

/**
 * Created by pavelsavchenko on 19.06.17.
 */
public interface OrderShopService {

    List<OrdersShop> findAll();

    OrdersShop findOne(int id);

    void delete(int id);

    void update(OrdersShop orders);

    void addIntoBasket(Principal principal, int id);

    void deleteFromBasket(int userId, int commodityId);

    void buy(int userId);
}
