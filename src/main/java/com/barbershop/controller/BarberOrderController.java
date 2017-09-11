package com.barbershop.controller;

import com.barbershop.entity.Barber;
import com.barbershop.entity.BarberOrder;
import com.barbershop.service.BarberOrderService;
import com.barbershop.service.BarberService;
import com.barbershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;

/**
 * Created by pavelsavchenko on 08.07.17.
 */
@Controller
public class BarberOrderController {

    @Autowired
    private BarberService barberService;

    @Autowired
    private BarberOrderService barberOrderService;

    @Autowired
    private UserService userService;

    @GetMapping("/orderBarber")
    private String barberOrder(Model model){

        model.addAttribute("barbers", barberService.findBarberWithServices());

        return "views-user-barberOrder";
    }

    @GetMapping("/chooseBarber/{id}")
    private String chooseBarber(@PathVariable int id, Model model, Principal principal){

        Barber barber = barberService.barberWithServices(id);

        model.addAttribute("currentBarber", barber);

        model.addAttribute("userWithServices", userService.findUserWithService(Integer.parseInt(principal.getName())));


        return "views-user-chooseService";
    }

    @GetMapping("/addToOrder/{id}")
    private String addToOrder(Principal principal, @PathVariable int id, Model model){

        System.out.println("Add to barber order");

        barberOrderService.addToBarberOrder(principal, id);

        model.addAttribute("userWithServices", userService.findUserWithService(Integer.parseInt(principal.getName())));

        return "views-user-addToOrder";

    }

    @GetMapping("/deleteFromBarberOrder/{userId}/{serviceId}")
    public String deleteFromBarberOrder(@PathVariable int userId,
                                        @PathVariable int serviceId){

        barberOrderService.deleteFromBarberOrder(userId, serviceId);




        return "redirect:/orderBarber";
    }

    @PostMapping("/entryToBarber/{userId}")
    public String entryToBarber(@PathVariable int userId, Model model, @RequestParam String data) throws Exception {


        BarberOrder barberOrder = new BarberOrder(LocalDateTime.now());


            barberOrderService.entryToBarber(userId,barberOrder,data);



        return "redirect:/";
    }
}
