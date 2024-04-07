package com.odoo.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonUISteps {

	private WebDriver driver;
	public CommonUISteps(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//-----------------------------------------------\\
	
	private By error_message_text = By.xpath("//p[@class='alert alert-danger']");
	
	public String getErrorMessageFromPage()
	{
		String message = driver.findElement(error_message_text).getText();
		return message;
	}
}
