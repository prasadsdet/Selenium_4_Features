package Nunna.SeleniumFour;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.Rectangle;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getHeightAndWidthofElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);
		WebElement searchfld = driver.findElement(By.name("q"));
		
		Rectangle rect = searchfld.getRect();
		System.out.println(rect.getHeight());
		System.out.println(rect.getWidth());
		System.out.println(rect.getX());
		System.out.println(rect.getY());
		
		driver.close();
		driver.quit();
	}

}
