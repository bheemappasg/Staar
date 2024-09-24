package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author bheem
 * 
 * contains getters methods like third-party drop down,third-party text field,date of proposal,validity duration,create draft button,sales order link,new proposal link,list of link commercial proposal and
 * 
 */
public class CommerceAreaPage {
WebDriver driver;
public CommerceAreaPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "New proposal")
private WebElement newproposalLink;

@FindBy(xpath="//a[@href=\"/dolibarr/comm/propal/list.php?leftmenu=propals\"]")
private WebElement listLinkOf_Commercial_Proposal;

public WebElement getListLinkOf_Commercial_Proposal() {
	return listLinkOf_Commercial_Proposal;
}
@FindBy(xpath="//span[@title=\"Select a third party\"]")
private WebElement selectthirdpartyDD;

@FindBy(xpath="//input[@value=\"Create draft\"]")
private WebElement createdraftBTN;
 
@FindBy(xpath="//a[text()='New order']")
private WebElement salesOrderLink;

@FindBy(xpath="//input[@id=\"re\"]")
private WebElement dateofProposalTF;

@FindBy(xpath="//input[@name ='duree_validite']")
private WebElement validityDurationTF;

@FindBy(xpath="//input[@class=\"select2-search__field\"]")
private WebElement selectThirdpartyTF;

public WebDriver getDriver() {
	return driver;
}
  
public WebElement getNewproposalLink() {
	return newproposalLink;
}

public WebElement getSelectthirdpartyDD() {
	return selectthirdpartyDD;
}

public WebElement getCreatedraftBTN() {
	return createdraftBTN;
}

public WebElement getSalesOrderLink() {
	return salesOrderLink;
}

public WebElement getDateofProposalTF() {
	return dateofProposalTF;
}

public WebElement getValidityDurationTF() {
	return validityDurationTF;
	
}

public WebElement getSelectThirdpartyTF() {
	return selectThirdpartyTF;
}
	public void newCommercialProposalDetailField(String thirdparty, String date_proposal, String days)
	{
		selectthirdpartyDD.click();
		selectThirdpartyTF.sendKeys(thirdparty+Keys.ENTER);
		dateofProposalTF.sendKeys(date_proposal);
		validityDurationTF.clear();
		validityDurationTF.sendKeys(days);
		createdraftBTN.click();
	}
}



