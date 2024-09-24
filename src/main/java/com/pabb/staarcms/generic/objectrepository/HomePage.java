package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author bheem
 * 
 * contains all major tab like third-party,servcise,and shipmets & business lib like logout
 * 
 */
public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Third-parties']")
	private WebElement third_partiesTab;
	
	@FindBy(xpath="//span[text()='Services']")
	private WebElement servicesTab;
	
	@FindBy(xpath="//span[text()='Commerce']")
	private WebElement commerceTab;

	@FindBy(xpath="//a[@class='dropdown-toggle login-dropdown-a']")
	private WebElement profiledropdown;
	 
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement logoutBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getThird_partiesTab() {
		return third_partiesTab;
	}

	public WebElement getServicesTab() {
		return servicesTab;
	}

	public WebElement getCommerceTab() {
		return commerceTab;
	}

	public WebElement getProfiledropdown() {
		return profiledropdown;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	public void clickonLogout() 
	{
		profiledropdown.click();
		logoutBtn.click();
	}
	
}
