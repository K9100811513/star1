package com.Vtiger.TestCases;

import org.testng.annotations.Test;

import com.Vtiger.ObjectRe.CreateNewOrgPage;
import com.Vtiger.ObjectRe.HomePage;
import com.Vtiger.ObjectRe.OrgInfoPage;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.JavaUtil;
import com.Vtiger.generic.TestData;
import com.Vtiger.generic.webdriverutil;

import junit.framework.Assert;

public class TC02_CreateOrg_DD extends BaseClass{
	  

			@Test
			public void createorg_dd () throws Throwable {
				HomePage homePage= new HomePage(driver);
				homePage.getOrglink().click();

				OrgInfoPage orgInfoPage = new OrgInfoPage(driver);
				orgInfoPage.getCreateorgbtn().click();

				TestData testData= new TestData();
				JavaUtil javaUtil = new JavaUtil();
				String orgname=testData.getOrgname()+javaUtil.createRandomnumber1();
				CreateNewOrgPage createNewOrgPage= new CreateNewOrgPage(driver);

				createNewOrgPage.getOrgname().sendKeys(orgname);
				webdriverutil webDriverUtil= new webdriverutil(driver);

				webDriverUtil.selectValuefromdd("Active", createNewOrgPage.getRating());

				webDriverUtil.selectValuefromdd(createNewOrgPage.getIndustry(), "Education");

				webDriverUtil.selectValuefromdd(createNewOrgPage.getType(), 3);

				createNewOrgPage.getSaveorgbtn().click();

				Thread.sleep(4000);
				driver.navigate().refresh();

				homePage.getOrglink().click();

				orgInfoPage.searchforOrg(orgname, "accountname");

				Thread.sleep(3000);

				String actualorgname=orgInfoPage.getfirstOrg().getText();

				Assert.assertEquals(actualorgname, orgname);
			}

}
