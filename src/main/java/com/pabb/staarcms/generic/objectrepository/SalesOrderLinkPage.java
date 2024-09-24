package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderLinkPage {
	WebDriver driver;
	 public SalesOrderLinkPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//span[@role=\"presentation\"]/ancestor::span[@class=\"prod_entry_mode_free\"]/descendant::span[@dir=\"ltr\"]/span[@class=\"selection\"]")
	 private WebElement typeDD;
	 
	 @FindBy(xpath="//textarea[@id=\"dp_desc\"]")
	 private WebElement typeTextArea;
	 
	 @FindBy(xpath="//span[text()='Validated']")
      private WebElement validatedHeadermsg;
      
	 public WebElement getValidatedHeadermsg() {
		return validatedHeadermsg;
	}
	@FindBy(xpath="//input[@id=\"price_ht\"]")
	 private WebElement ProductNetPriceTF;
	 
	 @FindBy(xpath="//input[@class=\"select2-search__field\"]")
	 private WebElement typeTFDD;
	 
	 @FindBy(xpath="//input[@id=\"remise_percent\"]")
	 private WebElement ProductDiscountTF;
	 
	 @FindBy(xpath="//input[@id=\"addline\"]")
	    private WebElement addBtn;
	 
	 @FindBy(linkText ="VALIDATE")
	 private WebElement validateBTN;
	 
	 @FindBy(xpath="//button[text()=\"Yes\"]")
	 private WebElement yesForValidate;
	public WebDriver getDriver() {
		return driver;
	}
     
	public WebElement getTypeDD() {
		return typeDD;
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

	public WebElement getYesForValidate() {
		return yesForValidate;
	}

	public WebElement getTypeTF() {
		return typeTFDD;
	}
	public void addProductCreateOrder(String type,String productsName,String netprice,String discount)
	{
		typeDD.click();
		typeTFDD.sendKeys(type+Keys.ENTER);
		typeTextArea.sendKeys(productsName);
		ProductNetPriceTF.sendKeys(netprice);
		ProductDiscountTF.sendKeys(discount);
		addBtn.click();
		validateBTN.click();
		yesForValidate.click();	
	}
}
