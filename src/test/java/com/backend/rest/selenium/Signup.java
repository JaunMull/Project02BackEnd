package com.backend.rest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup {
public static WebDriver driver;
	
	public void Tsleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Given("User is on sign up page")
	public void user_is_on_sign_up_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kouam\\OneDrive\\Desktop\\WebDrivers\\Newchrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/signup");
		// Write code here that turns the phrase above into concrete actions
		System.out.println(":::: User is on Sign up page");
	}
	@When("User enters name  and phone")
	public void user_enters_name_and_phone() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement uname = driver.findElement(By.id("name"));
		Tsleep();
		uname.sendKeys("Test User 1");
		Tsleep();
		WebElement phone = driver.findElement(By.id("phone"));
		Tsleep();
		phone.sendKeys("987");
		System.out.println(":::: User is enters name and phone number");
		//throw new io.cucumber.java.PendingException();
	}

	@When("User enters  email and password")
	public void user_enters_email_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement email = driver.findElement(By.id("email"));
		Tsleep();
		email.sendKeys("tuser@gmail.com");
		Tsleep();
		WebElement password = driver.findElement(By.id("password"));
		Tsleep();
		password.sendKeys("ts1");
		System.out.println(":::: User is enters email and password");
	}

	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() {
		Tsleep();
		WebElement subBtn = driver.findElement(By.id("submit"));
		Tsleep();
		subBtn.click();
		Tsleep();
	}

	@Then("The login page is displayed")
	public void the_login_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login page is displayed ...");
	}

}
