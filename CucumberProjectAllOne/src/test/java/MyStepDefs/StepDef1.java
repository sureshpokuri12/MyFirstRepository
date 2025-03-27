package MyStepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFactoryClasses.LoginPageGuru99;
import PageFactoryClasses.NewCustomer;
import Utilities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef1 extends BaseClass {

	WebDriver driver = BaseClass.intialization_Driver(); // Correct: Call static method with class name
	LoginPageGuru99 obj1 = new LoginPageGuru99(driver);
	NewCustomer newCustomer = new NewCustomer(driver);

	@Given("User open the URL in the browser")
	public void user_open_the_url_in_the_browser() {
		System.out.println("Application launched");
		// takeScreenshot();
		AddimplicityWait();
		maximizewindow();
		takeScreenshot("C:\\Users\\pokur\\Grow Skill IT  Nov 2024 WS 1\\CucumberProjectAllOne\\ScreenshotsFolder\\pic1.png");
		getTitle();

	}

	@Given("User enters the username in the username field as {string}")
	public void user_enters_the_username_in_the_username_field_as(String username) {
		obj1.enterusername(username);

	}

	@Given("user enters the password in the password field as {string}")
	public void user_enters_the_password_in_the_password_field_as(String password) {
		obj1.enterpassword(password);
	}

	@When("user clicks the login button in the appliaction")
	public void user_clicks_the_login_button_in_the_appliaction() {
		obj1.clickloginbutton();
	}

	@Then("user will navigated to Guru99 demo application homepage")
	public void user_will_navigated_to_guru99_demo_application_homepage() {
		System.out.println("home Page");
		takeScreenshot("C:\\Users\\pokur\\Grow Skill IT  Nov 2024 WS 1\\CucumberProjectAllOne\\ScreenshotsFolder\\pic2.png");
		getTitle();
		

	}

	@Then("User clicks on New Customer creation link in the demo guru99 app")
	public void user_clicks_on_new_customer_creation_link_in_the_demo_guru99_app() {
		// newCustomer.clickNewCustomerLink();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newCustomerLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='New Customer']")));
		newCustomerLink.click();
	}

	@Then("User enters Customer name {string}")
	public void user_enters_customer_name(String customername) {
		newCustomer.enterCustomerName(customername);
	}

	@Then("User selects the gender")
	public void user_selects_the_gender() {
		newCustomer.selectGender();
	}

	@Then("User enters Date of Birth {string}")
	public void user_enters_date_of_birth(String dob) {
		newCustomer.enterDob(dob);
	}

	@Then("User enters Address {string}")
	public void user_enters_address(String address) {
		newCustomer.enterAddress(address);
	}

	@Then("User enters city {string}")
	public void user_enters_city(String city) {
		newCustomer.enterCity(city);
	}

	@Then("User enters state {string}")
	public void user_enters_state(String state) {
		newCustomer.enterState(state);
	}

	@Then("User enters pin {string}")
	public void user_enters_pin(String pin) {
		newCustomer.enterPin(pin);
	}

	@Then("User enters Mobile Number {string}")
	public void user_enters_mobile_number(String mobilenumber) {
		newCustomer.enterMobileNumber(mobilenumber);
	}

//	@Then("User enters Email {string}")
//	public void user_enters_email(String email) {
//		newCustomer.enterEmail(email);
//	}

	@Then("User enters Email {string}")
	public void user_enters_email(String email) {
	    newCustomer.enterDynamicEmail();  // ✅ Dynamic Email Logic
	}
	
	@Then("User enters Password {string}")
	public void user_enters_password(String password) {
		newCustomer.enterPassword(password);
	}

//	@Then("user completes the execution")
//	public void user_completes_the_execution() {
//		System.out.println("✔ New Customer Created Successfully!");
//
//	}
	
	@Then("user complete the execution")
	public void user_complete_the_execution() throws InterruptedException {
		closeBrowser();
		System.out.println("✔ New Customer Created Successfully!");
	}

//	    public void user_complete_the_execution() throws InterruptedException {
//			closeBrowser();
//		}

	@Then("User submits the form")
	public void user_submits_the_form() {
		newCustomer.clickSubmit();
	}

	@Then("User captures the Customer ID")
	public void user_captures_the_customer_id() throws InterruptedException {
		Thread.sleep(3000);		  
		takeScreenshot("C:\\Users\\pokur\\Grow Skill IT  Nov 2024 WS 1\\CucumberProjectAllOne\\ScreenshotsFolder\\pic3.png");
		//newCustomer.captureCustomerID();
	}


}
