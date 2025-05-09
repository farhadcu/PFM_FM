package environment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	protected WebDriver driver;

	public void setup() {
		// lunch chrome browser
		driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		System.out.println("Setup Completed");
		// use a wait for all
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// set url to the browser
		driver.get("https://www.saucedemo.com/");
	}

	// driver quite or close
	public void closeDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	// return the driver
	public WebDriver getDriver() {
		return driver;
	}
}
