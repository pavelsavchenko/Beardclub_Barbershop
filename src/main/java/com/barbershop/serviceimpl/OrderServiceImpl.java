package com.barbershop.serviceimpl;

import com.barbershop.dao.CommodityDao;
import com.barbershop.dao.OrderShopDao;
import com.barbershop.dao.UserDao;
import com.barbershop.entity.Commodity;
import com.barbershop.entity.OrdersShop;
import com.barbershop.entity.User;
import com.barbershop.service.OrderShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by pavelsavchenko on 19.06.17.
 */
@Service
public class OrderServiceImpl implements OrderShopService {

    @Autowired
    private OrderShopDao orderShopDao;

    @Autowired
    private CommodityDao commodityDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<OrdersShop> findAll() {
        return orderShopDao.findAll();
    }

    @Override
    public OrdersShop findOne(int id) {
        return orderShopDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        orderShopDao.delete(id);

    }

    @Override
    public void update(OrdersShop orders) {

        orderShopDao.save(orders);
    }

    @Override
    public void addIntoBasket(Principal principal, int id) {

        User user = userDao.findUserWithCommodity(Integer.parseInt(principal.getName()));

        Commodity commodity = commodityDao.findOne(id);

        user.getCommodities().add(commodity);

        userDao.save(user);

//        int sum=0;
//
//        for (Commodity c: user.getCommodities()) {
//
//            int price = c.getPrice();
//
//            sum+=price;
//        }
//        System.out.println(sum);

    }

    @Override
    @Transactional
    public void deleteFromBasket(int userId, int commodityId) {

        User user = userDao.findUserWithCommodity(userId);

        Commodity commodity = commodityDao.findOne(commodityId);

        user.getCommodities().remove(commodity);

        userDao.save(user);
    }

    @Override
    @Transactional
    public void buy(int userId) {

        OrdersShop ordersShop = new OrdersShop(LocalDateTime.now());

        orderShopDao.saveAndFlush(ordersShop);

        User  user = userDao.findUserWithCommodity(userId);

        ordersShop.setUser(user);

        int sum=0;

        for (Commodity commodity : user.getCommodities()) {

            ordersShop.getCommodities().add(commodity);

            String price = commodity.getPrice();

            sum+=Integer.parseInt(price);

            ordersShop.setResultPrice(sum);

            orderShopDao.save(ordersShop);
        }

        user.getCommodities().clear();
        userDao.save(user);
    }
}
