package com.uniovi.asw.cucumber.steps;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {
	static WebDriver driver;
	static String URL = "http://192.168.99.100:8082";
	protected static int timeout = 4;
	
	// Before every test, navigate to URL
	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get(URL);
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
