package springbootdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SWEPROJECT.Entities.Payment;
import com.SWEPROJECT.Entities.Product;
import com.SWEPROJECT.Repositories.*;

@Service
public class ProductService {

	@Autowired
	private ProductRepository ProductRepo;
	
	public int TotalPrice(int price,Integer quantity,String type) 
	{
		int TotalPrice = price * quantity;
		int TotalDisc = 0;
		if(type.equals("storeOwner")) {
			float per = (float) (15.0/100.0);
			TotalDisc += TotalPrice*per;
		}
		if(quantity >= 2) {
			float per = (float) (10.0/100.0);
			TotalDisc += TotalPrice*per;
		}
		return TotalPrice-TotalDisc;
	}
	
	public boolean AddProduct(Product product) 
	{
		if(!product.getName().isEmpty()&&
				!product.getCategory().isEmpty()&&
				product.getPrice()!=null) 
		{
			ProductRepo.save(product);
			return true;
		}
		return false;
	}
	
	public boolean InsertMethods(Product product,Payment pay) {
	    Iterable<Product> products =ProductRepo.findAll();
    	
        for(Product p: products)
        {
        	if(pay.getType().equals("DeleteAll")) 
        	{
        		ProductRepo.deleteAll();
        		return true;
        	}
        	if(pay.getType().equals("Delete")
        	 &&pay.getAmount().equals(p.getAmout())
        	 &&pay.getName().equals(p.getName()))
        	{
        		p.setDeleted(1);
        		ProductRepo.save(p);
        		return true;
        	}
        	if(pay.getType().equals("Edit")
        	 &&pay.getName().equals(p.getName())) 
        	{
        		p.setAmout(pay.getAmount());
        		ProductRepo.save(p);
        		return true;
        	}
        	if(pay.getType().equals("Undo")) 
        	{
        		p.setDeleted(0);
        		ProductRepo.save(p);
        		return true;
        	}
    		return false;
        }
		return false;
	}
	
	
}
