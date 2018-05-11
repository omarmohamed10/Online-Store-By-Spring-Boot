package com.SWEPROJECT.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.SWEPROJECT.Entities.Product;
import com.SWEPROJECT.Entities.Store;
import com.SWEPROJECT.Entities.user;
import com.SWEPROJECT.Repositories.ProductRepository;
import com.SWEPROJECT.Repositories.StoreRepository;

@Controller
public class StoreController 
{   
    @Autowired
	private StoreRepository reposs;
    @Autowired
	private ProductRepository repos;

	@GetMapping("/addStore")
	public String ShowAddStore(Model model) 
	{
		model.addAttribute("store",new Store());
		return "addStore";
	}
	
	
	@PostMapping("/addStore")
	public String ShowAddStore(Model model,@ModelAttribute Store s) 
	{
		reposs.save(s);
		model.addAttribute("store",new Store());
		return "addStore";
	}
	
	  
    @GetMapping("/AllStores")
    public String AllStores(Model model)
    {
    	Iterable<Store> STORES =reposs.findAll();
        ArrayList<Store> Stores=new ArrayList<Store>();
        for(Store Store: STORES)
        {
        	Stores.add(Store);
        }        
        model.addAttribute("stores",Stores);
        return "AllStores";
    }
   
    /*
    @GetMapping("/ProductsOfStore")
    public String ProductOfStore(Model model)
    {
    	return "ProductsOfStore";
    }
    
    
    
	@PostMapping("/ProductsOfStore")
	public String ProductOfStore(Model model,@ModelAttribute Store s) 
	{
		int counter=0;
		Iterable<Product> Products =repos.findAll();
        for(Product p: Products)
        {
        	if(p.getStoreName().equals(s.getName())) {
        		++counter;
        	}
        }   
        System.out.println(counter);
        
		return "ProductsOfStore";
	}
*/
	
}
