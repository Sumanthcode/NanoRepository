package Nano.Nanoprecise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	public WebDriver driver;
	public Properties prop;
	@BeforeClass
	public void initiateBrowser() throws IOException  {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Assignment\\Nanoprecise\\src\\main\\java\\Nano\\Nanoprecise\\global.properties");
		prop.load(fis);
		String browse = prop.getProperty("browser");

		if (browse.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

		} 

	}

//	@AfterClass
	public void closeTest() {
		driver.close();
	}


}
