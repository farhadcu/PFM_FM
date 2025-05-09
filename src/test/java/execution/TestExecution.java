package execution;

import org.testng.annotations.*;

import environment.BaseClass;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductPage;

public class TestExecution extends BaseClass {

	private LoginPage loginPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private CheckoutInfoPage checkoutInfoPage;
	private CheckoutOverviewPage checkoutOverviewPage;
	private CheckoutCompletePage checkoutCompletePage;
	private LogoutPage logoutPage;

	@BeforeMethod
	public void setupTest() {
		setup();
		loginPage = new LoginPage(getDriver());
		productPage = new ProductPage(getDriver());
		cartPage = new CartPage(getDriver());
		checkoutInfoPage = new CheckoutInfoPage(getDriver());
		checkoutOverviewPage = new CheckoutOverviewPage(getDriver());
		checkoutCompletePage = new CheckoutCompletePage(getDriver());
		logoutPage = new LogoutPage(getDriver());
	}

	@Test(priority = 1)
	public void LoginFunctionality() throws InterruptedException {
		// Login Process
		loginPage.enterUser("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		// product page verification
		productPage.verifyProductPage();
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void LoginNegativeFunctionality() throws InterruptedException {
		// Login Process
		loginPage.enterUser("wrong_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		// incorrect user login validation
		loginPage.incorrectUserLoginValidation();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void AddToCart() throws InterruptedException {
		// Login Process
		loginPage.enterUser("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		Thread.sleep(5000);

		// Buy two products and go to add to cart
		productPage.BuyFirstTwoProducts();
		// Verify that both products are present in the cart page
		cartPage.verifyCartProducts();
		// Add and remove items two times and Verify cart badge count updates correctly
		productPage.addRemoveProducts();
	}

	@Test(priority = 4)
	public void CheckoutProcess() throws InterruptedException {
		// Login Process
		loginPage.enterUser("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		Thread.sleep(5000);

		// add a product and checkout
		productPage.addSingleProduct();
		cartPage.checkoutProduct();

		// information fill into checkout info page
		checkoutInfoPage.enterFirstName("John");
		checkoutInfoPage.enterLastName("Doe");
		checkoutInfoPage.enterPostalCode("12345");
		checkoutInfoPage.clickContinue();
		Thread.sleep(5000);

		// Checkout Overview Product Verify & finish order click
		checkoutOverviewPage.verifyAddedProduct();
		Thread.sleep(4000);
		checkoutOverviewPage.checkoutOverviewFinish();
		Thread.sleep(5000);

		// Checkout Complete Verify Success Message
		checkoutCompletePage.verifySuccessMessage();
		Thread.sleep(5000);
	}

	@Test(priority = 5)
	public void SortingProducts() throws InterruptedException {
		// Login Process
		loginPage.enterUser("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		Thread.sleep(5000);

		// Sorting Products
		productPage.priceLowToHigh();
		productPage.priceHighToLow();
		productPage.nameAToZ();
		productPage.nameZToA();

		Thread.sleep(5000);
	}

	@Test(priority = 6)
	public void LogoutFunctionality() throws InterruptedException {
		// Login Process
		loginPage.enterUser("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		Thread.sleep(5000);

		// logout
		logoutPage.logoutClick();
		Thread.sleep(5000);
	}

	@Test(priority = 7)
	public void LockedOutUser() throws InterruptedException {
		// Login Process
		loginPage.enterUser("locked_out_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		// locked out user validation
		loginPage.lockedOutUserValidation();
		Thread.sleep(5000);
	}

	@Test(priority = 8)
	public void CartBadgeCount() throws InterruptedException {
		// Login Process
		loginPage.enterUser("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();
		Thread.sleep(5000);

		// cart badge count validation after adding products
		productPage.CartBadgeCountValidation();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void closeBrowser() {
		closeDown();
	}
}
