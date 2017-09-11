package com.barbershop.controller;


import com.barbershop.service.MailSenderService;
import com.barbershop.validator.Validator;
import com.barbershop.validator.userLoginValidator.UserLoginValidatorMessage;
import com.barbershop.validator.userUpdateValidator.UserUpdateValidatorMessages;
import com.barbershop.validator.userValidator.UserValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.barbershop.entity.User;
import com.barbershop.service.UserService;

import java.security.Principal;
import java.util.UUID;

@Controller
public class UserController {
	
		@Autowired
		private UserService userService;

		@Autowired
		@Qualifier("userLoginValidator")
		private Validator validator;

		@Autowired
		private MailSenderService mailSenderService;


		
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String user(Model model){

		model.addAttribute("user", new User());
		return "views-user-user";
	}

	@GetMapping("/signIn")
	public String signIn(Model model){

		return "views-user-signIn";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute User user, Model model,
						  @PageableDefault Pageable pageable){

		String uuid = UUID.randomUUID().toString();

		user.setUuid(uuid);


		try {
			userService.save(user);
		} catch (Exception e) {
			if(e.getMessage().equals(UserValidatorMessages.EMPTY_USERNAME_FIELD) ||
					e.getMessage().equals(UserValidatorMessages.USERNAME_ALREADY_EXIST)){
				model.addAttribute("usernameException", e.getMessage());
			}else if(e.getMessage().equals(UserValidatorMessages.EMPTY_PHONE_NUMBER_FIELD)||
					e.getMessage().equals(UserValidatorMessages.PHONE_LENGTH)||
					e.getMessage().equals(UserValidatorMessages.WRONG_CHARACTER)){
				model.addAttribute("phoneNumberException", e.getMessage());
			}else if(e.getMessage().equals(UserValidatorMessages.MISSING_CHARACTER)||
					e.getMessage().equals(UserValidatorMessages.EMAIL_ALREADY_EXIST)){
				model.addAttribute("emailException", e.getMessage());
			}else if(e.getMessage().equals(UserValidatorMessages.EMPTY_PASSWORD_FIELD)||
					e.getMessage().equals(UserValidatorMessages.INVALID_LENGTH)){
				model.addAttribute("passwordException", e.getMessage());
			}

			model.addAttribute("users", userService.findAllPages(pageable));
			model.addAttribute("user", new User());
			return "views-user-user";
		}
			String theme = "Welcome to Beardclub Barbershop";

		String mailBody =
				"Для підтвердження реєстрації перейдіть по посиланню    http://localhost:8080/confirm/" + uuid;

		mailSenderService.senfMail(theme, mailBody, user.getEmail());

		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable int id){
			
		userService.delete(id);
		
		return "redirect:/allUsers";
	}


	@GetMapping("/confirm/{uuid}")
	public String confirm(@PathVariable String uuid){

		User user = userService.findByUuid(uuid);
		user.setEnable(true);

		try {
			userService.update(user);
		} catch (Exception e) {
			System.out.println("ERROR");
		}

		return "redirect:/";
	}

	@GetMapping("/profileUser")
	public String profileUser(Principal principal, Model model){


		model.addAttribute("userProfile", userService.findUserWithCommodity(Integer.parseInt(principal.getName())));
		model.addAttribute("userHistoryOrders", userService.findUserWithOrdersShop(Integer.parseInt(principal.getName())));
		model.addAttribute("userHistoryBarberOrders", userService.findUserWithBarberOrders(Integer.parseInt(principal.getName())));

		return "views-user-profileUser";
	}

	@GetMapping("/allUsers")
	public String showAllUsers(Model model, @PageableDefault Pageable pageable){

		model.addAttribute("users", userService.findAllPages(pageable));
		return "views-admin-allUsers";
	}



	@PostMapping("/failureLogin")
	public String failureLogin(Model model,
							   @RequestParam String username,
							   @RequestParam String password){


		try {
			validator.validate(new User(username, password));
		} catch (Exception e) {

			if(e.getMessage().equals(UserLoginValidatorMessage.EMPTY_USERNAME_FIELD)||
					e.getMessage().equals(UserLoginValidatorMessage.EMPTY_PASSWORD_FIELD)||
					e.getMessage().equals(UserLoginValidatorMessage.WRONG_USERNAME_OR_PASSWORD)){

				model.addAttribute("userLoginException", e.getMessage());
			}

		}
		model.addAttribute("user", new User());

		return "views-user-signIn";
	}
	@GetMapping("/basket")
	private String basket(Principal principal, Model model){

		model.addAttribute("userBasket", userService.findUserWithCommodity(Integer.parseInt(principal.getName())));
		return "views-user-basket";
	}

	@GetMapping("/updateUsers/{id}")
	public String updateUser(@PathVariable int id, Model model, Principal principal){

		User currentUser = userService.findUserWithCommodity(id);


		model.addAttribute("currentUser", currentUser);

		return "views-user-updateUser";
	}

	@PostMapping("/updateUsers/{id}")
	public String updateUser(@PathVariable int id, Model model,
							 	@RequestParam String name,
							 		@RequestParam String phoneNumber){

		User currentUser = userService.findUserWithCommodity(id);

		currentUser.setName(name);
		currentUser.setPhoneNumber(phoneNumber);


		try {
			userService.update(currentUser);
		} catch (Exception e) {
			if(e.getMessage().equals(UserUpdateValidatorMessages.EMPTY_USERNAME_FIELD)){
				model.addAttribute("userException", e.getMessage());
			}else if(e.getMessage().equals(UserUpdateValidatorMessages.EMPTY_PHONE_NUMBER_FIELD)||
					e.getMessage().equals(UserUpdateValidatorMessages.PHONE_LENGTH)){
				model.addAttribute("phoneException", e.getMessage());
			}
			System.out.println("ERROR");
			model.addAttribute("currentUser", currentUser);
			return "views-user-updateUser";
		}
		return "redirect:/profileUser";

	}


	
}
