package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	@FindBy(xpath="(//tbody)[2]/tr")
	public List<WebElement> equipments;
	
	@FindBy(xpath="//button[@class='jss932 jss1088 jss1099 jss1100 jss1102 jss1103']")
	public WebElement dashboardManual;
	
	public MainPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
