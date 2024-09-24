package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
  WebDriver driver;
  
  public CustomersPage(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  @FindBy(xpath="//div[@class=\"titre inline-block\"]")
  private WebElement customersPage;

public WebDriver getDriver() {
	return driver;
}
public WebElement getCustomersPage() {
	return customersPage;
}
  
}
