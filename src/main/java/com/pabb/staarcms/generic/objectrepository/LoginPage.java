package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author bheem
 * 
 * contains login page elements & business lib like login
 * 
 */
public class LoginPage {
	WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
  	PageFactory.initElements(driver,this);
}
@FindBy(name="username")
WebElement usernameTF;

@FindBy(name="password")
WebElement passwordTF;

@FindBy(xpath="//input[@class=\"button\"]")
WebElement loginBTN;
public WebDriver getDriver() {
	return driver;
}

public WebElement getUsernameTF() {
	return usernameTF;
}

public WebElement getPasswordTF() {
	return passwordTF;
}

public WebElement getLoginBTN() {
	return loginBTN;
}
public void loginToApp(String username,String password)
{
	usernameTF.sendKeys(username);
	passwordTF.sendKeys(password);
	loginBTN.click();
}

}
