package com.orangeHRM.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.home.OrangeHRM_SingInPage;

import org.openqa.selenium.WebElement;

public class OrangeHRM_BasePage {
	
	private WebDriver driver;
	
	@FindBy(id = "txtUsername")
	WebElement txtUsername;

	@FindBy(name = "txtPassword")
	WebElement txtPassword;

	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	WebElement btnLogin;
	
	@FindBy(id = "welcome")
	WebElement txtWelcome;
	
	@FindBy(linkText = "Logout")
	WebElement lnLogout;
	
	@FindBy(id = "divLogo")
	WebElement divLogo_img;

	public WebDriver getDriver() {
		return driver;
	}

	public OrangeHRM_BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Sign in functionality
	public OrangeHRM_SingInPage GoToHomePageAndSignIn(String username, String passwd) throws Exception {
		return signInToOrangeHRM(username, passwd);
	}

	public OrangeHRM_SingInPage signInToOrangeHRM(String username, String passwd) {
		enterUserName(username);
		enterPassword(passwd);
		submitButton();
		return new OrangeHRM_SingInPage(driver);
	}

	public void enterUserName(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}

	public void enterPassword(String passwd) {
		txtPassword.clear();
		txtPassword.sendKeys(passwd);
	}

	public void submitButton() {
		btnLogin.click();
	}
	
	public void logout() throws InterruptedException {
		txtWelcome.click();
		Thread.sleep(3000);
		lnLogout.click();
		divLogo_img.isDisplayed();
	}
}
