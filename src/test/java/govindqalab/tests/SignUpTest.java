package govindqalab.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import govindqalab.TestComponents.BaseTest;
import govindqalab.pageobjects.LandingPage;

/*
public class SignUpTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void testSignUpWithValidData(HashMap<String, String> input1) throws IOException, InterruptedException {

		// TODO Auto-generated method stub

		LandingPage lpage = new LandingPage(driver);
		lpage.signUp(input1.get("firstname"), input1.get("lastname"), input1.get("email"), input1.get("phonenumber"),
				input1.get("occupation"), input1.get("gender"), input1.get("password"), input1.get("confirmpassword"),
				input1.containsValue("checkbox"));

		// Assert sucessfull signup message further. 

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\govindqalab\\data\\SignUp2.json");
		return new Object[][] { { data.get(0) } };
	}

}
*/

