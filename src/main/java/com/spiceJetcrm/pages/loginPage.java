package com.spiceJetcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spiceJetcrm.Base.BaseTest;

public class loginPage extends BaseTest {
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement NavigateToLoginPage;
	
	@FindBy(xpath="//div[text()='Email']")
	WebElement Select_Email;
	
	@FindBy(xpath="//div[text()='Mobile Number']")
	WebElement Select_MobileNo;
	
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement mobileNumber;
	
	@FindBy(xpath="//input[@data-testid='password-input-box-cta']")
	WebElement Password;
	
	@FindBy(xpath = "//div[@data-testid='login-cta']")
	WebElement login_btn;
	
	@FindBy(xpath="//div[contains(text(),'Forgot')]")
	WebElement forgot_password;
	
	@FindBy(xpath="//div[text()='Sign Up')]")
	WebElement Sign_up;
	
	public loginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
//	public void ipMobileNo(String num) {
//		mobileNumber.sendKeys(num);
//	}
	
	public homePage login(String username, String password) {
		NavigateToLoginPage.click();
		mobileNumber.sendKeys(username);
		Password.sendKeys(password);
		login_btn.click();
//		Actions actions = new Actions(driver);
//		actions.moveToElement(login_btn).click().perform();
		
		return new homePage();
	}
	
}
