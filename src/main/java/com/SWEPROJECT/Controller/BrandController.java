package com.SWEPROJECT.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.SWEPROJECT.Entities.Brand;
import com.SWEPROJECT.Entities.Store;
import com.SWEPROJECT.Repositories.BrandRepository;

@Controller
public class BrandController 
{
	    @Autowired
		private BrandRepository repos;

		
		@GetMapping("/addBrand")
		public String ShowBrand(Model model) 
		{
			model.addAttribute("brand",new Brand());
			return "addBrand";
		}
		
		
		@PostMapping("/addBrand")
		public String ShowBrand(Model model,@ModelAttribute Brand brand) 
		{
			repos.save(brand);
			model.addAttribute("brand",new Brand());
			return "addBrand";
		}
		
		 @GetMapping("/allBrands")
		    public String AllBrands(Model model)
		    {
		  
		    	Iterable<Brand> Brands =repos.findAll();
		        ArrayList<Brand> Brandss=new ArrayList<Brand>();
		        for(Brand b: Brands)
		        {
		        	Brandss.add(b);
		        }        
		        model.addAttribute("brands",Brandss);
		        return "allBrands";
		    }

		
}
