package com.pabb.staarcms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class emailPage {
	
	WebDriver driver;
	
	public emailPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmail_failed_text() {
		return email_failed_text;
	}

	@FindBy(xpath="//div[text()='Failed to send mail (sender=Varun Gowda <varungowda@gmail.com>, receiver=bheemappagorav94@gmail.com)']")
	private WebElement email_failed_text;
}
