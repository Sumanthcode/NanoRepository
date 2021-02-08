package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EquipmentMainPage {

	@FindBy(xpath="//div[@class='jss10544 portal-sidenav-classic___bpVyT']")
	public WebElement menu;
	
	@FindBy(xpath="//span[text()='Health Summary']")
	public WebElement healthSummary;
	
	@FindBy(xpath="//span[text()='Temperature']")
	public WebElement temperature;
	
	@FindBy(xpath="(//div[@class=' css-tlfecz-indicatorContainer'])[2]")
	public WebElement componentField;
	public EquipmentMainPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
