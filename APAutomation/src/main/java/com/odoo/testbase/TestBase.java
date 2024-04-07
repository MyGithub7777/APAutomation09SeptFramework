package com.odoo.testbase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeTest
	public void start()
	{
		logger = Logger.getLogger("** AP Automation **");
		PropertyConfigurator.configure("logFile.properties");
		
		logger.info("Framework execution started ------------------- ");
	}
	
	@AfterTest
	public void stop()
	{
		logger.info("Framework execution stopped ------------------- ");
	}
	
	@BeforeMethod
	public void setUp() 
	{	
		String browsername = "chrome";
		
		if(browsername.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) 
		{ 
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please enter valid browser");
		}
		driver.get("https://ap-automation.odoo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("browser and url opened");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("browser close");
	}
}
