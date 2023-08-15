package govindqalab.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import govindqalab.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement checkoutbutton;

	@FindBy(xpath = "(//button[@class='btn btn-danger'])[1]")
	WebElement deleteproduct;

	By removeMessage = By.xpath("(//div[@aria-label='No Product in Your Cart'])[1]");

	@FindBy(xpath = "//div[@class='ng-star-inserted']//h1")
	WebElement emptycart;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

	public void goToCheckout() {
		checkoutbutton.click();

	}

	public String removeProduct() {

		deleteproduct.click();
		waitForElementToAppear(removeMessage);
		String emptycartmsg = emptycart.getText();
		return emptycartmsg;
	}

}
