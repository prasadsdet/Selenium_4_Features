import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;
import org.openqa.selenium.devtools.security.Security;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccessInSecureSite {

	public static void main(String[] args) 
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
		devtools.send(Security.enable());
		
		//ignore the certificate error
		devtools.send(Security.setIgnoreCertificateErrors(true));
		
		
		driver.get("https://expired.badssl.com/");
		
	}

}
