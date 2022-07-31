package selenium.amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends BaseClass{

	public static void waitForVis(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void verify()
	{
		//SoftAssert verify=new SoftAssert();
		
		
	}
	public static void clickEnter(WebDriver driver)
	{
		Actions builder=new Actions(driver);
		
	}
	}
