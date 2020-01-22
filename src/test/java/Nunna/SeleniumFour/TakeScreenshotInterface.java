package Nunna.SeleniumFour;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotInterface {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);
		WebElement searchfld = driver.findElement(By.name("q"));
		searchfld.sendKeys("Nunna");
		TakeelementScreenshot(searchfld, "Nunna");
		
		
		WebElement brandname = driver.findElement(By.id("multiselect1"));
		TakeelementScreenshot(brandname, "CarBrands");
		driver.close();
		driver.quit();
	}
	
	public static void TakeelementScreenshot(WebElement element, String fileName)
	{
		TakesScreenshot scrtakescshot =((TakesScreenshot)element);
		File SrcFile = scrtakescshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("./target/ScreenShots/"+fileName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
