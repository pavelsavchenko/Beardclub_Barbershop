package com.barbershop.controller;

import com.barbershop.entity.User;
import com.barbershop.service.MailSenderService;
import com.barbershop.service.OrderShopService;
import com.barbershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * Created by pavelsavchenko on 19.06.17.
 */
@Controller
public class OrderShopController {

    @Autowired
    private  OrderShopService orderShopService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping("/addToBasket/{id}")
    public String addToBasket(Principal principal, @PathVariable int id){


        orderShopService.addIntoBasket(principal, id);

        System.out.println("add into basket");

        return "redirect:/shop";
    }

    @GetMapping("/deleteFromBasket/{userId}/{commodityId}")
    public String deleteFromBasket(@PathVariable int userId, @PathVariable int commodityId){

        System.out.println("delete");
        orderShopService.deleteFromBasket(userId, commodityId);

        return "redirect:/basket";
    }

    @PostMapping("/buy/{userId}")
    public String buy( Principal principal){

        User user = userService.findUserWithOrdersShop(Integer.parseInt(principal.getName()));
        orderShopService.buy(Integer.parseInt(principal.getName()));

        int codeOfOrder = (int) Math.random()*1000000+1;

        String theme = "Ваше замовлення № " + codeOfOrder + " прийнято на обробку!";

        String mailBody =
                "Для підтвердження реєстрації перейдіть по посиланню    http://localhost:8080/confirm/";

        mailSenderService.senfMail(theme, mailBody, user.getEmail());


        return "redirect:/profileUser";
    }


}
