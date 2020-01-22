package Nunna.SeleniumFour;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GerElementScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);
		WebElement searchfld = driver.findElement(By.name("q"));
		searchfld.sendKeys("Nunna");
		TakeElementScreenshot(searchfld, "filedSearch");
		driver.quit();

	}
	
	public static void TakeElementScreenshot(WebElement element,String fileName)
	{
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("D:\\Automation\\Selenium\\Java\\Projects\\SeleniumFour\\target\\ScreenShots\\"+fileName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
