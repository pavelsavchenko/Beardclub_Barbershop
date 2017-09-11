package com.barbershop.controller;

import com.barbershop.editors.SubcategoryEditor;
import com.barbershop.entity.Subcategory;
import com.barbershop.service.SubcategoryService;
import com.barbershop.service.UserService;
import com.barbershop.validator.commodityUpdateValidator.CommodityUpdateValidatorMessages;
import com.barbershop.validator.commodityValidator.CommodityValidatorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.entity.Commodity;
import com.barbershop.service.CommodityService;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
public class CommodityController {
	
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private SubcategoryService subcategoryService;

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder){

		binder.registerCustomEditor(Subcategory.class, new SubcategoryEditor());
	}

	@RequestMapping(value="/commodity", method=RequestMethod.GET)
	public String commodity(Model model, @PageableDefault Pageable pageable){
		
		model.addAttribute("commodities", commodityService.commodityWithSubcategoryPages(pageable));
		model.addAttribute("subcategories", subcategoryService.findAll());
		model.addAttribute("commodity", new Commodity());
		return "views-admin-commodity";
	}
	
	@RequestMapping(value="/addCommodity", method=RequestMethod.POST)
	public String addCommodity(@ModelAttribute Commodity commodity, Model model,
							   @RequestParam("image") MultipartFile image,
							   @PageableDefault Pageable pageable){

		try {
			commodityService.save(commodity, image);
		} catch (Exception e) {
			if(e.getMessage().equals(CommodityValidatorMessage.COMMODITY_EMPTY_FIELD)||
					e.getMessage().equals(CommodityValidatorMessage.COMMODITY_NAME_ALREADY_EXIST)){
					model.addAttribute("commodityNameException", e.getMessage());
			}else if(e.getMessage().equals(CommodityValidatorMessage.PRICE_EMPTY_FIELD)||
					e.getMessage().equals(CommodityValidatorMessage.WRONG_CHARACTER)){
				model.addAttribute("priceException", e.getMessage());
			}else if(e.getMessage().equals(CommodityValidatorMessage.DESCRIPTION_EMPTY_FIELD)){
				model.addAttribute("descriptionException", e.getMessage());
			}
			model.addAttribute("commodities", commodityService.commodityWithSubcategoryPages(pageable));
			model.addAttribute("subcategories", subcategoryService.findSubcategoryWithCategory());

			return "views-admin-commodity";
		}

		return "redirect:/commodity";
		
	}
	
	@RequestMapping(value="/deleteCommodity/{id}", method=RequestMethod.GET)
	public String deleteCommodity(@PathVariable int id){
			
		commodityService.delete(id);
		
		return "redirect:/commodity";
	}

	@GetMapping("/shop")
	public String shop(Model model, @PageableDefault Pageable pageable,
					   Principal principal){


		System.out.println("shop");

		model.addAttribute("commodities", commodityService.commodityWithSubcategoryPages(pageable));
		model.addAttribute("subcategories", subcategoryService.findAll());
		model.addAttribute("userWithCommodities", userService.findUserWithCommodity(Integer.parseInt(principal.getName())));

		return "views-user-shop";
	}

	@GetMapping("/currentCommodity/{id}")
	public String currentCommodity(@PathVariable int id, Model model, Principal principal){

		model.addAttribute("currentCommodity", commodityService.commodityWithSubcategories(id));
		model.addAttribute("userWithCommodities", userService.findUserWithCommodity(Integer.parseInt(principal.getName())));

		return "views-user-singleCommodityPage";
	}

	@GetMapping("/updateCommodity/{id}")
	private String updateCommodity(@PathVariable int id, Model model){

		Commodity currentCommodity = commodityService.commodityWithSubcategories(id);

		model.addAttribute("currentCommodity", currentCommodity);
		model.addAttribute("subcategories", subcategoryService.findSubcategoryWithCategory());


		return "views-admin-updateCommodity";
	}

	@PostMapping("/updateCommodity/{id}")
	private String updateCommodity(@PathVariable int id,
								   @RequestParam String nameOfCommodity,
								   @RequestParam String price,
								   @RequestParam int subcategoryId,
								   @RequestParam MultipartFile image,
								   Model model){
		Commodity commodity = commodityService.commodityWithSubcategories(id);
		if(image.isEmpty()){
			try {
				commodityService.update(id, nameOfCommodity, price, subcategoryId);
			} catch (Exception e) {
				if(e.getMessage().equals(CommodityUpdateValidatorMessages.COMMODITY_EMPTY_FIELD)||
						e.getMessage().equals(CommodityUpdateValidatorMessages.COMMODITY_NAME_ALREADY_EXIST)){

					model.addAttribute("commodityNameException", e.getMessage());
				}else if(e.getMessage().equals(CommodityUpdateValidatorMessages.PRICE_EMPTY_FIELD)||
						e.getMessage().equals(CommodityUpdateValidatorMessages.WRONG_CHARACTER)){
					model.addAttribute("priceException", e.getMessage());
				}
				model.addAttribute("currentCommodity", commodity);
				model.addAttribute("subcategories", subcategoryService.findSubcategoryWithCategory());
				return "views-admin-updateCommodity";
			}
		}else{
			try {
				commodityService.update(id, nameOfCommodity, price, subcategoryId, image);
			} catch (Exception e) {
				if(e.getMessage().equals(CommodityUpdateValidatorMessages.COMMODITY_EMPTY_FIELD)||
						e.getMessage().equals(CommodityUpdateValidatorMessages.COMMODITY_NAME_ALREADY_EXIST)){

					model.addAttribute("commodityNameException", e.getMessage());
				}else if(e.getMessage().equals(CommodityUpdateValidatorMessages.PRICE_EMPTY_FIELD)||
						e.getMessage().equals(CommodityUpdateValidatorMessages.WRONG_CHARACTER)){
					model.addAttribute("priceException", e.getMessage());
				}
				model.addAttribute("currentCommodity", commodity);
				model.addAttribute("subcategories", subcategoryService.findSubcategoryWithCategory());
				return "views-admin-updateCommodity";
			}
		}

		return "redirect:/commodity";
	}

}
