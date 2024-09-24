package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdParty_contact_Page {
	WebDriver driver;

	public ThirdParty_contact_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "New Third Party")
	private WebElement newthirdpartylink;

	@FindBy(xpath = "//a[@title=\"List of Customers\"]")
	private WebElement listofCustomerLink;
	
	@FindBy(xpath = "//a[@href=\"/dolibarr/societe/list.php?leftmenu=thirdparties\"]")
	private WebElement listLink;

	public WebElement getListLink() {
		return listLink;
	}

	public WebElement getNewthirdpartylink() {
		return newthirdpartylink;
	}

	public WebElement getListofCustomerLink() {
		return listofCustomerLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getThirdpartylink() {
		return newthirdpartylink;
	}

}
