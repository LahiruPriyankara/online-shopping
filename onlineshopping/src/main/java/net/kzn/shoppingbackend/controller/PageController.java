package net.kzn.shoppingbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbacken.dto.Category;
import net.kzn.shoppingbackend.dao.CategoryDAO;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		//passing the list of categeries
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value={"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	//method to load all product based on the category
	@RequestMapping(value={"/show/all/products"})
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		//passing the list of categeries
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	// <a href="${contextRoot}/show/category/${category.id}" class="list-group-item">${category.name}</a>
		@RequestMapping(value={"/show/category/{id}/products"})
		public ModelAndView showCategoryProducts(@PathVariable("id") int id){
			ModelAndView mv = new ModelAndView("page");
			//categeryDAO to fetch a single category
			Category category = null;
			category = categoryDAO.get(id);
			
			mv.addObject("title",category.getName());
			//passing the list of categories
			mv.addObject("categories",categoryDAO.list());
			//passing the single category object
			mv.addObject("category",category);

			
			mv.addObject("userClickCategoryProducts",true);
			return mv;
		}


}
