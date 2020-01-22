package Nunna.SeleniumFour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com");
		driver.findElement(By.name("q")).sendKeys("Testing");;
		//driver.findElement(RelativeLocator.withTagName("input").toRightOf(By.name("q"))).click();//Relative Locator Right
		Thread.sleep(5000);
		driver.quit();
	}

}
