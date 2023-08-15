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

public class RemoveProductFromCart extends BaseTest {

	String productName = "zara coat 3";

	@Test(dataProvider = "getData")
	public void DeleteOrder(HashMap<String, String> input1) throws IOException, InterruptedException {

		// TODO Auto-generated method stub

		// LandingPage landingpage = new LandingPage(driver);
		// landingpage.goTo();
		landingpage.loginApplication(input1.get("email"), input1.get("password"));
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addProductToCart(input1.get("product"));
		productCatalouge.goToCartPage();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.verifyProductDisplay(input1.get("product"));
		Assert.assertTrue(match);
		String cartmsg = cartPage.removeProduct();
		Assert.assertEquals(cartmsg, "No Products in Your Cart !");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\govindqalab\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
