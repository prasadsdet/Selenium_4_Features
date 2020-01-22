package Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Setup 
{
	public static WebDriver driver;
	public final String PropertiesFile = "src//main//java//Resources//config.properties";
	Properties proper = new Properties();	
	public static long Page_Load_TimeOut =20;
	public static long Implicit_Wait = 10;
	
	public ExtentHtmlReporter htmlReporter; //responsible for the look and feel of the extent reports
	public ExtentReports extent; //Responsible for adding System related information
	public ExtentTest test; //Responsible for logging and adding screenshots to the reports

	@BeforeSuite(alwaysRun = true)
	public void BeforeSuite()
	{
		htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/SeleniumFour.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Selenium4 Report");
		htmlReporter.config().setReportName("Demo Testing Reports");

		extent=new ExtentReports();
		extent.setSystemInfo("Host", "Demo");
		extent.setSystemInfo("Host", "Prasad.Nunna");
		extent.setSystemInfo("Company", "Selenium 4");
		extent.setSystemInfo("Machine", "OPSI-LT-137");
		extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
		extent.attachReporter(htmlReporter);
	}
	

	
	@BeforeMethod(alwaysRun = true)
	public synchronized void beforeMethod() throws FileNotFoundException
	{
		FileInputStream fis= new FileInputStream(PropertiesFile);
		try {
			proper.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		initialization();
		LoginSetup();
	}
	
	
	@AfterMethod(alwaysRun = true)
	public synchronized void AfterMethod(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
	    {
	        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	        test.fail(result.getThrowable());
	    }
	    else if(result.getStatus() == ITestResult.SUCCESS)
	    {
	        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	    }
	    else
	    {
	        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	        test.skip(result.getThrowable());
	    }
		driver.close();
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void tearDown(){
	    extent.flush();
	   }
	public void initialization()
	{		
		String browserName = proper.getProperty("browser");

		if(browserName.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", proper.getProperty("Chromedriverpath"));	
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\TestData\\ImportAndExport");

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options); 
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", proper.getProperty("Firefoxdriverpath"));	
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().fullscreen();//Selenium Four
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Implicit_Wait, TimeUnit.SECONDS);
		driver.get(proper.getProperty("url"));

	} 
	public void LoginSetup()
	{
		try
		{
			driver.findElement(By.id("userNameBox")).click();
			driver.findElement(By.id("userNameBox")).sendKeys("super");
			driver.findElement(By.id("Password")).click();
			driver.findElement(By.id("Password")).sendKeys("password");
			driver.findElement(By.id("loginBtn")).click();
			driver.manage().timeouts().implicitlyWait(Implicit_Wait, TimeUnit.SECONDS);
			Select Company = new Select(driver.findElement(By.id("Company")));
			Company.selectByIndex(1);
			Select Domain = new Select(driver.findElement(By.id("Domain")));
			Domain.selectByIndex(0);
			driver.findElement(By.id("domainSelectionBtn")).click();
			driver.manage().timeouts().pageLoadTimeout(Page_Load_TimeOut, TimeUnit.SECONDS);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
