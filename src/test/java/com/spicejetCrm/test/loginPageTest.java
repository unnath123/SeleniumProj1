package com.spicejetCrm.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spiceJetcrm.Base.BaseTest;
import com.spiceJetcrm.pages.homePage;
import com.spiceJetcrm.pages.loginPage;

public class loginPageTest extends BaseTest {
	loginPage loginpage;
	homePage hmpage;

	public loginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new loginPage();
	}

	@Test(priority=1)
	public void GetPageTitle() {
		String title = loginpage.getLoginPageTitle();
		// Assert.assertEquals(expectedTitle, ActualTitle) this page has no title
	}

	@Test(priority = 2)
	public void loginTest() {
		hmpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
