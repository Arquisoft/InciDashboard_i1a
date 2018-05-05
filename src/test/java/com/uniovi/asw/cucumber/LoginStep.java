package com.uniovi.asw.cucumber;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {
	static String PathFirefox = "C:\\Firefox46.win\\FirefoxPortable.exe";
	static WebDriver driver = getDriver(PathFirefox);
	static String URL = "http://192.168.99.100:8082";
	
	public static WebDriver getDriver(String PathFirefox) {
		// Firefox 46.0 without geckodriver for Selenium 2.x.
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	// Before every test, navigate to URL
	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}
	
	// After every test, delete browser's cookies
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}
	
	// Before first test
	@BeforeClass
	static public void begin() {
	}
	
	// After last test, close the browser
	@AfterClass
	static public void end() {
		driver.quit();
	}
	
	@Given("^an operator in homepage")
	public void goHomepage() {
		// In theory it should already be on the homepage
		driver.navigate().to(URL);
		driver.findElement(By.id("indexWelcomeText"));
	}
	
	@When("^clicks on log in button")
	public void goLogin() {
		driver.findElement(By.id("indexLoginButton")).click();
		driver.getCurrentUrl().equalsIgnoreCase(URL + "/login");
		driver.findElement(By.id("loginText"));
	}
	
	@And("^fills in correctly email and password") 
	public void fillLogin() {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Then("^operator is logged in")
	public void checkLogin() {
		if (driver.getCurrentUrl().equalsIgnoreCase(URL + "/dashboard")) {
			System.out.println("Cucumber login test passed correctly.");
		} else {
			System.out.println("Cucumber login test failed.");
		}
	}
}
