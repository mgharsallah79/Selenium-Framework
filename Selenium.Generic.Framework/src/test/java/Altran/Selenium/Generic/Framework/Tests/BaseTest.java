package Altran.Selenium.Generic.Framework.Tests;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");

		// Configurer les options chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--test-type");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
