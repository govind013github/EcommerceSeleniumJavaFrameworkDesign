package govindqalab.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
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

public class FilterProducts extends BaseTest {

	String searchProductName = "zara coat 3";

	@Test(dataProvider = "getData")
	public void SearchProductCatalouge(HashMap<String, String> input1) throws IOException, InterruptedException {

		// TODO Auto-generated method stub
		landingpage.loginApplication(input1.get("email"), input1.get("password"));
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		String beforeFilterResult = productCatalouge.beforeFilter();
		System.out.println(beforeFilterResult);
		productCatalouge.setPriceRange(21500, 31500);
		productCatalouge.selectCategory("fashion");
		productCatalouge.selectSubCategory("shirts");
//		productCatalouge.selectGender("Women");
		String afterFilterResult = productCatalouge.afterFilter();
		System.out.println(afterFilterResult);
		Assert.assertNotSame(afterFilterResult, beforeFilterResult, "No products found");
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\govindqalab\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	
}
