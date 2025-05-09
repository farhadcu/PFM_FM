package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogoutPage {
	protected WebDriver driver;

	// constructor
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		// extra addition for PFM
		PageFactory.initElements(driver, this);
	}

	// Locate elements in PFM
	@FindBy(id = "react-burger-menu-btn")
	private WebElement burgerMenuBtn;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutLink;

	public void logoutClick() throws InterruptedException {
		// Click the hamburger menu (☰) in the top-left corner.
		burgerMenuBtn.click();
		Thread.sleep(3000);
		System.out.println("Burger Menu clicked");

		// Logout Button click
		logoutLink.click();
		System.out.println("Logout Button clicked");

		// Verify successful login by checking for the Products page url. (Assertion)
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/";
		Assert.assertEquals(currentUrl, expectedUrl, "Condition Mismatch");
		System.out.println("Verified that the user is redirected to the login page.");
		// assertion end

	}

}
