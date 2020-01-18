package com.qa.Guru99Bank.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Guru99Bank.Base.BasePage;
import com.qa.Guru99Bank.Pages.LoginPage;
import com.qa.Guru99Bank.Util.Constants;
/**
 * 
 * @author Naga
 *
 */
public class LoginTest {
	
	WebDriver driver;
	BasePage basepage;
	LoginPage loginpage;
	Properties test;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		basepage=new BasePage();
		test=basepage.initilize_properties();
		driver=basepage.initilize_Driver(test);
		loginpage=new LoginPage(driver);
		
		
	}
	
	@Test(priority=1, enabled=false)
	public void loginTest()
	{
		loginpage.doLogin(test.getProperty("username"), test.getProperty("password"));
		
	}
	
	@Test(invocationCount=5)
	public void getLoginPageTitleTest() 
	{
		String title=loginpage.getLoginPageTitle();
		System.out.println("Login Page Title:::"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Page is correct");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}

}
