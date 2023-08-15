package govindqalab.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import govindqalab.TestComponents.BaseTest;
import govindqalab.pageobjects.CartPage;
import govindqalab.pageobjects.CheckoutPage;
import govindqalab.pageobjects.ConfirmationPage;
import govindqalab.pageobjects.LandingPage;
import govindqalab.pageobjects.OrderPage;
import govindqalab.pageobjects.ProductCatalouge;

public class SubmitOrderTest extends BaseTest {

	String productName = "zara coat 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// TODO Auto-generated method stub

		// LandingPage landingpage = new LandingPage(driver);
		// landingpage.goTo();
		landingpage.loginApplication(input.get("email"), input.get("password"));
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addProductToCart(input.get("product"));
		productCatalouge.goToCartPage();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		cartPage.goToCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.paymentDetails();
		checkoutPage.selectCountry("india");
		checkoutPage.submitOrder();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		// "zara coat 3"
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		landingpage.loginApplication("govind013@mailinator.com", "Govind@123");
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		productCatalouge.goToOrderPage();
		OrderPage ordersPage = new OrderPage(driver);
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\govindqalab\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
