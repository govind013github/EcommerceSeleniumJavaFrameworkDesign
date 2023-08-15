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

public class SearchProduct extends BaseTest {

	String searchProductName = "zara coat 3";

	@Test(dataProvider = "getData")
	public void SearchProductCatalouge(HashMap<String, String> input1) throws IOException, InterruptedException {

		// TODO Auto-generated method stub
		landingpage.loginApplication(input1.get("email"), input1.get("password"));
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		String searchresult = productCatalouge.searchProduct();
		Assert.assertEquals(searchresult.toLowerCase(), searchProductName);
		
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\govindqalab\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	
}
