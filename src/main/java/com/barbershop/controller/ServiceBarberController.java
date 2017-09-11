package com.barbershop.controller;

import com.barbershop.validator.servicesOfBarberValidator.ServicesOfBarberValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.barbershop.entity.Barber;
import com.barbershop.entity.ServicesOfBarber;
import com.barbershop.service.ServicesOfBarberService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServiceBarberController {
	
	@Autowired
	private ServicesOfBarberService servicesOfBarberServices;
	
	@RequestMapping(value="/service_barber", method=RequestMethod.GET)
	public String service(Model model, @PageableDefault Pageable pageable){
		
		model.addAttribute("services", servicesOfBarberServices.findAllPages(pageable));
		model.addAttribute("service", new ServicesOfBarber());
		return "views-admin-serviceBarber";
	}
	
	@RequestMapping(value="/service_barber", method=RequestMethod.POST)
	public String addService(@ModelAttribute ServicesOfBarber service, Model model,
							 @PageableDefault Pageable pageable){

		System.out.println("service = " + service);

		try {
			servicesOfBarberServices.save(service);
		} catch (Exception e) {
			if(e.getMessage().equals(ServicesOfBarberValidatorMessages.SERVICE_FIELD_EMPTY)||
					e.getMessage().equals(ServicesOfBarberValidatorMessages.SERVICE_OF_BARBER_ALREADY_EXIST)){
				model.addAttribute("serviceNameException", e.getMessage());
			}else if(e.getMessage().equals(ServicesOfBarberValidatorMessages.PRICE_FIELD_EMPTY)||
					e.getMessage().equals(ServicesOfBarberValidatorMessages.WRONG_CHARACKTER)){
				model.addAttribute("priceException", e.getMessage());
			}
			model.addAttribute("services", servicesOfBarberServices.findAllPages(pageable));
			model.addAttribute("service", new ServicesOfBarber());
			return "views-admin-serviceBarber";
		}

		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteService/{id}", method=RequestMethod.GET)
	public String deleteService(@PathVariable int id){
			
		servicesOfBarberServices.delete(id);
		
		return "redirect:/service_barber";
	}

	@GetMapping("/updateServices/{id}")
	public String updateSerbice(@PathVariable int id, Model model){

		ServicesOfBarber servicesOfBarber = servicesOfBarberServices.findServiceOfBarberWithBarbers(id);

		model.addAttribute("currentService", servicesOfBarber);

		return "views-admin-updateService";
	}

	@PostMapping("/updateServices/{id}")
	public String updateService(@PathVariable int id, @RequestParam String nameOfBarberService,
														@RequestParam String price,
															Model model){

		ServicesOfBarber servicesOfBarber = servicesOfBarberServices.findServiceOfBarberWithBarbers(id);

		servicesOfBarber.setNameOfBarberService(nameOfBarberService);
		servicesOfBarber.setPrice(price);

		try {
			servicesOfBarberServices.save(servicesOfBarber);
		} catch (Exception e) {
			if(e.getMessage().equals(ServicesOfBarberValidatorMessages.SERVICE_FIELD_EMPTY)||
					e.getMessage().equals(ServicesOfBarberValidatorMessages.SERVICE_OF_BARBER_ALREADY_EXIST)){
				model.addAttribute("serviceException", e.getMessage());
			}else if(e.getMessage().equals(ServicesOfBarberValidatorMessages.PRICE_FIELD_EMPTY)||
					e.getMessage().equals(ServicesOfBarberValidatorMessages.WRONG_CHARACKTER)){
				model.addAttribute("priceServiceException", e.getMessage());

			}

			model.addAttribute("currentService", servicesOfBarber);
			return "views-admin-updateService";
		}

		return "redirect:/service_barber";
	}
}
