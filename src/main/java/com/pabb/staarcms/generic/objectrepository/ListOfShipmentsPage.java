package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfShipmentsPage {
public WebDriver driver;
  
public ListOfShipmentsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[text()='List']")
private WebElement listLink;

@FindBy(xpath="//input[@name=\"search_ref_exp\"]")
private WebElement refnumberofCustomerTF;

@FindBy(xpath="//a[@class=\"classfortooltip\"]")
private WebElement refnumberOfcustomer;

public WebElement getSendEmailButtonInTheEmailArea() {
	return SendEmailButtonInTheEmailArea;
}
@FindBy(xpath="//span[@title=\"SetSendingMethod\"]")
private WebElement editIconOfShippingMethod;

@FindBy(xpath="//span[@id=\"select2-shipping_method_id-container\"]")
private WebElement ShippingMethodTF;

public WebElement getShippingMethodSelectTF() {
	return ShippingMethodSelectTF;
}
@FindBy(xpath="//input[@aria-autocomplete=\"list\"]")
private WebElement ShippingMethodSelectTF;

@FindBy(xpath="//input[@class=\"button button-edit smallpaddingimp\"]")
private WebElement modifyBTN;

@FindBy(xpath="//a[text()='Send email']")
private WebElement sendEmailBTN;

@FindBy(xpath="//input[@value=\"Send email\"]")
private WebElement SendEmailButtonInTheEmailArea;

@FindBy(xpath="//div[@class=\"titre inline-block\"]")
private WebElement SendEmailheadermsg;

@FindBy(xpath="//input[@id=\"sendto\"]")
private WebElement sendTOTF;

public WebElement getSendTOTF() {
	return sendTOTF;
}

public WebDriver getDriver() {
	return driver;
}

public WebElement getListLink() {
	return listLink;
}

public WebElement getRefnumberofCustomerTF() {
	return refnumberofCustomerTF;
}

public WebElement getRefnumberOfcustomer() {
	return refnumberOfcustomer;
}

public WebElement getEditIconOfShippingMethod() {
	return editIconOfShippingMethod;
}

public WebElement getShippingMethodTF() {
	return ShippingMethodTF;
}

public WebElement getModifyBTN() {
	return modifyBTN;
}

public WebElement getSendEmailBTN() {
	return sendEmailBTN;
}

public WebElement getSendEmail2() {
	return SendEmailButtonInTheEmailArea;
}

public WebElement getSendEmailheadermsg() {
	return SendEmailheadermsg;
}
public void clickOnRefNumber(String ref_number)
{
	listLink.click();
	refnumberofCustomerTF.sendKeys(ref_number+Keys.ENTER);
	refnumberOfcustomer.click();
}
public void modifyShippingMethod(String shipping_method)
{
	editIconOfShippingMethod.click();
	ShippingMethodTF.click();
	ShippingMethodSelectTF.sendKeys(shipping_method);
	modifyBTN.click();
	sendEmailBTN.click();
}
public void sendemailToCustomer(String email)
{
	sendTOTF.sendKeys(email);
	SendEmailButtonInTheEmailArea.click();	
}
}
