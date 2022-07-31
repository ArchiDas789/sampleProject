package selenium.amazon;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SearchItemPageTest extends BaseClass{
	WebDriver driver;
	SearchItemPage searchItemPage;
	ShoppingCartPage shoppingCartPage;
	@BeforeClass
	@Parameters({"browser","url"})
	public void setUp(String browser,String url)
	{
		this.driver=initBrowser(browser,url);
		searchItemPage=new SearchItemPage(driver);
		shoppingCartPage=new ShoppingCartPage(driver);
	}
	@Test(priority=0)
	public void searchItem()
	{
		assertTrue(searchItemPage.inputSearchItem(),"Searched Item not found");	
		searchItemPage.addItemToCart();			
	}
	@Test(priority=1)
	public void verifyItemInCart()
	{
	try {
		assertTrue(shoppingCartPage.itemInCartTitle().contains("Shopping Cart"),"Item is not in Cart");
		//assertTrue(shoppingCartPage.itemInCartPrice().contains("68900"),"Price of item is not matching");
		driver.close();
	}
	catch(Exception e)
	{
		System.out.println("verifyItemInCart failed due to exception "+e.getMessage());
	}
	}
/*	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	*/
}
