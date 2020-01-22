package Nunna.SeleniumFour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;
import org.openqa.selenium.logging.LocalLogs;

import com.google.common.collect.Multiset.Entry;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromiumDevTools {

	//Selenium 3 : Chromedriver extending Remote Driver
	//Selenium 4 : Chrome Driver Extending Chromium Driver
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		//Steps to listen to chrome browser console
		
		DevTools devtools =((ChromeDriver)driver).getDevTools();
		//Creating chrome dev tools session
		devtools.createSession();
		
		//Enable the consle logs
		devtools.send(Log.enable());
		
		//lisen to devtools consiole logs
		
		devtools.addListener(Log.entryAdded(), entry -> System.out.println(entry.getStackTrace()));
		devtools.addListener(Log.entryAdded(), entry -> System.out.println(entry.getSource()));
		devtools.addListener(Log.entryAdded(), entry -> System.out.println(entry.getNetworkRequestId()));
		
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);

	}

}
