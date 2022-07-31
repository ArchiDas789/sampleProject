package selenium.amazon;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchItemPage extends BaseClass {
	
	WebDriver driver;
    @FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
    WebElement inputSearchItem;
    
    @FindBy(how = How.XPATH, using = "//span[text()='RESULTS']")
    WebElement eleResult;
    
    @FindAll({@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")})
    List<WebElement> listOfSearchResult;

    @FindBy(how = How.XPATH, using = "//span[@id='productTitle']")
    WebElement eleProductTitle;
    
    @FindBy(how = How.XPATH, using = "//input[@id='add-to-cart-button']")
    WebElement btnAddItemToCart;
    
    @FindBy(how = How.XPATH, using = "//span[@id='attach-sidesheet-view-cart-button']/span/input")
    WebElement btnGoToCart;

    String searchItemPageHandle;
    Set<String> childWinHandles;
    SearchItemPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	searchItemPageHandle=driver.getWindowHandle();
    }
    public boolean inputSearchItem()
    {
    	boolean flag=false;
    	inputSearchItem.sendKeys("Apple iPhone 13 (128GB)");
    	inputSearchItem.sendKeys(Keys.ENTER);
    	Utility.waitForVis(eleResult);
    	for(WebElement e:listOfSearchResult)
    	{
    		if(e.getText().contains("Apple iPhone 13 (128GB) - Starlight"))
    		{
    			e.click();
    			flag=true;
    		}
       	}
    	return flag;
    }
    
    public void addItemToCart()
    {try {
    	childWinHandles=driver.getWindowHandles();
    	for(String s:childWinHandles)
    	{
    		if(!s.equals(searchItemPageHandle) )
    		{
    			driver.switchTo().window(s);
    		}
    	} 
    	Utility.waitForVis(eleProductTitle);
    	btnAddItemToCart.click();
    	Utility.waitForVis(btnGoToCart);
    	btnGoToCart.click();
    	Thread.sleep(2000);
    	}
    catch(Exception e) {
    	System.out.println("Add addItemToCart failed due to exception "+e.getMessage());}
    }
}
