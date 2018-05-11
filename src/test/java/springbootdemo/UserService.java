package springbootdemo;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SWEPROJECT.Entities.Payment;
import com.SWEPROJECT.Entities.Product;
import com.SWEPROJECT.Entities.user;
import com.SWEPROJECT.Repositories.*;
import com.SWEPROJECT.Entities.Product;

@Service
public class UserService {

	@Autowired
	private UsreRepositories UserRepo;
	private static user curUser = null;

	public boolean Signin(user u) {
	  
		  ArrayList<user> users = (ArrayList<user>) UserRepo.findAll();
	        for (user TheUser: users)
	        {
	            if( (TheUser.getPassword().equals(u.getPassword())
                 &&TheUser.getUsrename().equals(u.getUsrename())))
	            {
	                curUser = TheUser;
	                
	                if(curUser.getType().equals("storeowner")) {
	                	return true;
	                	}
	                if(curUser.getType().equals("collaborator")) {
	                	return true;
	                }
	                if(curUser.getType().equals("admin")) {
	                	return true;
	                }
	                if(curUser.getType().equals("buyer")) {
	                	return true;
	                }
	            }
	        }

		return false;
	}
	
	
	public boolean SignUp(user u) {
		if(u.getType().equals("buyer"))
    	{
			UserRepo.save(u);
    		return true;
    	}
    	if(u.getType().equals("storeowner")) {
    		UserRepo.save(u);
    		return true;

    	}
    	if(u.getType().equals("collaborator"))
    	{
    		UserRepo.save(u);
    		return true;

    	}
    	if(u.getType().equals("admin"))
    	{
    		UserRepo.save(u);
    		return true;
    	}
		return false;
	}
	
	

	
	
}
