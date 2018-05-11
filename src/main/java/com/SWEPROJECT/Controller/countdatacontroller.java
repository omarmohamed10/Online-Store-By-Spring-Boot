package com.SWEPROJECT.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.SWEPROJECT.Entities.Product;
import com.SWEPROJECT.Entities.countdata;
import com.SWEPROJECT.Entities.user;
import com.SWEPROJECT.Repositories.BrandRepository;
import com.SWEPROJECT.Repositories.ProductRepository;
import com.SWEPROJECT.Repositories.StoreRepository;
import com.SWEPROJECT.Repositories.UsreRepositories;

@Controller
public class countdatacontroller {
	 @Autowired
		private UsreRepositories repo;
	 @Autowired
	 	private StoreRepository repo1;
	 @Autowired
	 	private ProductRepository repo2;
	 @Autowired
	 	private BrandRepository repo3;
	 
    @GetMapping("/CountingUsers")
    public String countUsers(Model model)
    {
    	int counter1=0,counter2=0;
    	Iterable<user> usersIterable =repo.findAll();
        for(user user: usersIterable)
        {
        	if(user.getType().equals("buyer")) {
        		++counter1;
        	}
        	if(user.getType().equals("storeowner")) {
        		++counter2;
        	}
        }
        
        int pCounter=0;
        ArrayList<Product> products = 
        		(ArrayList<Product>) repo2.findAll();
       for(int i=0;i<products.size();++i) 
       {
    	   if(products.get(i).getDeleted()==1) {
    		   products.remove(i);
    		   i--;
    	   }
    	   else 
    	   {
    		   pCounter++;
    	   }
       }
        int SCounter=(int)repo1.count();
        int BCounter=(int)repo3.count();  
        Iterable<Product> productIterable =repo2.findAll();
        int ma = 0 ,  mi =99999999;
        double ave=0;
        double sum=0;
        for(Product P: productIterable)
        {
        	int x=P.getPrice();
        	ma=Math.max(ma, x);
        	mi=Math.min(mi, x);
        	sum+=x;
        }
        ave=sum/pCounter;
        System.out.println(ave);
        System.out.println(mi);
        System.out.println(ma);

        countdata x = new countdata();
        x.setNumberofbuyer(counter1);
        x.setNumberofstoreowner(counter2);
        x.setNumberofproduct(pCounter);
        x.setNumberofstores(SCounter);
        x.setNumberofbrands(BCounter);
        x.setMax(ma);
        x.setMin(mi);
        x.setAverage(ave);
        model.addAttribute("count",x);
    	return "CountingUsers";
    }
}
