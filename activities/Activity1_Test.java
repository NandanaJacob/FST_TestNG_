package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Activity 1
//In the @Test method,
//
//Use getTitle() to get and print the title of the page.
//Make an assertion using assertEquals() to make sure the title of the page is "Training Support".
//Use findElement() to find the "About Us" Button on the page and click it.
//Get and print the title of the new page.
//Assert the title of the new page.
public class Activity1_Test {
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
