package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.pabb.staarcms.generic.webdriverutility.WebdriverUtility;
/*
 * @author bheem
 * contains getters method like getTypeDD,typeTF_Dropdown,getSetStatusToTF,getYesBtnForValidate,getYesBtnForSetAcceptedRefused
 * contains business method like enterProductDetail and ProposalLinkwithSetacceptedpupup
 * 
 */
public class CommercialPraposalLinkPage {
WebDriver driver;
 public CommercialPraposalLinkPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(xpath="//span[@role=\"presentation\"]/ancestor::span[@class=\"prod_entry_mode_free\"]/descendant::span[@dir=\"ltr\"]/span[@class=\"selection\"]")
 private WebElement typeDD;
 
 @FindBy(xpath="//textarea[@id=\"dp_desc\"]")
 private WebElement typeTextArea;
 
 @FindBy(xpath="//input[@id=\"price_ht\"]")
 private WebElement ProductNetPriceTF;
 
 @FindBy(xpath="//input[@id=\"remise_percent\"]")
 private WebElement ProductDiscountTF;
 
 @FindBy(xpath="//input[@id=\"addline\"]")
    private WebElement addBtn;
 
 @FindBy(xpath="//input[@aria-controls=\"select2-statut-results\"]")
 private WebElement setStatusToTF;
 
 @FindBy(linkText="VALIDATE")
 private WebElement validateBTN;
 
 @FindBy(xpath="//a[contains(text(),'Set accepted/refused')]")
 private WebElement setacceptedrefusedBT;
  
 @FindBy(xpath="//span[@id=\"select2-statut-container\"]")
 private WebElement setStatusToDD;
 
 @FindBy(xpath="//button[text()=\"Yes\"]")
 private WebElement yesBtnForSetAcceptedRefused;
 
 @FindBy(xpath="//div[@aria-describedby=\"dialog-confirm\"]/descendant::button[text()='Yes']")
 private WebElement yesBtnForValidate;
 
 @FindBy(xpath="//input[@class=\"select2-search__field\"]")
 private WebElement typeTF_Dropdown; 
 
 @FindBy(xpath="//span[@class=\"badge  badge-status0 badge-status\"]")
private WebElement  draft_Proposal;
 
 @FindBy(xpath="//span[text()='Not signed (closed)']")
 private WebElement not_shigned_headermsg;
 
public WebElement getNot_shigned_headermsg() {
	return not_shigned_headermsg;
}

public WebElement getTypeTF_Dropdown() {
	return typeTF_Dropdown;
}

public WebElement getDraft_Proposal() {
	return draft_Proposal;
}

public WebDriver getDriver() {
	return driver;
}

public WebElement getTypeTextArea() {
	return typeTextArea;
}

public WebElement getProductNetPriceTF() {
	return ProductNetPriceTF;
}

public WebElement getProductDiscountTF() {
	return ProductDiscountTF;
}

public WebElement getAddBtn() {
	return addBtn;
}

public WebElement getValidateBTN() {
	return validateBTN;
}

public WebElement getSetacceptedrefusedBT() {
	return setacceptedrefusedBT;
}

public WebElement getSetStatusToDD() {
	return setStatusToDD;
}

public WebElement getYesBtnForSetAcceptedRefused() {
	return yesBtnForSetAcceptedRefused;
}

public WebElement getYesBtnForValidate() {
	return yesBtnForValidate;
}

public void setStatusDropDown(String setstatus)
{
	Select s=new Select(setStatusToDD);
	s.selectByVisibleText(setstatus);
}

public void enterProductDetail(String type,String productName,String price,String discount)
{
	typeDD.click();
	typeTF_Dropdown.sendKeys(type+Keys.ENTER);
	typeTextArea.sendKeys(productName);
	ProductNetPriceTF.sendKeys(price);
	ProductDiscountTF.sendKeys(discount);
	addBtn.click();
	validateBTN.click();
	yesBtnForValidate.click();
}

public void ProposalLinkwithSetacceptedpopup(String setStatusTo)
{
	setacceptedrefusedBT.click();
	setStatusToDD.click();
	setStatusToTF.sendKeys(setStatusTo+Keys.ENTER);
	yesBtnForSetAcceptedRefused.click();	
}
public WebElement getTypeDD() {
	return typeDD;
}

public WebElement getTypeTF() {
	return typeTF_Dropdown;
}

public WebElement getSetStatusToTF() {
	return setStatusToTF;
}
 
}

