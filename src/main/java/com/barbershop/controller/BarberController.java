package com.barbershop.controller;

import com.barbershop.editors.BarberServicesEditor;
import com.barbershop.entity.ServicesOfBarber;
import com.barbershop.service.ServicesOfBarberService;
import com.barbershop.validator.barberValidator.BarberValidatorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.barbershop.entity.Barber;
import com.barbershop.entity.User;
import com.barbershop.service.BarberService;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BarberController {
	
	@Autowired
	private BarberService barberService;

	@Autowired
	private ServicesOfBarberService servicesOfBarberService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(ServicesOfBarber.class, new BarberServicesEditor());
	}
	@RequestMapping(value="/barber", method=RequestMethod.GET)
	public String user(Model model, @PageableDefault Pageable pageable){


		model.addAttribute("barbers", barberService.barberWithServices(pageable));
		model.addAttribute("barber", new Barber());
		model.addAttribute("services", servicesOfBarberService.findAll());
		return "views-admin-barber";
	}
	
	@RequestMapping(value="/addBarber", method=RequestMethod.POST)
	public String addUser(@ModelAttribute Barber barber, Model model,
						  @RequestParam("image") MultipartFile image,
						  @PageableDefault Pageable pageable){

		try {
			barberService.save(barber, image);
		} catch (Exception e) {
			if(e.getMessage().equals(BarberValidatorMessage.BARBER_FIRST_NAME_FIELD_EMPTY)){
				model.addAttribute("barberFirstNameException", e.getMessage());
			}else if(e.getMessage().equals(BarberValidatorMessage.BARBER_LAST_NAME_FIELD_EMPTY)){
				model.addAttribute("barberLastNameException", e.getMessage());
			}else if(e.getMessage().equals(BarberValidatorMessage.JOB_FIELD_EMPTY)){
				model.addAttribute("barberJobException", e.getMessage());
			}
			model.addAttribute("barbers", barberService.barberWithServices(pageable));
			model.addAttribute("services", servicesOfBarberService.findAll());
			return "views-admin-barber";
		}

		return "redirect:/barber";
	}
	
	@RequestMapping(value="/deleteBarber/{id}", method=RequestMethod.GET)
	public String deleteBarber(@PathVariable int id){
			
		barberService.delete(id);
		
		return "redirect:/barber";
	}

	@RequestMapping(value = "/updateBarber/{id}")
	public String update(@PathVariable int id, Model model){

		model.addAttribute("updateBarber", barberService.barberWithServices(id));
		model.addAttribute("services", servicesOfBarberService.servicesWithBarbers());

		return "views-admin-updateBarber";
	}

	@GetMapping("/updateBarber/{barber_id}/{services_id}")
	public String update(@PathVariable int barber_id,
						 @PathVariable int services_id, Model model){

		barberService.updateBarber(barber_id, services_id);
		model.addAttribute("updateBarber", barberService.barberWithServices(barber_id));
		model.addAttribute("services", servicesOfBarberService.servicesWithBarbers());
		return "redirect:/barber";
	}

	@PostMapping("/updateBarber/{id}")
	public String updateBarber(@PathVariable int id,
							   @RequestParam String firstName,
							   @RequestParam String lastName,
							   @RequestParam String position,
							   @RequestParam MultipartFile image,
							   Model model){

			Barber barber = barberService.barberWithServices(id);

		if(image.isEmpty()){
			barberService.updateBarber(id, firstName,lastName,position);
		}else{
			barberService.updateBarber(id, firstName,lastName,position,image);
		}
		return "redirect:/barber";
	}


}
