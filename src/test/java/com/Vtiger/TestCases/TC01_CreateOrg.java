package com.Vtiger.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRe.CreateNewOrgPage;
import com.Vtiger.ObjectRe.HomePage;
import com.Vtiger.ObjectRe.OrgInfoPage;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.JavaUtil;
import com.Vtiger.generic.TestData;

public class TC01_CreateOrg extends BaseClass {
	//@Parameters("Orgname")
	@Test(enabled= true)
	public void createorg () throws Throwable
	{
		HomePage homePage = new HomePage(driver);

		homePage.getOrglink().click();

		OrgInfoPage orgInfoPage= new OrgInfoPage(driver);
		orgInfoPage.getCreateorgbtn().click();

		TestData testData= new TestData();
		JavaUtil javaUtil = new JavaUtil();
		String Orgname=testData.getOrgname()+javaUtil.createRandomnumber1();

		CreateNewOrgPage createNewOrgPage = new CreateNewOrgPage(driver);

		createNewOrgPage.getOrgname().sendKeys(Orgname);
		createNewOrgPage.getSaveorgbtn().click();

		Thread.sleep(4000);
		driver.navigate().refresh();

		homePage.getOrglink().click();

		orgInfoPage.searchforOrg(Orgname, "accountname");

		Thread.sleep(3000);

		String actualorgname=orgInfoPage.getfirstOrg().getText();
		Thread.sleep(3000);

		Assert.assertFalse(true);
		Assert.assertEquals(Orgname, actualorgname);

	}

}
