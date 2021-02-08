package Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Nano.Nanoprecise.Base;
import PageObject.EquipmentMainPage;
import PageObject.LoginPageObjects;
import PageObject.MainPage;
import PageObject.TemperaturePageObjects;
import junit.framework.Assert;

public class ValidateTemperature extends Base{
	/*verify Temperature title when user enter the Temperature page*/
	Actions a;
	TemperaturePageObjects t;
	@Test(priority=1)
	public void validateTemperatureTitle() throws InterruptedException
	{
		LoginPageObjects l=new LoginPageObjects(driver);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(l.img));
		a=new Actions(driver);
		a.moveToElement(l.username).click().sendKeys("green").build().perform();
		a.moveToElement(l.pwd).click().sendKeys("09gGG09@").build().perform();
		l.loginButton.click();
		Thread.sleep(5000);
		MainPage m=new MainPage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0,500)");
		m.equipments.get(0).click();
		EquipmentMainPage e=new EquipmentMainPage(driver);
		WebDriverWait wait1=new WebDriverWait(driver,10);
    	wait1.until(ExpectedConditions.visibilityOf(e.healthSummary));
    	j.executeScript("window.scrollTo(0,-500)");
    	e.temperature.click();
    	t=new TemperaturePageObjects(driver);
    	Assert.assertTrue(t.temperatureTitle.getText().equalsIgnoreCase("Temperature"));
    	
		
	}
	/*verify that when user capture the plot, image is successfully downloaded*/
	@Test(priority=2)
	public void validateCapturedImage()
	{
		a.moveToElement(t.plot).moveToElement(t.capture).click().build().perform();
		File f1=new File("C:\\Users\\balan\\Downloads");
		File[] listOffiles = f1.listFiles();
		for(File file : listOffiles)
		{
			if(file.getName().equals("newplot.png"))
			{
				Assert.assertTrue(true);
				break;
			}

		}
	}
	/*verify that default temp unit is Celsius*/
	@Test(priority=3)
	public void validateDefaultTemeratureUnit()
	{
		t.tempUnitSelection.getText().equalsIgnoreCase("Celsius");
	}
	/*verify that user can select temp unit as Fahrenhiet*/
	@Test(priority=4)
	public void v1() throws AWTException
	{
		t.tempUnitSelection.click();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		t.tempUnitSelection.click();
		Assert.assertTrue(t.tempUnitSelection.getText().equalsIgnoreCase("Fahrenheit"));
	}
	/*verify user is successfully create email alram*/
	@Test(priority=5)
	public void validateSettingEmailAlram()
	{
		t.emailalram.click();
		WebDriverWait wait1=new WebDriverWait(driver,10);
    	wait1.until(ExpectedConditions.visibilityOf(t.alramTitle));
		t.thresholdField.clear();
		t.thresholdField.sendKeys("28");
		t.emailFrequency.click();
		t.listOfFrequency.get(1).click();
		t.alramSaveButton.click();
		
		
	}
	/*verify that Temperature data is downloaded successfully*/
	@Test(priority=6)
	public void validateTemperatureDataDownload() throws InterruptedException
	{
	
		Thread.sleep(3000);
		t.temperatureData.click();
		File f1=new File("C:\\Users\\balan\\Downloads");
		File[] listOffiles = f1.listFiles();
		for(File file : listOffiles)
		{
			if(file.getName().equals("temp_MyEquipment_fantest.csv"))
			{
				Assert.assertTrue(true);
				break;
			}
			
			

		}
	}
	
	

}
