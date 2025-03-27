package PageFactoryClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class NewCustomer extends BaseClass {
	
	WebDriver driver;

  
    public NewCustomer(WebDriver driver) {
        this.driver = driver; // Use driver from BaseClass
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='New Customer']")
    WebElement newCustomerLink;

    @FindBy(name = "name")
    WebElement customerName;

    @FindBy(name = "rad1")
    WebElement gender;

    @FindBy(name = "dob")
    WebElement dob;

    @FindBy(name = "addr")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "state")
    WebElement state;

    @FindBy(name = "pinno")
    WebElement pin;

    @FindBy(name = "telephoneno")
    WebElement mobileNumber;

    @FindBy(name = "emailid")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "sub")
    WebElement submitButton;
    
    @FindBy(xpath = "//td[text()='Customer ID']/following-sibling::td")
    WebElement customerIDElement;

    public void clickNewCustomerLink() {
        newCustomerLink.click();
    }

    public void enterCustomerName(String name) {
        customerName.sendKeys(name);
    }

    public void selectGender() {
        gender.click();
    }

    public void enterDob(String dobValue) {
        dob.sendKeys(dobValue);
    }

    public void enterAddress(String addr) {
        address.sendKeys(addr);
    }

    public void enterCity(String cityValue) {
        city.sendKeys(cityValue);
    }

    public void enterState(String stateValue) {
        state.sendKeys(stateValue);
    }

    public void enterPin(String pinValue) {
        pin.sendKeys(pinValue);
    }

    public void enterMobileNumber(String mobile) {
        mobileNumber.sendKeys(mobile);
    }

    public void enterEmail(String emailValue) {
        email.sendKeys(emailValue);
    }
    

    //Dynamic Email Generation
    public void enterDynamicEmail() {
        String uniqueEmail = "user" + UUID.randomUUID().toString().substring(0, 5) + "@gmail.com";
        email.sendKeys(uniqueEmail);
        System.out.println("Generated Email: " + uniqueEmail);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickSubmit() {
        submitButton.click();
        System.out.println("Form Submitted Successfully!");
    }
    
// // New Method to Capture Customer ID
//    public void captureCustomerID() {
//        String customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
//
//        try (FileOutputStream output = new FileOutputStream("src/test/resources/Global.properties")) {
//            Properties prop = new Properties();
//            prop.setProperty("CustomerID", customerID);
//            prop.store(output, "Updated Customer ID");
//            System.out.println("Customer ID saved successfully: " + customerID);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Failed to save Customer ID.");
//        }
//    }
    
    public void captureCustomerID() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for Customer ID element to appear
        WebElement customerIDElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//td[text()='Customer ID']/following-sibling::td")));
        
        // Capture the Customer ID
        String customerID = customerIDElement.getText().trim();

        // Load existing properties
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/java/Constants/Global.properties")) {
            prop.load(input);  // Load existing details like browser, URL, etc.
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" Failed to load Global.properties file.");
        }

        // Update CustomerID without overwriting other properties
        prop.setProperty("CustomerID", customerID);

        // Save updated properties (with a comment for tracking)
        try (FileOutputStream output = new FileOutputStream("src/main/java/Constants/Global.properties")) {
            prop.store(output, "#Updated Customer ID\n# " + new java.util.Date());
            System.out.println("Customer ID updated successfully: " + customerID);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" Failed to save Customer ID.");
        }
    }

}
