package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewThirdPartyPage
{
WebDriver driver;
public CreateNewThirdPartyPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver,this);
}
@FindBy(id="name")
private WebElement thirdpartyNameTF;

@FindBy(xpath="//input[@aria-controls=\"select2-customerprospect-results\"]")
private WebElement customerDDTF;

public WebElement getThirdpartyNameTF() {
	return thirdpartyNameTF;
}

public WebElement getCustomerDDTF() {
	return customerDDTF;
}
@FindBy(xpath="//span[@class=\"select2-selection__arrow\"]/ancestor::td[@class=\"maxwidthonsmartphone\"]/select[@id=\"customerprospect\"]/following-sibling::span[@dir=\"ltr\"]/span[@class=\"selection\"]/descendant::span[@role=\"presentation\"]")
private WebElement customerDD;

@FindBy(xpath="//input[@value=\"Create third party\"]")
private WebElement createthirdpartyBTN;
public WebDriver getDriver()
{
	return driver;     
}

public WebElement getNewthirdpartyTF() {
	return thirdpartyNameTF;
}

public WebElement getCustomerDD() {
	return customerDD;
}

public WebElement getCreatethirdpartyBTN() {
	return createthirdpartyBTN;
}
public void EntertheMandatoryFieldThirdParty( String thirdParty, String customer)
{
	thirdpartyNameTF.sendKeys(thirdParty+Keys.ENTER);
	customerDD.click();
	customerDDTF.sendKeys(customer+Keys.ENTER);
	createthirdpartyBTN.click();
}

}
