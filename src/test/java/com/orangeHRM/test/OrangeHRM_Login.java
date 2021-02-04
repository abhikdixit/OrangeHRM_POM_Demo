package com.orangeHRM.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.common.OrangeHRM_BasePage;
import com.orangeHRM.common.OrangeHRM_BaseSetup;
import com.orangeHRM.home.OrangeHRM_SingInPage;
import com.orangeHRM.utils.OrangeHRM_TestData;

public class OrangeHRM_Login extends OrangeHRM_BaseSetup {

	OrangeHRM_SingInPage signIn;
	OrangeHRM_BasePage basePage;
	OrangeHRM_BaseSetup baseSetup;
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new OrangeHRM_BasePage(driver);
	}

	@Test(description = "validateLogo() method call for logo verification", priority = 1)
	public void logoTest() throws Exception {
		test = extent.createTest("Test Case 1", "Verify Logo image after login");
		signIn = basePage.GoToHomePageAndSignIn("admin", "admin1234");
		Thread.sleep(3000);
		signIn.validateLogo();
	}

	@Test(dataProvider = "Login", dataProviderClass = OrangeHRM_TestData.class, description = "verifySignInPageURL() method call for URL verification", priority = 2)
	public void urlTest(String userName, String passWord) throws Exception {
		test = extent.createTest("Test Case 2", "Verify Login Page URL");
		signIn = basePage.GoToHomePageAndSignIn(userName, passWord);
		Thread.sleep(3000);
		signIn.verifySignInPageURL();
		basePage.logout();
	}

	@Test(dataProvider = "Login", dataProviderClass = OrangeHRM_TestData.class, description = "verifySignInPageText() method call for Tab verification", priority = 3)
	public void textTest(String userName, String passWord) throws Exception {
		test = extent.createTest("Test Case 3", "Verify Login Page tab's text");
		signIn = basePage.GoToHomePageAndSignIn(userName, passWord);
		Thread.sleep(3000);
		signIn.verifySignInPageText();
		basePage.logout();
	}

}
