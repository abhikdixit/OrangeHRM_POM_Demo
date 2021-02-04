package com.orangeHRM.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.common.OrangeHRM_BasePage;
import com.orangeHRM.common.OrangeHRM_BaseSetup;
import com.orangeHRM.home.OrangeHRM_AdminPage;
import com.orangeHRM.home.OrangeHRM_SingInPage;
import com.orangeHRM.utils.OrangeHRM_TestData;

public class OrangeHRM_AddUser extends OrangeHRM_BaseSetup {
	
	OrangeHRM_AdminPage adminPage;
	OrangeHRM_BasePage basePage;
	OrangeHRM_SingInPage signIn;
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		driver = getDriver();
		basePage = new OrangeHRM_BasePage(driver);
		adminPage = new OrangeHRM_AdminPage(driver);
	}
	
	@AfterClass
	public void LogOut() throws InterruptedException {
		basePage.logout();
		Thread.sleep(1000);
	}
	
	@Test(dataProvider = "Login", dataProviderClass = OrangeHRM_TestData.class, priority = 5)
	public void urlTest(String userName, String passWord) throws Exception {
		test = extent.createTest("Test Case 5", "Sign in");
		signIn = basePage.GoToHomePageAndSignIn(userName, passWord);
		Thread.sleep(3000);
		signIn.verifySignInPageURL();
	}
	
	@Test(dataProvider = "addUsers", dataProviderClass = OrangeHRM_TestData.class, priority = 6)
	public void addUser(String _userRole, String _empName, String _username, String _userStatus, String _password, String _repassword) throws InterruptedException {		
		test = extent.createTest("Test Case 6", "Add User From DataProviderClass");
		Thread.sleep(1000);
		adminPage.addUserHead();
	    adminPage.addUserOption(_userRole, _empName , _username, _userStatus, _password, _repassword);
	    Thread.sleep(1000);
	}

}
