package com.odoo.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;


public class Utils extends com.odoo.testbase.TestBase {

	public static void captureScreenshot(String filename)
	{
		try 
		{
			String path = "D:\\Workspace\\16Decworkspace\\APAutomation09Sept\\screenshots\\";		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File(path + filename +".png");	
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
