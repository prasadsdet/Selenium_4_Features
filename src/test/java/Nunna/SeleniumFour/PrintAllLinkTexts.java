package Nunna.SeleniumFour;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.support.locators.RelativeLocator;

public class PrintAllLinkTexts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(RelativeLocator.withTagName("a").below(By.linkText("compendiumdev")).above(By.linkText("theautomatedtester")));
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
			
		driver.quit();	
		

	}

}
