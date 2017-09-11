package com.barbershop.controller;

import com.barbershop.editors.CategoryEditor;
import com.barbershop.service.CategoryOfCommodityService;
import com.barbershop.validator.subcategoryUpdateValidator.SubcategoryUpdateValidatorMessages;
import com.barbershop.validator.subcategoryValidator.SubcategoryValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.entity.Subcategory;
import com.barbershop.service.SubcategoryService;

import java.security.Principal;

@Controller
public class SubcategoryController {
	
	@Autowired
	private SubcategoryService subcategoryService;

	@Autowired
	private CategoryOfCommodityService categoryOfCommodityService;

	@InitBinder
	public void initBinder(WebDataBinder binder){

		binder.registerCustomEditor(CategoryOfCommodity.class, new CategoryEditor());
	}
	
	@RequestMapping(value="/subcategory_of_commodity", method = RequestMethod.GET)
	public String subcategory(Model model, @PageableDefault Pageable pageable){
		
		model.addAttribute("subcategories", subcategoryService.findAllPages(pageable));
		model.addAttribute("categories", categoryOfCommodityService.findAll());
		model.addAttribute("subcategory", new Subcategory());
		return "views-admin-subcategoryOfCommodity";
	}
	
	@RequestMapping(value="/addSubategoryOfCommodity", method=RequestMethod.POST)
	public String addSubategory(@ModelAttribute Subcategory subCategory, Model model,
								@PageableDefault Pageable pageable){

		try {
			subcategoryService.save(subCategory);
		} catch (Exception e) {
				if(e.getMessage().equals(SubcategoryValidatorMessages.SUBCATEGORY_ALREADY_EXIST)||
						e.getMessage().equals(SubcategoryValidatorMessages.SUBCATEGORY_EMPTY_FIELD)){
					model.addAttribute("subcategoryException", e.getMessage());
				}
			model.addAttribute("subcategories", subcategoryService.findAllPages(pageable));
				model.addAttribute("categories", categoryOfCommodityService.categoryWithSubcategory());

				return "views-admin-subcategoryOfCommodity";
		}

		return "redirect:/subcategory_of_commodity";
		
	}
	
	@RequestMapping(value="/deleteSubcategory/{id}", method=RequestMethod.GET)
	public String deleteSubcategory(@PathVariable int id){
			
		subcategoryService.delete(id);
		
		return "redirect:/subcategory_of_commodity";
	}

	@GetMapping("/updateSubcategory/{id}")
	private String updateSubcategory(@PathVariable int id, Model model){

		Subcategory currentSubcategory = subcategoryService.findSubcategoryWithCategory(id);

		model.addAttribute("currentSubcategory", currentSubcategory);

		model.addAttribute("categories", categoryOfCommodityService.categoryWithSubcategory());

		return "views-admin-updateSubcategory";
	}

	@PostMapping("/updateSubcategory/{id}")
	private String updateSubcategory(@PathVariable int id,
									 Model model, @RequestParam String nameOfSubcategory,
										@RequestParam int categoryId){

		Subcategory currentSubcategory = subcategoryService.findSubcategoryWithCategory(id);

		currentSubcategory.setNameOfSubcategory(nameOfSubcategory);


				if(subcategoryService.findSubcategoryWithCategory(id).getNameOfSubcategory().equals(nameOfSubcategory)){

					System.out.println("UPDATE");
					try {
						subcategoryService.update(id, categoryId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
					subcategoryService.update(id,nameOfSubcategory, categoryId);
					} catch (Exception e) {
						if(e.getMessage().equals(SubcategoryUpdateValidatorMessages.SUBCATEGORY_EMPTY_FIELD) ||
								e.getMessage().equals(SubcategoryUpdateValidatorMessages.SUBCATEGORY_ALREADY_EXIST)){
							model.addAttribute("subcategoryNameException", e.getMessage());
						}
						System.out.println("ERROR");
						model.addAttribute("currentSubcategory", currentSubcategory);
						model.addAttribute("categories", categoryOfCommodityService.categoryWithSubcategory());
						return "views-admin-updateSubcategory";
					}
				}




		return "redirect:/subcategory_of_commodity";
	}
}
