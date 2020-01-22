package Nunna.SeleniumFour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FullScreen {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);			
		driver.get("https://google.com/");
	}

}
