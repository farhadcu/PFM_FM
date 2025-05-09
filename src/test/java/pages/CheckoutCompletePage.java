package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutCompletePage {
	protected WebDriver driver;

	// constructor
	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
		// extra addition for PFM
		PageFactory.initElements(driver, this);
	}

	// Locate element using PFM
	@FindBy(xpath = "/html/body/div/div/div/div[2]/h2")
	private WebElement successMessageTitle;

	// Verify Success Message (Assertion)
	public void verifySuccessMessage() {
		String actTitle = successMessageTitle.getText();
		System.out.println(actTitle);
		String expTitle = "Thank you for your order!";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");
		System.out.println("Verified that success message: Thank you for your order!");
	}
}
