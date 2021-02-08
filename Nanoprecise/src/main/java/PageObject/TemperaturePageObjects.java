package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TemperaturePageObjects {
	
	@FindBy(xpath="//button[@role='tab']//h2")
	public WebElement temperatureTitle;
	
	@FindBy(xpath="//div[@class='user-select-none svg-container']")
	public WebElement plot;
	
	@FindBy(xpath="//a[@data-title='Download plot as a png']")
	public WebElement capture;
	
	@FindBy(xpath="//div[@class=' css-1hwfws3']/div[@class=' css-1y1uwy0-singleValue']")
	public WebElement tempUnitSelection;
	
	@FindBy(xpath="//i[@class='fa fa-bell']")
	public WebElement emailalram;
	
	@FindBy(xpath="//div[@id='event-dialog']")
	public WebElement alramTitle;
	
	@FindBy(xpath="//input[@type='number']")
	public WebElement thresholdField;
	
	@FindBy(xpath="//div[@labelid='demo-simple-select-helper-label']")
	public WebElement emailFrequency;
	
	@FindBy(xpath="//ul[@role='listbox']/li")
	public List<WebElement> listOfFrequency;
	
	@FindBy(xpath="//i[@class='fa fa-floppy-o']")
	public WebElement alramSaveButton;
	
	@FindBy(xpath="//a[@class='btn btn-primary raised']")
	public WebElement temperatureData;
	
	public TemperaturePageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
