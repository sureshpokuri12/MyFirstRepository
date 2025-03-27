package PageFactoryClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class LoginPageGuru99 extends BaseClass {

	WebDriver driver;

	public LoginPageGuru99(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement login;
	
	
	public void enterusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void enterpassword(String upwd)
	{
		password.sendKeys(upwd);
	}
	
	
	public void clickloginbutton()
	{
		login.click();
	}
	

}
