package govindqalab.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import govindqalab.TestComponents.BaseTest;
import govindqalab.pageobjects.CartPage;
import govindqalab.pageobjects.LandingPage;
import govindqalab.pageobjects.ProductCatalouge;



public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"},retryAnalyzer=govindqalab.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException 
	{
		String productName = "zara coat 3";
		LandingPage landingpage = new LandingPage(driver);
		landingpage.loginApplication("govind@013mailinator.com", "123");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}
	
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		
		String productName = "zara coat 3";
		LandingPage landingpage = new LandingPage(driver);
		landingpage.loginApplication("sam02@mailinator.com", "Govind@123");
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addProductToCart(productName);
		productCatalouge.goToCartPage();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.verifyProductDisplay("zara coat 33");
		Assert.assertFalse(match);
   
	}
	
	
}
