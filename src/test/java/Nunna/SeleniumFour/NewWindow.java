package Nunna.SeleniumFour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);
		WebElement searchfld = driver.findElement(By.name("q"));
		searchfld.sendKeys("Google Home Page");
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		String firstwindow = driver.getWindowHandle();
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		WebElement TutorialSearch = driver.findElement(By.name("search"));
		TutorialSearch.sendKeys("IPHONE");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(firstwindow);
		Thread.sleep(2000);
		driver.close();

	}
}
