package com.Vtiger.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRe.ConatctInfoPage;
import com.Vtiger.ObjectRe.ContactOrg_popup;
import com.Vtiger.ObjectRe.CreateNewContactPage;
import com.Vtiger.ObjectRe.HomePage;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.TestData;
import com.Vtiger.generic.webdriverutil;

import junit.framework.Assert;

public class TC03_CreateContact_org extends BaseClass {
	//@Parameters("Contactsname")
	@Test
	public void createcontact_org() throws IOException, InterruptedException 
	{
		webdriverutil webDriverUtil = new webdriverutil(driver);

		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		ConatctInfoPage conatctInfoPage = new  ConatctInfoPage(driver);
		conatctInfoPage.getCreatecontactsimg().click();
		TestData testData= new TestData();

		String contactname=testData.getLastName();

		System.out.println(contactname);

		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		createNewContactPage.getLastNameEdt().sendKeys(contactname);

		createNewContactPage.getOrganizationLookUpImage().click();

		Thread.sleep(2000);
		webDriverUtil.switchWindow("Accounts");

		Thread.sleep(4000);

		ContactOrg_popup contactOrg_popup = new ContactOrg_popup(driver);

		contactOrg_popup.searchandSelectforOrg("Mango");

		Thread.sleep(2000);
		webDriverUtil.switchWindow("Contacts");

		createNewContactPage.getSaveBtn().click();

		Thread.sleep(8000);

		String contactid=createNewContactPage.getcontactid().getText();

		System.out.println(contactid);
		driver.navigate().refresh();

		homePage.getContactslink().click();

		conatctInfoPage.checkcontactcreated(contactid);

		Thread.sleep(4000);

		String actualcontactlastname=conatctInfoPage.getactualcontact().getText();

		System.out.println(actualcontactlastname);

		Assert.assertEquals(actualcontactlastname, contactname);
	}

}
