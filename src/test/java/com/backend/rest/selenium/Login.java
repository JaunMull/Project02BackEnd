package com.backend.rest.selenium;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {
	public static WebDriver driver;
	
	public void Tsleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kouam\\OneDrive\\Desktop\\WebDrivers\\Newchrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/login");
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println(":::: User is on Login page");
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement uname = driver.findElement(By.id("exampleInputEmail1"));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Tsleep();
		uname.sendKeys("user1@gmail.com");
		Tsleep();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000000));
		WebElement password = driver.findElement(By.id("exampleInputPassword1"));
		Tsleep();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000000));
		password.sendKeys("newone");
		Tsleep();
		System.out.println("User enters Username and Password");
		//throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000000));
		Tsleep();
		WebElement loginBtn = driver.findElement(By.id("login"));
		Tsleep();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000000));
		loginBtn.click();
		Tsleep();
		System.out.println("::: Login");
		
		//throw new io.cucumber.java.PendingException();
		
	}

	@Then("The home page is displayed")
	public void the_home_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Login Successful ...");
	}
}
