package examples;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
	//only declare cus u can use it for other browsers and in groups
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
		driver.get("https://training-support.net");
	}
	
	@Test(priority = 1)
	public void verifyPageTitle() {
		assertEquals(driver.getTitle(), "Training Support");
	}
	
	@Test(priority = 2)
	public void aboutUsTest() {
		//find and click the link
		driver.findElement(By.linkText("About Us")).click();
		//Assertions
		assertEquals(driver.getTitle(), "About Training Support");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit(); //browser will close even if there were errors
	}
}
