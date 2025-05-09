package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	protected WebDriver driver;

	// constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		// extra addition for PFM
		PageFactory.initElements(driver, this);
	}

	// Locate elements in PFM
	@FindBy(id = "item_4_title_link")
	private WebElement firstProduct;

	@FindBy(id = "item_0_title_link")
	private WebElement secondProduct;

	@FindBy(id = "continue-shopping")
	private WebElement continueShoppingBtn;

	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	public void verifyCartProducts() {
		// Verify that both products are present in the cart page (Assertion)
		String actFirstProduct = firstProduct.getText();
		System.out.println(actFirstProduct);
		String expFirstProduct = "Sauce Labs Backpack";
		Assert.assertEquals(actFirstProduct, expFirstProduct, "Condition Mismatch");

		String actSecondProduct = secondProduct.getText();
		System.out.println(actSecondProduct);
		String expSecondProduct = "Sauce Labs Bike Light";
		Assert.assertEquals(actSecondProduct, expSecondProduct, "Condition Mismatch");

		System.out.println("Verified that both products are present in the cart");
		// assertion end

		// continue shopping click
		continueShoppingBtn.click();
	}

	public void checkoutProduct() throws InterruptedException {
		// proceed to checkout
		checkoutBtn.click();
		System.out.println("proceeded to checkout");
	}

}
