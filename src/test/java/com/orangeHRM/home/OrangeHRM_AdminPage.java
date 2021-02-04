package com.orangeHRM.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM_AdminPage {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
	WebElement adminTab;

	@FindBy(id = "menu_admin_UserManagement")
	WebElement tbUserManagement;

	@FindBy(id = "systemUser_employeeName_empName")
	WebElement empName;
	
	@FindBy(id = "systemUser_userName")
	WebElement userName;
	
	@FindBy(id = "systemUser_password")
	WebElement userPassword;
	
	@FindBy(id = "systemUser_confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id = "btnSave")
	WebElement btnSave;
	
	@FindBy(id = "btnAdd")
	WebElement btnAdd;
	
	@FindBy(id = "systemUser_userType")
	WebElement slUserType;
	
	@FindBy(id = "systemUser_status")
	WebElement slUserStatus;
	
	@FindBy(id = "btnDelete")
	WebElement btnDelete;
	

	public OrangeHRM_AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addUserOption(String _userRole, String _empName, String _userName, String _userStatus, String _userPass,
			String _rePass) throws InterruptedException {
		
		Select userRole = new Select(slUserType);
		Select userStatus = new Select(slUserStatus);
		
		Thread.sleep(1000);
		userRole.selectByVisibleText(_userRole);
		Thread.sleep(1000);
		empName.sendKeys(_empName);
		Thread.sleep(2000);
		userName.sendKeys(_userName);
		Thread.sleep(1000);
		userStatus.selectByVisibleText(_userStatus);
		Thread.sleep(1000);
		userPassword.sendKeys(_userPass);
		Thread.sleep(1000);
		confirmPassword.sendKeys(_rePass);
		Thread.sleep(1000);
		btnSave.click();
		Thread.sleep(2000);

	}

	public void addUserHead() throws InterruptedException
	{
		Thread.sleep(1000);
		adminTab.click();
		Thread.sleep(1000);
		btnAdd.click();
		Thread.sleep(1000);

	}

}
