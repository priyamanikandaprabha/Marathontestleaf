package Marathon;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {

	public static void main(String[] args) throws IOException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("src")).sendKeys("Chennai");
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//td[text()='8']")).click();
		driver.findElement(By.id("search_btn")).click();
		String Bus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("The number of buses:" +Bus);
		driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[2]")).click();
		String vKTravelsAC = driver.findElement(By.xpath("(//div[@class='clearfix bus-item'])[2]")).getText();
		System.out.println("the second resulting bus:" +vKTravelsAC);
		driver.findElement(By.xpath("//div[contains(@class,'button view-seats')]")).click();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File ("./images/pictures/shot1.jpg");
		FileUtils.copyFile(source, dest);
		
		
		/*Testcase 2 (RedBus)
		01) Launch Firefox / Chrome
		02) Load https://www.redbus.in/
		03) Type "Chennai" in the FROM text box
		04) Type "Bangalore" in the TO text box
		05) Select tomorrow's date in the Date field
		06) Click Search Buses
		07) Print the number of buses shown as results (ex:104 Buses found)
		08) Choose SLEEPER in the left menu 
		09) Print the name of the second resulting bus 
		10) Click the VIEW SEATS of that bus
		11) Take screenshot and close browser*/

	}

}
