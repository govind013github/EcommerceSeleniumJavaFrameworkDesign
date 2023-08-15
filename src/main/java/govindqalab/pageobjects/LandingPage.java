package govindqalab.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import govindqalab.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// initialization of driver
		this.driver = driver;
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// Pagefactory design pattern as below.

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;
/*
//-----------------------------------------Signup--------------------------------------------------------------------------

	@FindBy(xpath = "//a[@class='text-reset']")
	WebElement signUpLink;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstNameInput;

	@FindBy(css = "#lastName")
	WebElement lastNameInput;

	@FindBy(css = "#userEmail")
	WebElement userEmailInput;

	@FindBy(css = "#userMobile")
	WebElement phoneNumberInput;

	@FindBy(tagName = "select")
	WebElement occupationInput;

	@FindBy(xpath = "input[value='Male']")
	WebElement genderMaleRadio;

	@FindBy(xpath = "input[value='Female']")
	WebElement genderFemaleRadio;

	@FindBy(css = "#userPassword")
	WebElement passwordInput;

	@FindBy(css = "#confirmPassword")
	WebElement confirmPasswordInput;

	@FindBy(css = "input[type='checkbox']")
	WebElement ageCheckBox;

	@FindBy(css = "#login")
	WebElement registerButton;

*/
//--------------------------------------------------------------------------------------------------------------------	
	public void loginApplication(String email, String password) // Action methods to be created like this.
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	}
/*
//-----------------------------------------------Signup---------------------------------------------------------------------	
	public void signUp(String firstname, String lastname, String email, String phonenumber, String occupation,
			String gender, String password, String confirmpassword, boolean checkbox) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpLink);
		signUpLink.click();
		firstNameInput.sendKeys(firstname);
		lastNameInput.sendKeys(lastname);
		userEmailInput.sendKeys(email);
		phoneNumberInput.sendKeys(phonenumber);
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys(confirmpassword);

		if (gender.equalsIgnoreCase("Male")) {
			genderMaleRadio.click();
		} else if (gender.equalsIgnoreCase("Female")) {
			genderFemaleRadio.click();
		}

		Select occupationSelect = new Select(occupationInput);
		occupationSelect.selectByValue(occupation);

		if (checkbox) {
			if (!ageCheckBox.isSelected()) {
				ageCheckBox.click();
			}
		} else {
			if (ageCheckBox.isSelected()) {
				ageCheckBox.click();
			}
		}

		registerButton.click();

	}
*/
//--------------------------------------------------------------------------------------------------------------------	

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

}
