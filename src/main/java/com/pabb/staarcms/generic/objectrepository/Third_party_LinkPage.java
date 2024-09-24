package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Third_party_LinkPage {
	WebDriver driver;
  @FindBy(xpath="//div[@class=\"address inline-block\"]")
  private WebElement modified_address;
  
  public Third_party_LinkPage( WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }

public WebDriver getDriver() {
	return driver;
}

public WebElement getModified_address() {
	return modified_address;
}
}
