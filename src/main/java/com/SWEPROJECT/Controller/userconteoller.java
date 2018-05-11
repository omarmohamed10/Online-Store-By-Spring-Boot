package com.SWEPROJECT.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.SWEPROJECT.Entities.user;
import com.SWEPROJECT.Repositories.UsreRepositories;



@Controller
public class userconteoller 
{
	@Autowired
	private UsreRepositories repo;
	private static user curUser = null;
    private static boolean signedIn = false;

    
	    @GetMapping("/singup")
	    public String addUser (Model model){
	        model.addAttribute("user",new user());
	        return "singup";
	    }
	 
	    
	    @RequestMapping (value="/singup",method = RequestMethod.POST)
	    public String addUser(Model model, @ModelAttribute user u) throws InterruptedException
		{
	    	if(u.getType().equals("buyer"))
	    	{
	    		repo.save(u);
	    		return "HomePage";
	    	}
	    	if(u.getType().equals("storeowner")) {
	    		repo.save(u);
	    		return "owner";
	    	}
	    	if(u.getType().equals("collaborator"))
	    	{
	    		repo.save(u);
	    		return "collaborator";
	    	}
	    	if(u.getType().equals("admin"))
	    	{
	    		repo.save(u);
	    		return "Admin";
	    	}
	    	else 
	    	{
	    		u.setType("");
	    		u.setEmail("");
	    		u.setMobile("");
	    		u.setPassword("");
	    		u.setUsrename("");	    		
	    		return "singup";
	    	}
	    }
	    
	    
	    @GetMapping("/Login")
	    public String signIn (Model model)
	    {
	        model.addAttribute("user",new user());
	        return "Login";
	    }

	    @RequestMapping (value="/Login",method = RequestMethod.POST)
	    public String signIn (Model model, @ModelAttribute user u)
	    {
	        ArrayList<user> users = (ArrayList<user>) repo.findAll();
	        for (user TheUser: users)
	        {
	            if( (TheUser.getPassword().equals(u.getPassword())
                   &&TheUser.getUsrename().equals(u.getUsrename())))
	            {
	                curUser = TheUser;
	                signedIn = true;
	                
	                if(curUser.getType().equals("storeowner")) {
	                	return "owner";
	                }
	                if(curUser.getType().equals("collaborator")) {
	                	return "collaborator";
	                }
	                if(curUser.getType().equals("admin")) {
	                	return "Admin";
	                }
	                if(curUser.getType().equals("buyer")) {
	                	return "HomePage";
	                }
	            }
	        }
	        return "Login";
	    }
	    
	    
	    
	    
	    @GetMapping("/HomePage")
	    public String showHome(){
	 
	        return "HomePage";
	    }
	    
	    
	    
	    @GetMapping("/showAllUsers")
	    public String showAllUsers(Model model)
	    {
	        Iterable<user> usersIterable =repo.findAll();
	        ArrayList<user> usersList=new ArrayList<user>();
	        for(user user: usersIterable){
	            usersList.add(user);
	        }
	        model.addAttribute("users",usersList);
	        return "showAllUsers";
	    }
	    
	
	
}
