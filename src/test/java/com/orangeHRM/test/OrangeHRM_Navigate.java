package com.orangeHRM.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.common.OrangeHRM_BasePage;
import com.orangeHRM.common.OrangeHRM_BaseSetup;
import com.orangeHRM.home.OrangeHRM_HomePage;
import com.orangeHRM.home.OrangeHRM_SingInPage;
import com.orangeHRM.utils.OrangeHRM_TestData;

public class OrangeHRM_Navigate extends OrangeHRM_BaseSetup {

	OrangeHRM_HomePage homePage;
	OrangeHRM_BasePage basePage;
	OrangeHRM_SingInPage signIn;
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		driver = getDriver();
		basePage = new OrangeHRM_BasePage(driver);
		homePage = new OrangeHRM_HomePage(driver);
	}
	
	@AfterClass
	public void LogOut() throws InterruptedException {
		basePage.logout();
		Thread.sleep(1000);
	}

	@Test(dataProvider = "Login", dataProviderClass = OrangeHRM_TestData.class, priority = 4)
	public void navigateToHomePage(String userName, String passWord) throws Exception {	
		test = extent.createTest("Test Case 4", "Navigate Through Elements on Home Page");
		Thread.sleep(1000);
		signIn = basePage.GoToHomePageAndSignIn(userName, passWord);
		Thread.sleep(3000);
        homePage.NavigateTohomePage(driver);
	}

}
