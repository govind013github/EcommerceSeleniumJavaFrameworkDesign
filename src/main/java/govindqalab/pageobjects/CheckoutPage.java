package govindqalab.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import govindqalab.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement submit;

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;

	By results = By.cssSelector(".ta-results"); // page factory WebElement dec which uses wait.

//------------------------------------------Additional payment----------------------------------------

	@FindBy(css = "input[value='4542 9931 9292 2293']")
	WebElement crediCardNumber;

	@FindBy(xpath = "(//select[@class='input ddl'])[1]")
	WebElement expiryMonth;

	@FindBy(xpath = "(//select[@class='input ddl'])[2]")
	WebElement expiryDay;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement cardName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement cvvCode;

//	-----------------------------------------Additional payment--------------------------------------------

	public void paymentDetails() {
		crediCardNumber.clear();
		crediCardNumber.sendKeys("4542 9931 9292 2299");
		cvvCode.sendKeys("123");
		cardName.sendKeys("Govind");
		Select month = new Select(expiryMonth);
		month.selectByVisibleText("03");
		Select day = new Select(expiryMonth);
		day.selectByVisibleText("02");

	}

//-----------------------------------------------------------------------------------------------	

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public void submitOrder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submit);

	}

}
