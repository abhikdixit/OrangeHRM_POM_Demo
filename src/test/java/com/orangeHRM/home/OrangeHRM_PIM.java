package com.orangeHRM.home;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_PIM {

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='menu_pim_viewPimModule']/b")
	WebElement pimObject;

	@FindBy(id = "menu_pim_addEmployee")
	WebElement addEmployee;

	@FindBy(id = "firstName")
	WebElement Addfirstname;

	@FindBy(id = "lastName")
	WebElement AddlastName;

	@FindBy(id = "chkLogin")
	WebElement checkLogincheckBox;

	@FindBy(id = "btnSave")
	WebElement btnSaveLoginDetails;

	@FindBy(id = "user_name")
	WebElement userName;

	@FindBy(id = "user_password")
	WebElement userPassword;

	@FindBy(id = "re_password")
	WebElement rePassword;

	@FindBy(id = "dialogDeleteBtn")
	WebElement btnDialogDelete;

	@FindBy(id = "btnDelete")
	WebElement btnDelete;

	public OrangeHRM_PIM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private void addEmployeeOption(String firstName, String lastName, String userName, String userPass, String rePass)
			throws InterruptedException {

		Addfirstname.sendKeys(firstName);
		Thread.sleep(1000);
		AddlastName.sendKeys(lastName);
		Thread.sleep(1000);
		checkLogincheckBox.click();
		Thread.sleep(1000);
		this.userName.sendKeys(userName);
		Thread.sleep(1000);
		this.userPassword.sendKeys(userPass);
		this.rePassword.sendKeys(rePass);
		Thread.sleep(1000);
		btnSaveLoginDetails.click();
		Thread.sleep(2000);
	}

	private void addEmpHead() throws InterruptedException {

		Thread.sleep(1000);
		pimObject.click();
		Thread.sleep(1000);
		addEmployee.click();
		Thread.sleep(1000);

	}

	public void addEmployees(String strFirstName, String strLastName, String strUserName, String strPassword)
			throws InterruptedException {
		addEmpHead();
		Thread.sleep(1000);
		addEmployeeOption(strFirstName, strLastName, strUserName, strPassword, strPassword);
	}

	private void deleteEmpOption(String _empName) throws InterruptedException {
		Thread.sleep(1000);
		pimObject.click();
		Thread.sleep(1000);
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td/a"));
			int rows_lenght = rows.size()/3;
			System.out.println(rows_lenght);
		String beforeXpath = "//*[@id='resultTable']/tbody/tr[";
		String afterXpath = "]/td[4]";
		for (int i = 1; i < rows_lenght; i++) {
			String searchPath = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			if (searchPath.contains(_empName)) {
				if (!driver.findElement(By.xpath(beforeXpath + i + "]/td[1]/input")).isSelected()) {
					driver.findElement(By.xpath(beforeXpath + i + "]/td[1]/input")).click();
				}
			}
		}
		Thread.sleep(1000);
		btnDelete.click();
		Thread.sleep(1000);
		btnDialogDelete.click();
		Thread.sleep(1000);

	}

	public void deleteEmployees(String strLastName) throws InterruptedException {
		deleteEmpOption(strLastName);
		Thread.sleep(1000);
	}

}
