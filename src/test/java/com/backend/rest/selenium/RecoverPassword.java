package com.backend.rest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecoverPassword {
public static WebDriver driver;
	
	public void Tsleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Given("User is on recover page")
	public void user_is_on_recover_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kouam\\OneDrive\\Desktop\\WebDrivers\\Newchrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/recover");
		System.out.println(":::: User is on Recover page");
	}

	@When("User enters email")
	public void user_enters_email() {
		WebElement uname = driver.findElement(By.id("exampleInputEmail1"));
		Tsleep();
		uname.sendKeys("user1@gmail.com");
		Tsleep();
		WebElement subBtn = driver.findElement(By.id("submit"));
		Tsleep();
		subBtn.click();
	}

	@Then("The password is displayed")
	public void the_password_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
