package com.SWEPROJECT.Controller;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.SWEPROJECT.Entities.Payment;
import com.SWEPROJECT.Entities.Product;
import com.SWEPROJECT.Repositories.ProductRepository;

@Controller
public class ProductController 
{
	
	    @Autowired
		private ProductRepository repos;

		@GetMapping("/addProduct")
		public String ShowAddProduct(Model model) 
		{
			model.addAttribute("product",new Product());
			return "addProduct";
		}
		
		
		@PostMapping("/addProduct")
		public String AddProduct(Model model,@ModelAttribute Product p) 
		{
			repos.save(p);
			model.addAttribute("product",new Product());
			return "addProduct";
		}
		
	    @GetMapping("/AllProducts")
	    public String allProducts(Model model){
	    	model.addAttribute("payment", new Payment());
	        ArrayList<Product> products = 
	        		(ArrayList<Product>) repos.findAll();
	       for(int i=0;i<products.size();++i) {
	    	   if(products.get(i).getDeleted()==1) {
	    		   products.remove(i);
	    		   i--;
	    	   }
	       }
	        model.addAttribute("products",products);
	        return "AllProducts";
	    }
		  
	    @GetMapping("/adminp")
	    public String products(Model model){
	    	model.addAttribute("payment", new Payment());
	        ArrayList<Product> products = 
	        		(ArrayList<Product>) repos.findAll();
	    	for(int i=0;i<products.size();++i) {
	 	    	   if(products.get(i).getDeleted()==1) {
	 	    		  products.remove(i);
	 	    		   i--;
	 	    	   }
	 	       }
	        model.addAttribute("products",products);
	        return "adminp";
	    }
	    
	    
	    @PostMapping("/AllProducts")
	    public String buy(@ModelAttribute Payment pay,Model model){
	        Iterable<Product> products =repos.findAll();
	        boolean ch= false;
        	for(Product p: products)
	        {
	        	   	if( pay.getName().equals(p.getName())
		        			&& pay.getAmount()<= p.getAmout()){
		        		ch=true;
		        		System.out.println("Yes You Can Buy");
		        		System.out.println(p.getId());
		        		repos.deleteById(p.getId());
		        		p.setAmout(p.getAmout()-pay.getAmount());
		        		if(p.getAmout()>0) 
		        		{
		        			repos.save(p);
		        		}
		        	}
	        	    if(!ch)
			        {
			        	System.out.println("can't");
			        }
	        }
	        model.addAttribute("payment", new Payment());
	        ArrayList<Product> pp = (ArrayList<Product>) repos.findAll();
	        model.addAttribute("products",pp);
	        return "AllProducts";
	    }
	    
	    
	    
	    @GetMapping("/Method")
	    public String Methods(Model model){
	    	model.addAttribute("payment", new Payment());
	        ArrayList<Product> products = 
	        		(ArrayList<Product>) repos.findAll();
	        for(int i=0;i<products.size();++i) {
	 	    	   if(products.get(i).getDeleted()==1) {
	 	    		  products.remove(i);
	 	    		   i--;
	 	    	   }
	 	       }
	        model.addAttribute("products",products);
	        return "Method";
	    }
	    
	    
	    @PostMapping("/Method")
	    public String Methods(@ModelAttribute Payment pay,Model model) throws IOException{
	        Iterable<Product> products =repos.findAll();
        	
	        for(Product p: products)
	        {
	        	if(pay.getType().equals("DeleteAll")) 
	        	{
	        		repos.deleteAll();
	        		break;
	        	}
	        	if(pay.getType().equals("Delete")
	        	 &&pay.getAmount().equals(p.getAmout())
	        	 &&pay.getName().equals(p.getName()))
	        	{
	        		p.setDeleted(1);
	        		repos.save(p);
	        		break;
	        	}
	        	if(pay.getType().equals("Edit")
	        	 &&pay.getName().equals(p.getName())) 
	        	{
	        		p.setAmout(pay.getAmount());
	        		repos.save(p);
	        		break;
	        	}
	        	if(pay.getType().equals("Undo")) 
	        	{
	        		p.setDeleted(0);
	        		repos.save(p);
	        	}
	        }
	        model.addAttribute("payment", new Payment());
	        ArrayList<Product> pp = (ArrayList<Product>) repos.findAll();
	        
	        	for(int i=0;i<pp.size();++i) {
	 	    	   if(pp.get(i).getDeleted()==1) {
	 	    		   pp.remove(i);
	 	    		   i--;
	 	    	   }
	 	       }
	        model.addAttribute("products",pp);
	        return "Method";
	    } 
	    
	    
}
