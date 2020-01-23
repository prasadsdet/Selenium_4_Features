package Nunna.SeleniumFour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingToParentFrame {

	public static void main(String[] args) {
		//Selenium 3 if you want to go child go to parent-->chile and when returning switch to default then-->Parent
		//Selenium 4: can able to switch to child to parent.
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);			
		driver.get("https://www.quackit.com/html/tags/html_iframe_tag.cfm");

		WebElement parentFram = driver.findElement(By.xpath("//iframe[@class='result'][@name='result4']"));
		//switching to Parent frame
		driver.switchTo().frame(parentFram);
		WebElement childFrame = driver.findElement(By.cssSelector("iframe[src$='tag_example.cfm']"));
		//switching to Child frame
		driver.switchTo().frame(childFrame);
		//switching back to Parent frame
		driver.switchTo().parentFrame();//New Commandselenium 4
		if(childFrame.isDisplayed())
		{
			System.out.println("You are insid the parent frame");
		}
		
		driver.close();
		
	}

}
