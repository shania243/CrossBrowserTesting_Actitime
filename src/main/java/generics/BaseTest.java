package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements AutoConstant

{
	public static WebDriver driver;                       //made static for screenshot class
	
	@BeforeSuite
	public void start()
	{
		System.out.println("Start of the code.......!");
	}
	
	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String browser)
	{
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(Chrome_key,Chrome_value);
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		else
		{
			System.setProperty(gecko_key,gecko_value);
			driver=new FirefoxDriver();
		}
		
		System.out.println("Browser is launching.............!!!!");
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openApplication()
	{
		System.out.println("Application is launching.........!");
		driver.navigate().to(url);
	}
	
	@AfterSuite
	public void end()
	{
		System.out.println("End of the code.......!");
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.quit();
	}
	
}
