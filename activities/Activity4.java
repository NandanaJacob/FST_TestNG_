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

//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://training-support.net/webelements/target-practice
//In the @AfterClass method, use close() to close the browser once the test is done.

//Activity 5
//Write tests for:
//
//Checking the page title
//Header Tests:
//Find the third header and assert the text in the h3 tag.
//Find and assert the colour of the fifth header tag element.
//Button Tests:
//Find the button with the class emerald and assert it text.
//Find and assert the colour of the first button in the third row.
//Group the Header tests under a group, HeaderTests.
//Group the Button tests under a group, ButtonTests.

public class Activity4 {
	//WebDriver declaration
			WebDriver driver;
			//WebDriverWait declaration
			WebDriverWait wait;
			
			@BeforeClass(alwaysRun = true)
			public void setUp() {
				//Initialize driver
				driver = new FirefoxDriver();
				//Initialize wait
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				//Open the page
				driver.get("https://training-support.net/webelements/target-practice");
			}
			
			@Test(priority = 1)
			public void verifyPageTitle() {
				assertEquals(driver.getTitle(), "Selenium: Target Practice");
			}
			
			//Find the third header and assert the text in the h3 tag.
			@Test(priority = 2, groups = {"HeaderTest"})
			public void header3() {
				String message = driver.findElement(By.xpath("//h3[contains(@class,'text-orange-600')]")).getText();
				assertEquals(message, "Heading #3");
			}
			
			//Find and assert the colour of the fifth header tag element.
			@Test(priority = 3, groups = {"HeaderTest"})
			public void header5() {
				String colour = driver.findElement(By.xpath("//h5[text()='Heading #5']")).getCssValue("color");
				assertEquals(colour, "rgb(147, 51, 234)");
			}
			
			//Find the button with the class emerald and assert it text.
			@Test(priority = 4, groups = {"ButtonTest"})
			public void emeraldButton() {
				String message = driver.findElement(By.cssSelector("button.bg-emerald-200")).getText();
				assertEquals(message,"Emerald");
			}
			
			//Find and assert the colour of the first button in the third row.
			@Test(priority = 5, groups = {"ButtonTest"})
			public void purpleButton() {
				String col = driver.findElement(By.className("bg-purple-200")).getCssValue("color");
				assertEquals(col, "rgb(88, 28, 135)");
			}
			@AfterClass(alwaysRun = true)
			public void tearDown() {
				driver.quit(); //browser will close even if there were errors
			}
}
