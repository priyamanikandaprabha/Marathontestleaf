package Marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) {
		
		//1) Open https://www.myntra.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		//2) Mouse hover on MeN 
		Actions actions = new Actions(driver);
	    WebElement men = driver.findElement(By.xpath("//div[1]//a[@class='desktop-main']"));
        actions.moveToElement(men);
        // 3) Click Jackets
		WebElement jackets = driver.findElement(By.xpath("//a[@href='/men-jackets']"));
		actions.moveToElement(jackets);
		actions.click().build().perform();
		//4) Find the total count of item 
		
		/*Myntra
		
		
		 
		
		5) Validate the sum of categories count matches
		6) Check jackets
		7) Click + More option under BRAND
		8) Type Duke and click checkbox
		9) Close the pop-up x
		10) Confirm all the Coats are of brand Duke
		    Hint : use List 
		11) Sort by Better Discount
		12) Find the price of first displayed item
		Click on the first product
		13) Take a screen shot
		14) Click on WishList Now
		15) Close Browser*/


	}

}
