package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPage {
	protected WebDriver driver;

	// constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		// extra addition for PFM
		PageFactory.initElements(driver, this);
	}

	// Locate elements in PFM
	@FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/span")
	private WebElement headerProductsTitle;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement firstProductAddBtn;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement secondProductAddBtn;

	@FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[3]/a")
	private WebElement cartIconBtn;

	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement thirdProductAddBtn;
	@FindBy(id = "remove-sauce-labs-bolt-t-shirt")
	private WebElement thirdProductRemoveBtn;

	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement fourthProductAddBtn;
	@FindBy(id = "remove-sauce-labs-fleece-jacket")
	private WebElement fourthProductRemoveBtn;

	@FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select")
	private WebElement sortDropdown;

	@FindBy(className = "inventory_item_name")
	private List<WebElement> productNames;

	// Verify by checking for the Products page. (Assertion)
	public void verifyProductPage() {
		String actTitle = headerProductsTitle.getText();
		String expTitle = "Products";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");
		System.out.println("Verified that successful login by checking for the Products page");
	}

	public void BuyFirstTwoProducts() throws InterruptedException {

		// Add the first two products to the cart by clicking Add to cart.
		firstProductAddBtn.click();
		secondProductAddBtn.click();
		System.out.println("first two products added to cart");

		Thread.sleep(4000);
		// Click the cart icon to view the cart.
		cartIconBtn.click();
		Thread.sleep(5000);

	}

	public void addRemoveProducts() throws InterruptedException {

		// Add and remove items two times.
		thirdProductAddBtn.click();
		Thread.sleep(3000);
		thirdProductRemoveBtn.click();
		Thread.sleep(3000);
		fourthProductAddBtn.click();
		Thread.sleep(3000);
		fourthProductRemoveBtn.click();
		System.out.println("Added and removed two items two times.");

		// Verify cart badge count updates correctly (Assertion)
		String actCartBadgeCount = cartIconBtn.getText();
		System.out.println(actCartBadgeCount);
		String expCartBadgeCount = "2";
		Assert.assertEquals(actCartBadgeCount, expCartBadgeCount, "Condition Mismatch");
		System.out.println("Verified that cart badge count updates correctly");
		// assertion end

		Thread.sleep(5000);

	}

	public void addSingleProduct() throws InterruptedException {
		// Add a product to the cart.
		firstProductAddBtn.click();
		// Click the cart icon to view the cart.
		cartIconBtn.click();
		Thread.sleep(5000);
	}

//	Used the Sort by drop down to sort products functions
	public void priceLowToHigh() throws InterruptedException {
		Select select = new Select(sortDropdown);
		select.selectByIndex(2);
		System.out.println("Dorpdown Price (low to high) Completed");

		// Verify that the products are displayed in the correct order based on the selected option (Assertion)
		String actProductName = productNames.get(0).getText(); // first product name selected
		System.out.println(actProductName);
		String expProductName = "Sauce Labs Onesie";
		Assert.assertEquals(actProductName, expProductName, "Condition Mismatch");
		System.out.println("Verified that the products are displayed in the correct order based on: Price (low to high)");
		// assertion end
		Thread.sleep(5000);
	}

	public void priceHighToLow() throws InterruptedException {
		Select select = new Select(sortDropdown);
		select.selectByIndex(3);
		System.out.println("Dorpdown Price (high to low) Completed");

		// Verify that the products are displayed in the correct order based on the selected option (Assertion)
		String actProductName = productNames.get(0).getText(); // first product name selected
		System.out.println(actProductName);
		String expProductName = "Sauce Labs Fleece Jacket";
		Assert.assertEquals(actProductName, expProductName, "Condition Mismatch");
		System.out.println("Verified that the products are displayed in the correct order based on: Price (high to low)");
		// assertion end
		Thread.sleep(5000);
	}

	public void nameAToZ() throws InterruptedException {
		Select select = new Select(sortDropdown);
		select.selectByIndex(0);
		System.out.println("Dorpdown Name (A to Z) Completed");

		// Verify that the products are displayed in the correct order based on the selected option (Assertion)
		String actProductName = productNames.get(0).getText(); // first product name selected
		System.out.println(actProductName);
		String expProductName = "Sauce Labs Backpack";
		Assert.assertEquals(actProductName, expProductName, "Condition Mismatch");
		System.out.println("Verified that the products are displayed in the correct order based on: Name (A to Z)");
		// assertion end
		Thread.sleep(5000);
	}

	public void nameZToA() throws InterruptedException {
		Select select = new Select(sortDropdown);
		select.selectByIndex(1);
		System.out.println("Dorpdown Name (Z to A) Completed");

		// Verify that the products are displayed in the correct order based on the selected option (Assertion)
		String actProductName = productNames.get(0).getText(); // first product name selected
		System.out.println(actProductName);
		String expProductName = "Test.allTheThings() T-Shirt (Red)";
		Assert.assertEquals(actProductName, expProductName, "Condition Mismatch");
		System.out.println("Verified that the products are displayed in the correct order based on: Name (Z to A)");
		// assertion end
		Thread.sleep(5000);
	}

	public void CartBadgeCountValidation() throws InterruptedException {
		// Add the four products to the cart by clicking Add to cart.
		firstProductAddBtn.click();
		secondProductAddBtn.click();
		thirdProductAddBtn.click();
		fourthProductAddBtn.click();
		System.out.println("Added four products");
		Thread.sleep(4000);

		// Verify the cart badge shows the correct item count (Assertion)
		String actCartBadgeCount = cartIconBtn.getText();
		System.out.println(actCartBadgeCount);
		String expCartBadgeCount = "4";
		Assert.assertEquals(actCartBadgeCount, expCartBadgeCount, "Condition Mismatch");
		System.out.println("Verified that the cart badge shows the correct item count");
		// assertion end

		// remove an item
		thirdProductRemoveBtn.click();
		System.out.println("Removed one product");
		Thread.sleep(4000);

		// Verify the badge updates accordingly (Assertion)
		String actCartBadgeCount2 = cartIconBtn.getText();
		System.out.println(actCartBadgeCount2);
		String expCartBadgeCount2 = "3";
		Assert.assertEquals(actCartBadgeCount2, expCartBadgeCount2, "Condition Mismatch");
		System.out.println("Verified that the badge updates accordingly");
		// assertion end
	}

}
