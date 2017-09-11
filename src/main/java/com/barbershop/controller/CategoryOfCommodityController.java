package com.barbershop.controller;

import com.barbershop.service.SubcategoryService;
import com.barbershop.validator.categoryOfCommodityValidator.CategoryOfCommodityValidatorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.service.CategoryOfCommodityService;

@Controller
public class CategoryOfCommodityController {
	
	@Autowired
	private CategoryOfCommodityService categoryOfCommodityService;

	
	@RequestMapping(value="/category_of_commodity", method=RequestMethod.GET)
	public String category(Model model, @PageableDefault Pageable pageable){
		
		model.addAttribute("categories", categoryOfCommodityService.findAllPages(pageable));
		model.addAttribute("category", new CategoryOfCommodity());
		
		return "views-admin-categoryOfCommodity";
	}
	
	@RequestMapping(value="/addCategoryOfCommodity", method=RequestMethod.POST)
	public String addCategory(@RequestParam String nameOfCategory, Model model,
							  @PageableDefault Pageable pageable){

		try {
			categoryOfCommodityService.save(new CategoryOfCommodity(nameOfCategory));
		} catch (Exception e) {
			if(e.getMessage().equals(CategoryOfCommodityValidatorMessage.CATEGORY_ALREADY_EXIST)||
					e.getMessage().equals(CategoryOfCommodityValidatorMessage.CATEGORY_FIELD_EMPTY)){
				model.addAttribute("categoryException", e.getMessage());
			}
			model.addAttribute("categories", categoryOfCommodityService.findAllPages(pageable));
			return "views-admin-categoryOfCommodity";
		}

		return "redirect:/category_of_commodity";

	}
//	@PostMapping("/categoryOfCommodity")
//	public @ResponseBody int loadCategory(@RequestBody CategoryOfCommodity category){
//
//		System.out.println("category= " + category);
//		return 200;
//	}

	@RequestMapping(value="/deleteCategory/{id}", method=RequestMethod.GET)
	public String deleteCategory(@PathVariable int id){
			
		categoryOfCommodityService.delete(id);
		
		return "redirect:/category_of_commodity";
	}

	@GetMapping("/updateCategory/{id}")
	public String update(@PathVariable int id, Model model){

		CategoryOfCommodity categoryOfCommodity = categoryOfCommodityService.findCategoryWithSubcategory(id);

		model.addAttribute("currentCategoryOfCommodity", categoryOfCommodity);

		return "views-admin-updateCategory";
	}

	@PostMapping("/updateCategory/{id}")
	public String update(@PathVariable int id,
								 @RequestParam String nameOfCategory, Model model){

		CategoryOfCommodity categoryOfCommodity = categoryOfCommodityService.findCategoryWithSubcategory(id);

		categoryOfCommodity.setNameOfCategory(nameOfCategory);

		try {

			categoryOfCommodityService.save(categoryOfCommodity);
		} catch (Exception e) {
			if(e.getMessage().equals(CategoryOfCommodityValidatorMessage.CATEGORY_FIELD_EMPTY)||
					e.getMessage().equals(CategoryOfCommodityValidatorMessage.CATEGORY_ALREADY_EXIST)){
				model.addAttribute("categoryException", e.getMessage());
			}
			model.addAttribute("currentCategoryOfCommodity", categoryOfCommodity);
			return "views-admin-updateCategory";
		}

		return "redirect:/category_of_commodity";
	}
}
