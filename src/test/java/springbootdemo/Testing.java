package springbootdemo;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.SWEPROJECT.Entities.Brand;
import com.SWEPROJECT.Entities.Payment;
import com.SWEPROJECT.Entities.Product;
import com.SWEPROJECT.Entities.Store;
import com.SWEPROJECT.Entities.user;
import com.SWEPROJECT.Repositories.*;

public class Testing {

	@Mock
    ProductRepository ProductRepo;
	@Mock
	BrandRepository BrandRepo;
	@Mock
	StoreRepository StoreRepo;	
	@Mock
	UsreRepositories UserRepo;
	
///////////////////////////////////////////////////////////////////////////
	@InjectMocks
	private ProductService ProductService;
	@InjectMocks
	private BrandService BrandService;
	@InjectMocks
	private StoreService StoreService;
	@InjectMocks
	private UserService UserService;

//////////////////////////////////////////////////////////////////////////
	
	///initial all objects for product controller///
	Product product1 = new Product();
	Product product2 = new Product();
	Product product3 = new Product();
	Payment pay1=new Payment();
	Payment pay2=new Payment();
	Payment pay3=new Payment();
	Payment pay4=new Payment();
/////////////////////////////////////////////////////////////////////////
	
	///initial all objects for Brand controller///
	Brand brand1=new Brand();
	Brand brand2=new Brand();
	Brand brand3=new Brand();
	Brand brand4=new Brand();
/////////////////////////////////////////////////////////////////////////
	///initial all objects for Store controller///
	Store store1=new Store();	
	Store store2=new Store();
	Store store3=new Store();
	Store store4=new Store();
/////////////////////////////////////////////////////////////////////////
	///initial all objects for Store controller///
	user user1=new user();
	user user2=new user();
	user user3=new user();
	user user4=new user();	
/////////////////////////////////////////////////////////////////////////
	@Before
    public void Init() 
	{
		ProductService mock1 = Mockito.mock(ProductService.class);
		BrandService mock2 = Mockito.mock(BrandService.class);
		StoreService mock3 = Mockito.mock(StoreService.class);
		UserService mock4 = Mockito.mock(UserService.class);

        Mockito.when(mock1.TotalPrice( 200, 5,"storeowner"))
        .thenReturn(200);
        Mockito.when(mock1.TotalPrice( 250, 2, "storeowner"))
        .thenReturn(350);
        Mockito.when(mock1.TotalPrice( 150, 1, "buyer"))
        .thenReturn(150);
///////////////////////////////////////////////////////////////// 
        
        product1.setName("mm");
        product1.setCategory("mm");
        product1.setPrice(90);
        product1.setAmout(78);
        product1.setLocation("mm");
        
        
        product2.setName("product11");
        product2.setCategory("category2");
        product2.setPrice(null);
        product2.setAmout(120);
        product2.setLocation("");
        

        product3.setName("product2");
        product3.setCategory("");
        product3.setPrice(500);
        product3.setAmout(419);
        product3.setLocation("Giza");
       
        
        pay1.setType("DeleteAll");
        pay2.setType("Delete");
        pay3.setType("Edit");
        pay4.setType("Undo");
        
///////////////////////////////////////////////////////////////// 

        brand1.setBrandCategory("Football");
        brand1.setBrandName("Addias");
        
        brand2.setBrandCategory("");
        brand2.setBrandName("");
        
        brand3.setBrandCategory("BasketBall");
        brand3.setBrandName("Nike");
        
        brand4.setBrandCategory("");
        brand4.setBrandName("Converse");
        
///////////////////////////////////////////////////////////////// 
        store1.setLocation("Giza");
        store1.setName("Addidas");
        store1.setType("Football");
              
        store2.setLocation("HARAM");
        store2.setName("");
        store2.setType("BasketBall");
         
        store3.setLocation("");
        store3.setName("");
        store3.setType("");
        
        store4.setLocation("Ma'adi");
        store4.setName("");
        store4.setType("");
////////////////////////////////////////////////////////////////////////
        user1.setEmail("yasser@gmail.com");
        user1.setMobile("01125315122");
        user1.setPassword("421515125");
        user1.setUsrename("ceaser");
        user1.setType("admin");
        
        user2.setEmail("khaled@gmail.com");
        user2.setMobile("011234121");
        user2.setPassword("000000");
        user2.setUsrename("medo");
        user2.setType("buyer");
        
        user3.setEmail("omar@gmail.com");
        user3.setMobile("011202040");
        user3.setPassword("300303030");
        user3.setUsrename("moka");
        user3.setType("storeowner");
        
        user4.setEmail("mostafa@gmail.com");
        user4.setMobile("010101010");
        user4.setPassword("0120020");
        user4.setUsrename("tefa");
        user4.setType("collabarotor");
        
  //////////////////////////////////////////////////////////////////////
        Mockito.when(mock1.AddProduct(product1)).thenReturn(true);
        Mockito.when(mock1.AddProduct(product2)).thenReturn(false);
        Mockito.when(mock1.AddProduct(product3)).thenReturn(true);
        
        Mockito.when(mock1.InsertMethods(product1, pay1)).thenReturn(false);
        Mockito.when(mock1.InsertMethods(product2, pay2)).thenReturn(false);
        Mockito.when(mock1.InsertMethods(product3, pay3)).thenReturn(true);
        Mockito.when(mock1.InsertMethods(product2, pay4)).thenReturn(true);
	
        
        Mockito.when(mock2.AddBrand(brand1)).thenReturn(true);
        Mockito.when(mock2.AddBrand(brand2)).thenReturn(false);
        Mockito.when(mock2.AddBrand(brand3)).thenReturn(true);
        Mockito.when(mock2.AddBrand(brand4)).thenReturn(false);

        Mockito.when(mock3.AddStore(store1)).thenReturn(true);
        Mockito.when(mock3.AddStore(store2)).thenReturn(false);
        Mockito.when(mock3.AddStore(store3)).thenReturn(true);
        Mockito.when(mock3.AddStore(store4)).thenReturn(false);

        Mockito.when(mock4.Signin(user1)).thenReturn(false);
        Mockito.when(mock4.Signin(user2)).thenReturn(true);
        Mockito.when(mock4.Signin(user3)).thenReturn(false);
        Mockito.when(mock4.Signin(user4)).thenReturn(true);
        
        Mockito.when(mock4.SignUp(user1)).thenReturn(false);
        Mockito.when(mock4.SignUp(user2)).thenReturn(true);
        Mockito.when(mock4.SignUp(user3)).thenReturn(false);
        Mockito.when(mock4.SignUp(user4)).thenReturn(true);
       
	}
	
	
	///PRODUCT-CONTROLLER-TEST///
	@Test
	public void TotalPriceTest1() 
	{
		int input1 =200;
		int input2 = 5;
		String input3 = "storeowner";
    	float expectedOutput = (float)900;
        float actualOutput = ProductService.TotalPrice(input1,input2,input3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
	public void TotalPriceTest2() {
		int input1 = 250;
		int input2 = 2;
		String input3 = "storeowner";
    	float expectedOutput = (float)450;
        float actualOutput = ProductService.TotalPrice(input1,input2,input3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
	public void TotalPriceTest3() {
		int input1 = 150;
		int input2 = 1;
		String input3 = "buyer";
    	float expectedOutput = (float)150;
        float actualOutput = ProductService.TotalPrice(input1,input2,input3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
	public void AddProductTest1() {
    	boolean expectedOutput = true;
        boolean actualOutput = ProductService.AddProduct(product1);
        assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
	public void AddProductTest2() {
		boolean expectedOutput = false;
        boolean actualOutput = ProductService.AddProduct(product2);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
	public void AddProductTest3() {
		boolean expectedOutput = true;
        boolean actualOutput =ProductService.AddProduct(product3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}

	@Test
	public void MethodsTest1() {
		boolean expectedOutput = false;
        boolean actualOutput = 
        		ProductService.InsertMethods(product1, pay1);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}


	@Test
	public void MethodsTest2() {
		boolean expectedOutput = true;
        boolean actualOutput = 
        		ProductService.InsertMethods(product2, pay2);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}

	@Test
	public void MethodsTest3() {
		boolean expectedOutput = false;
        boolean actualOutput = 
        		ProductService.InsertMethods(product3, pay3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}

	@Test
	public void MethodsTest4() {
		boolean expectedOutput = true;
        boolean actualOutput = 
        		ProductService.InsertMethods(product3, pay4);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
////////////////////////////////////////////////////////////////////////
	
	///BRAND-CONTROLLER-TEST///
	
@Test
public void AddBrandTest1() {
		boolean expectedOutput = true;
        boolean actualOutput =BrandService.AddBrand(brand1);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}

@Test
public void AddBrandTest2() {
		boolean expectedOutput = false;
        boolean actualOutput =BrandService.AddBrand(brand2);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}

@Test
public void AddBrandTest3() {
		boolean expectedOutput = true;
        boolean actualOutput =BrandService.AddBrand(brand3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}

	@Test
public void AddBrandTest4() {
		boolean expectedOutput = false;
        boolean actualOutput =BrandService.AddBrand(brand4);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
///////////////////////////////////////////////////////////////////////////
	///Store-CONTROLLER-TEST///

	@Test
public void AddStoreTest1() {
		boolean expectedOutput = true;
        boolean actualOutput =StoreService.AddStore(store1);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
@Test
public void AddStoreTest2() {
		boolean expectedOutput = false;
        boolean actualOutput =StoreService.AddStore(store2);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	@Test
public void AddStoreTest3() {
		boolean expectedOutput = false;
        boolean actualOutput =StoreService.AddStore(store3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	@Test
public void AddStoreTest4() {
		boolean expectedOutput = true;
        boolean actualOutput =StoreService.AddStore(store4);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
///////////////////////////////////////////////////////////////////////////
	///USER-CONTROLLER-TEST///
	@Test
public void SignUp1() {
		boolean expectedOutput = true;
        boolean actualOutput =UserService.SignUp(user1);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	@Test
public void SignUp2() {
		boolean expectedOutput = true;
        boolean actualOutput =UserService.SignUp(user2);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	@Test
public void SignUp3() {
		boolean expectedOutput = true;
        boolean actualOutput =UserService.SignUp(user3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	@Test
public void SignUp4() {
		boolean expectedOutput = true;
        boolean actualOutput =UserService.SignUp(user4);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
public void Signin1() {
		boolean expectedOutput = true;
        boolean actualOutput =UserService.Signin(user1);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
public void Signin2() {
		boolean expectedOutput = true;
        boolean actualOutput =UserService.Signin(user2);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}	
	@Test
public void Signin3() {
		boolean expectedOutput = true;
        boolean actualOutput =UserService.Signin(user3);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}	
	@Test
public void Signin4() {
		boolean expectedOutput = true;
        boolean actualOutput =UserService.Signin(user4);
         assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	
	
}