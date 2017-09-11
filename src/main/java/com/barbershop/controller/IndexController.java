package com.barbershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model){
		
		return "views-base-index";
	}

	@PostMapping("/")
	public String indexAfterLogin(Model model){

		return "views-base-index";
	}

	@GetMapping("/contacts")
		public String contacts(){

			return "views-user-contacts";
		}

		@GetMapping("/shipping_and_payment")
	public String shippingAndPayment(){

			return "views-user-shippingAndPayment";
		}

		@GetMapping("/login")
	public String login(){

		return "views-base-index";
		}
	}

