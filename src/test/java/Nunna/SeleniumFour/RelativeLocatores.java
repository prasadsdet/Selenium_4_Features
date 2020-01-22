package Nunna.SeleniumFour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatores {

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		Thread.sleep(2000);
		WebElement uname = driver.findElement(By.id("input-email"));
		uname.sendKeys("ravi.kiran@gmail.com");
		WebElement pwd = driver.findElement(By.id("input-password"));
		pwd.sendKeys("rkiran");
		driver.findElement(RelativeLocator.withTagName("input").below(By.id("input-password"))).click();
	
		driver.findElement(RelativeLocator.withTagName("input").toRightOf(By.name("q"))).click();
	}

}
