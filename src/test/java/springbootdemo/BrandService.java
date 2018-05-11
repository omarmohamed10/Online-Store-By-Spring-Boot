package springbootdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SWEPROJECT.Entities.Brand;
import com.SWEPROJECT.Repositories.*;

@Service
public class BrandService {

	@Autowired
	private BrandRepository BrandRepo;
	
	public boolean AddBrand(Brand brand) 
	{
		if(!brand.getBrandName().isEmpty()&&
				!brand.getBrandCategory().isEmpty())
		{
			BrandRepo.save(brand);
			return true;
		}
		return false;
	}
	
}
