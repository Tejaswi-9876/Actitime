package com.Actitime.Generic.Librariy;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.LoginPage;

public class Baseclass {
	FileLibrary f= new FileLibrary();
	
	public static WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	@BeforeTest
	public void LaunchBrowser() throws IOException {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		String URL = f.readDatafromPropertyfile("url");
		driver.get(URL);
		Reporter.log("browser launcher",true);
	}
	@BeforeMethod
	public void LoginonActitime() throws IOException {
		String un=f.readDatafromPropertyfile("username");
		String pw=f.readDatafromPropertyfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("logged in successfully",true);
	}
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLgbtn().click();
		Reporter.log("logged out succefully",true);
	}
	@AfterTest
	public void Closebrowser() {
		driver.close();
		Reporter.log("Close the browser",true);
	}
	@AfterSuite
	public void disconnectedDB() {
		Reporter.log("disconnected to database",true);
	}
	

}
