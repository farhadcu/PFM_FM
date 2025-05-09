package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage {
	protected WebDriver driver;

	// constructor
	public CheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
		// extra addition for PFM
		PageFactory.initElements(driver, this);
	}

	// Locate elements using PFM
	@FindBy(id = "first-name")
	private WebElement firstNameField;

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "postal-code")
	private WebElement postalCodeField;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	// enter first name
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
		System.out.println("First Name set completed");
	}

	// enter last name
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
		System.out.println("Last Name set completed");
	}

	// enter postal code
	public void enterPostalCode(String zipCode) throws InterruptedException {
		postalCodeField.sendKeys(zipCode);
		System.out.println("Zip Code set completed");
		Thread.sleep(3000);
	}

	// click continue function
	public void clickContinue() {
		continueBtn.click();
		System.out.println("Click Continue completed");

	}
}
