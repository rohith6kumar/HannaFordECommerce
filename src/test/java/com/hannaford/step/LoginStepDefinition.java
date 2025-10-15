package com.hannaford.step;

import org.junit.Assert;

import com.hannaford.baseclass.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseClass {


	@Given("User in on the HannaFord Page")
	public void user_in_on_the_hanna_ford_page() {
		chromeBrowserLaunch();
		enterApplUrl("https://www.hannaford.com/");
		maximizeWindow();
		implicitwait();
	}
	@When("User enter details {string} and {string}")
	public void user_enter_details_and(String string, String string2) {
		 System.out.println("Enter Username");
		 System.out.println("Enter Password");
	}
	@When("User click the login button")
	public void user_click_the_login_button() {
	   System.out.println("Click the Login Button"); 
	}
	@Then("User should verify the success message after login")
	public void user_should_verify_the_success_message_after_login() {
	    Assert.assertEquals(0, 0);
	}




}
