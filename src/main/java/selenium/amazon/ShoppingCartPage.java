package selenium.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseClass{

	WebDriver driver;
    @FindBy(how = How.XPATH, using = "//div[@id='sc-cart-column']//h1")
    WebElement eleShoppingCartTitle;
    
    @FindBy(how = How.XPATH, using = "//ul/li//span[@class='a-truncate-full a-offscreen']")
    WebElement eleAddedItemTitle;
    
    @FindBy(how = How.XPATH, using = "//span[@id='a-autoid-4-announce']")
    WebElement eleQuantity;
    
    @FindBy(how = How.XPATH, using = "//span[@class='currencyINR']")
    WebElement eleSubTotalPrice;
    
    ShoppingCartPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public String itemInCartTitle() 
    {
    	return eleShoppingCartTitle.getText();
    }
    public String itemInCartPrice() 
    {
    	return eleSubTotalPrice.getText();
    }
    
}
