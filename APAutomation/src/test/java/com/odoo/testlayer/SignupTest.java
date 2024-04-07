package com.odoo.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.pagelayer.Homepage;
import com.odoo.pagelayer.Loginpage;
import com.odoo.pagelayer.SignupPage;
import com.odoo.testbase.TestBase;
import com.odoo.utility.CommonUISteps;



public class SignupTest extends TestBase {
	
	@Test
	public void verifySignupWithValidDetails()
	{
		String expected_result = "My Portal | testing";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		SignupPage signuppage_obj = new SignupPage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDonthaveAccountLink();
		
		signuppage_obj.enterEmailAddress("test12@gmail.com");
		signuppage_obj.enterUsername("test3");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test@1234");
		signuppage_obj.clickOnSignupButton();
		
		String actual_result = driver.getTitle();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void verifySignupWithAlreadyRegisterEmail()
	{
		String expected_result = "Another user is already registered using this email address.";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		SignupPage signuppage_obj = new SignupPage(driver);
		CommonUISteps common_obj = new CommonUISteps(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDonthaveAccountLink();
		
		signuppage_obj.enterEmailAddress("test12@gmail.com");
		signuppage_obj.enterUsername("test3");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test@1234");
		signuppage_obj.clickOnSignupButton();
		
		String actual_result = common_obj.getErrorMessageFromPage();
		Assert.assertEquals(actual_result, expected_result);
	}

}
