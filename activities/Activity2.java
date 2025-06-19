package activities;

//Add 4 @Test methods.
//In the first @Test method, use getTitle() to get and assert the title of the page.
//In the second @Test method, use findElement() to look for the black button. Make an incorrect assertion. (This test case is meant to throw an error)
//For the third @Test method, skip it by setting it's enabled parameter to false.
//The third method will be skipped, but will not be shown as skipped.
//For the fourth @Test method, skip it by throwing a SkipException inside the method.
//The fourth method will be skipped and it will be shown as skipped.
//Observe the result in the console.

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
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
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test(priority = 1)
	public void verifyTitleTest() {
		assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}
	
	@Test(priority = 2)
	public void blackElementTest() {
		//find button with text black
		String buttonText = driver.findElement(By.cssSelector("button.bg-slate-200")).getText();
		//Assertions
		assertEquals(buttonText, "Black");
	}
	
	@Test(priority = 3, enabled = false)
	public void Test_3() {
		System.out.println("To be ignored");
	}
	
	@Test(priority = 4)
	public void Test_4() throws SkipException{
		String condition = "Skip Test";
		if(condition.equals("Skip Test")) {
			throw new SkipException("This test must be skipped.");
		}else {
			System.out.println("Test is executed");
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit(); //browser will close even if there were errors
	}
}
