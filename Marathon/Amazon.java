package Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for boys");
		driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[2]")).click();
		
		String bagsForBoys = driver.findElement(By.xpath("//span[text()='bags for boys']")).getText();
		System.out.println("Print the total number of bags:" +bagsForBoys);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		driver.findElement(By.xpath("//li[@id='p_89/Skybags']/span[1]/a[1]/div[1]/label[1]/i[1]")).click();
		String brandbags = driver.findElement(By.xpath("//span[@class='rush-component']/following-sibling::div")).getText();
		System.out.println("Print the brand bags:" +brandbags);
		if(bagsForBoys!=brandbags) 
		{
			System.out.println("Results got reduced");
		}
		else
			System.out.println("Results is incorrect");
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.linkText("Newest Arrivals")).click();
		
		String unisexBlueShiny = driver.findElement(By.xpath("//h2[contains(@class,'a-size-mini a-spacing-none')]")).getText();
		String  Price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		
		System.out.println("Name of the bag:" +unisexBlueShiny);
		System.out.println("Price of the bag:" +Price);
		driver.findElement(By.xpath("//li[@id='p_n_specials_match/21618256031']/span[1]/a[1]/div[1]/label[1]/i[1]")).click();
		driver.findElement(By.xpath("(//div[@class='colorsprite aok-float-left'])[3]")).click();
		String outOf = driver.findElement(By.xpath("//div[@class='a-row a-size-small']")).getText();
		if(brandbags.equals(outOf)) 
		{
			System.out.println("Results is correct");
		}
		else
			System.out.println("Results is incorrect");
		
		
		
		/*Testcase 1 (Amazon)
		01) Launch Chome
		02) Load https://www.amazon.in/
		03) Type "Bags" in the Search box
		04) Choose the third displayed item in the result (bags for boys)
		05) Print the total number of results (like 20000)
		    1-48 of over 20,000 results for "bags for boys"
		06) Select the first 2 brands in the left menu
		    (like American Tourister, Generic) 1-48 of over 3,000 results for "bags for travelling"
		07) Confirm the results have got reduced (use step 05 for compare)
		08) Choose New Arrivals (Sort)
		09) Print the first resulting bag info (name, discounted price)
		10) Confirm the color of the 'Deal of the day' is in kind of Red
		11) Click on the First Deal of the day
		12) Confirm the price on previous and this page are same 
		13) Take screenshot and close*/

	}

}
