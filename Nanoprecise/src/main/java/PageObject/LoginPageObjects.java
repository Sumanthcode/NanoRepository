package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	@FindBy(xpath="//div[@class='jss447 jss450']")
	public WebElement username;
	
	@FindBy(xpath="//input[@class='jss471']")
	public WebElement usernameField;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement pwd;
	
	@FindBy(xpath="//button[@type='button']")
	public WebElement loginButton;
	
	@FindBy(xpath="//img[@class='signup-logo___29mmB']")
	public WebElement img;
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
