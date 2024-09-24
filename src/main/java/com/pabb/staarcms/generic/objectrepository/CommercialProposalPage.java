package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercialProposalPage {
WebDriver driver;
public CommercialProposalPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//div[@class=\"blockvmenu blockvmenupair blockvmenufirst\"]/descendant::div[5]/a")
 private WebElement draft_link_Commercial_Praposal;

@FindBy(xpath="//tr[@class=\"liste_titre\"]/following-sibling::tr[1]/descendant::a[1]")
private WebElement ref_Id_Propasal;

public WebDriver getDriver() {
	return driver;
}

public WebElement getDraft_link_Commercial_Praposal() {
	return draft_link_Commercial_Praposal;
}

public WebElement getRef_Id_Propasal() {
	return ref_Id_Propasal;
}
/* this business method used for clicking on the draft link and clicking on the ref id of proposal  */
public void  ListOfProposalInTheDraft()
{
	draft_link_Commercial_Praposal.click();
	ref_Id_Propasal.click();
}
}
