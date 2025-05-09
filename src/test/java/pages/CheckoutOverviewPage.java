package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutOverviewPage {
	protected WebDriver driver;

	// constructor
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		// extra addition for PFM
		PageFactory.initElements(driver, this);
	}

	// Locate elements using PFM
	@FindBy(id = "item_4_title_link")
	private WebElement addedProduct;

	@FindBy(id = "finish")
	private WebElement finishBtn;

	// verify the correct item appears in the summary (Assertion)
	public void verifyAddedProduct() {
		String actAddedProductName = addedProduct.getText();
		System.out.println(actAddedProductName);
		String expAddedProductName = "Sauce Labs Backpack";
		Assert.assertEquals(actAddedProductName, expAddedProductName, "Condition Mismatch");
		System.out.println("Verifed that the correct item appears in the summary");
	}

	// checkout finish order click
	public void checkoutOverviewFinish() {
		finishBtn.click();
		System.out.println("Now we are in Checkout Complete Page");
	}
}
