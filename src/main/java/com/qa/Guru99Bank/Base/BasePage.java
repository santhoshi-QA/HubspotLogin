package com.qa.Guru99Bank.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author Naga
 *
 */

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver initilize_Driver(Properties qwery) throws InterruptedException {
		//String browser="chrome";
		
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if(browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else {
			System.out.println("Browser not defined"+browser);
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Thread.sleep(7000);
		return driver;
		
	}
	
	public Properties initilize_properties() {
		 prop=new Properties();
		try {
			FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\Guru99Bank\\config\\config.properties");
			prop.load(fi);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
		
		
	}

}
