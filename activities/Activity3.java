package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://training-support.net/webelements/login-form/
//In the @AfterClass method, use close() to close the browser once the test is done.

public class Activity3 {
	//WebDriver declaration
	WebDriver driver;
	//WebDriverWait declaration
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		//Initialize driver
		driver = new FirefoxDriver();
		//Initialize wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open the page
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
	@Test(priority = 1)
	public void verifyPageTitle() {
		assertEquals(driver.getTitle(), "Selenium: Login Form");
	}
	
	//test for invalid credentials
	@Test(priority = 2)
	public void invalidCredentials() {
		driver.findElement(By.id("username")).sendKeys("invalid");
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		String message = driver.findElement(By.id("subheading")).getText();
		assertEquals(message, "Invalid credentials");
	}
	
		//test for valid credentials
		@Test(priority = 3)
		public void validCredentials() {
			WebElement username = driver.findElement(By.id("username"));
			WebElement password = driver.findElement(By.id("password"));
			username.clear();
			username.sendKeys("admin");
			password.clear();
			password.sendKeys("password");
			driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
			String message = driver.getTitle();
			assertEquals(message, "Selenium: Login Success!");
		}
		
	@AfterClass
	public void tearDown() {
		driver.quit(); //browser will close even if there were errors
	}
}
