package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author bheem
 * contains business method third-party 
 */
public class CreateOrderPage {
	
	WebDriver driver;
	public CreateOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@title=\"Select a third party\"]")
	private WebElement thirdpartyDDForCreateOrder;
	
	@FindBy(xpath="//input[@id=\"liv_\"]")
	private WebElement dateCreateOrder;
	
	@FindBy(xpath="//span[@title=\"Select a third party\"]")
	private WebElement selectthirdpartyDD;
	
	@FindBy(xpath="//input[@class=\"select2-search__field\"]")
	private WebElement selectThirdpartyTF;

	@FindBy(xpath="//input[@value=\"Create draft\"]")
	private WebElement createDraftBTN;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSelectthirdpartyDDForCreateOrder() {
		return thirdpartyDDForCreateOrder;
	}

	public WebElement getCreateDraftBTN() {
		return createDraftBTN;
	}

	public WebElement getDateCreateOrder() {
		return dateCreateOrder;
	}

	public WebElement getSelectthirdpartyDD() {
		return selectthirdpartyDD;
	}

	public WebElement getSelectThirdpartyTF() {
		return selectThirdpartyTF;
	}
	/*
	 * this is a business method for enter details like third-party,date for create order and click on cratedraft bitton in create order page
	 */
	public void ThirdPartyWithDateForCreateOrder(String Third_Party, String Date_ForCreateOrder)
	{
		thirdpartyDDForCreateOrder.click();
		selectThirdpartyTF.sendKeys(Third_Party+Keys.ENTER);
		dateCreateOrder.sendKeys(Date_ForCreateOrder);
		createDraftBTN.click();
	}
	
	
}
