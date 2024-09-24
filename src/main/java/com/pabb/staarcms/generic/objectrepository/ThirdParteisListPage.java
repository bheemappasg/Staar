package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdParteisListPage {
	
	WebDriver driver;
	public ThirdParteisListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//textarea[@name=\"address\"]")
    private WebElement address_textArea;
	
	public WebElement getAddress_textArea() {
		return address_textArea;
	}
	@FindBy(linkText ="List")
	private WebElement  listLinkThirdParties;

	@FindBy(xpath="//div[@class=\"titre inline-block\"]")
	private WebElement thirdpartylistPageheaderTitle;
	
	public WebElement getThirdpartylistPageheaderTitle() {
		return thirdpartylistPageheaderTitle;
	}
	@FindBy(xpath="//input[@name=\"save\"]")
	private WebElement  saveBTNforThirdPartyModify;
	
	@FindBy(xpath="//input[@name=\"search_nom\"]")
	private WebElement  thirdPartiessearchBox;
	
	@FindBy(xpath="//td[@class=\"tdoverflowmax200\"]/ancestor::div[@class=\"div-table-responsive\"]/descendant::a[@href=\"/dolibarr/societe/card.php?socid=1516&save_lastsearch_values=1\"]")
	private WebElement searchedThirdParties;
	
	@FindBy(xpath="//a[@class=\"classfortooltip refurl valignmiddle\"]")
	private WebElement selectsearchedThirdParty;
	
	@FindBy(xpath="//a[@class=\"butAction\"]")
	private WebElement modifyThirdPartyBTN;
	
	@FindBy(xpath="//td[text()='Third-party type']/../descendant::span[text()='Large company']")
	private WebElement ThirdPartyTypeDD;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getListLinkThirdParties() {
		return listLinkThirdParties;
	}

	public WebElement getThirdPartiessearchBox() {
		return thirdPartiessearchBox;
	}

	public WebElement getSearchedThirParties() {
		return searchedThirdParties;
	}

	public WebElement getModifyThirdPartyBTN() {
		return modifyThirdPartyBTN;
	}

	public WebElement getThirdPartyTypeDD() {
		return ThirdPartyTypeDD;
	}

	public WebElement getSaveBTNforThirdPartyModify() {
		return saveBTNforThirdPartyModify;
	}

	public WebElement getSearchedThirdParties() {
		return searchedThirdParties;
	}

	public WebElement getSelectsearchedThirdParty() {
		return selectsearchedThirdParty;
	}
	public void modifyAddressOfThirdParty(String third_party,String address)
	{
		listLinkThirdParties.click();
		thirdPartiessearchBox.sendKeys(third_party+Keys.ENTER);
		selectsearchedThirdParty.click();
		modifyThirdPartyBTN.click();
		address_textArea.sendKeys(address);
		saveBTNforThirdPartyModify.click();
	}
}
