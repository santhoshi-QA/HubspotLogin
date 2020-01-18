package com.qa.Guru99Bank.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.Guru99Bank.Base.BasePage;

/**
 * 
 * @author Naga
 *
 */

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver  driver) {
		this.driver=driver;
	}
	
	By UserId=By.id("username");
	By Password=By.id("password");
	By login=By.id("loginBtn");
	
	
	public String getLoginPageTitle()
	{
		return  driver.getTitle();
	}
	
	public void doLogin(String user, String Pwd ) {
		driver.findElement(UserId).sendKeys(user);
		driver.findElement(Password).sendKeys(Pwd);
		driver.findElement(login).sendKeys(Keys.ENTER);
	}
}
	
	
	