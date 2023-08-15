package govindqalab.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import govindqalab.AbstractComponents.AbstractComponent;

public class ProductCatalouge extends AbstractComponent {

	WebDriver driver;
	String item = "zara coat 3";

	public ProductCatalouge(WebDriver driver) {
		super(driver);
		// initialization of driver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// 	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	@FindBy(xpath = "(//input[@placeholder='search'])[2]")
	WebElement search;

	@FindBy(xpath = "//div[@class='card-body']//h5//b")
	WebElement searchitem;
//------------------------------------------------------------FilterProducts-------------------	
	@FindBy(xpath = "(//input[@placeholder='Min Price'])[2]")
	WebElement minInput;

	@FindBy(xpath = "(//input[@placeholder='Max Price'])[2]")
	WebElement maxInput;

	@FindBy(xpath = "(//input[@type='checkbox'])[12]")
	WebElement categoryFashion;

	@FindBy(xpath = "(//input[@type='checkbox'])[13]")
	WebElement categoryElectronics;

	@FindBy(xpath = "(//input[@type='checkbox'])[14]")
	WebElement categoryHousehold;

	@FindBy(xpath = "(//input[@type='checkbox'])[15]")
	WebElement subCategoriesTshirt;

	@FindBy(xpath = "(//input[@type='checkbox'])[16]")
	WebElement subCategoriesShirts;

	@FindBy(xpath = "(//input[@type='checkbox'])[17]")
	WebElement subCategoriesShoes;

	@FindBy(xpath = "(//input[@type='checkbox'])[18]")
	WebElement subCategoriesMobile;

	@FindBy(xpath = "(//input[@type='checkbox'])[19]")
	WebElement subCategoriesLaptops;

//--------------------------------------------------------------------------------------------------	

//As below locators are using waits its defined here using By.
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By searchResult = By.xpath("//div[@class='card-body']//h5//b");
	By filterResult = By.xpath("(//div[@id='res'])[1]");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}

	public WebElement getproductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getproductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}

	public String searchProduct() {
		search.click();
		search.sendKeys(item);
		search.sendKeys(Keys.RETURN);
		waitForElementToAppear(searchResult);
		String searchItemText = searchitem.getText();
		return searchItemText;
	}
//------------------------------------------------------------FilterProducts-------------------		

	public String beforeFilter() {
		WebElement filterMsg = driver.findElement(filterResult);
		String msg = filterMsg.getText();
		return msg;
	}

	public void setPriceRange(int minPrice, int maxPrice) {

		minInput.sendKeys(String.valueOf(minPrice));
		maxInput.sendKeys(String.valueOf(maxPrice));
		maxInput.sendKeys(Keys.RETURN);
	}

	public void selectCategory(String category) {

		if (category.equalsIgnoreCase("fashion")) {
			categoryFashion.click();
		} else if (category.equalsIgnoreCase("electronics")) {
			categoryElectronics.click();
		} else if (category.equalsIgnoreCase("household")) {
			categoryHousehold.click();
		}
	}

	public void selectSubCategory(String subcategory) {

		if (subcategory.equalsIgnoreCase("t-shirts")) {
			subCategoriesTshirt.click();
		} else if (subcategory.equalsIgnoreCase("shirts")) {
			subCategoriesShirts.click();
		} else if (subcategory.equalsIgnoreCase("shoes")) {
			subCategoriesShoes.click();
		} else if (subcategory.equalsIgnoreCase("mobiles")) {
			subCategoriesMobile.click();
		} else if (subcategory.equalsIgnoreCase("laptops")) {
			subCategoriesLaptops.click();
		}

	}

	public String afterFilter() {
		waitForElementToAppear(filterResult);
		WebElement filterMsg2 = driver.findElement(filterResult);
		String msg2 = filterMsg2.getText();
		return msg2;
	}

}
