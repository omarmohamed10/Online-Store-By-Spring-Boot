package springbootdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SWEPROJECT.Entities.Store;
import com.SWEPROJECT.Repositories.*;
@Service
public class StoreService {
	

    @Autowired
	private StoreRepository StoreRepo;
    
    public boolean AddStore(Store store) 
	{
		if(!store.getLocation().isEmpty()&&
				!store.getName().isEmpty()&&
				!store.getType().isEmpty())
		{
			StoreRepo.save(store);
			return true;
		}
		return false;
	}

	
	
	
}
