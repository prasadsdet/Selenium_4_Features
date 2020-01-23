package Nunna.SeleniumFour;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IstallAndUnInstall {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);			
		Path P =Paths.get("D:\\selenium_ide-3.16.1-fx.xpi");
		Thread.sleep(5000);
		String ExtensionID = ((FirefoxDriver)driver).installExtension(P);
		System.out.println(ExtensionID);
		Thread.sleep(5000);
		((FirefoxDriver)driver).uninstallExtension("{a6fd85ed-e919-4a43-a5af-8da18bda539f}");
		Thread.sleep(5000);
		driver.quit();
	}

}
