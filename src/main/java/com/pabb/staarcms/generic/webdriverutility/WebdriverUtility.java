package com.pabb.staarcms.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	public void waitforpageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void WaitForElementPrasent(WebDriver driver,WebElement elements)
	{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(elements));
	}
//	public void WaitForTitle(WebDriver driver,String title)
//	{
//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.titleIs(title);
//	}
	public void switchTabonUrl(WebDriver driver,String partialUrl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
		String windowid = it.next();
		driver.switchTo().window(windowid);
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains(partialUrl))
		{
			break;
		}
		
		}}
		public void switchTabonTitle(WebDriver driver,String partialTitle)
		{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext())
			{
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String actUrl = driver.getTitle();
			if(actUrl.contains(partialTitle))
			{
				break;
			}
			}}
			 public void switchtoFrame(WebDriver driver,int index)
			 {
					driver.switchTo().frame(index);
			 }
			 public void switchtoFrame(WebDriver driver, String id)
			 {
					driver.switchTo().frame(id);
			 }
			 public void switchtoFrame(WebDriver driver,WebElement element)
			 {
					driver.switchTo().frame(element);
			 }
			 public void SwitchtoAlertandAccept(WebDriver driver)
			 {
				 driver.switchTo().alert().accept();
			 }
			 public void SwitchtoAlertandCancel(WebDriver driver)
			 {
				 driver.switchTo().alert().dismiss();
			 }
			 public void selectByVisibleText(WebElement element,String text)
			 {
				 Select sel= new Select(element);
				 sel.selectByVisibleText(text);
			 }
			 public void selectByindex(WebElement element,int i)
			 {
				 Select sel=new Select(element);
				 sel.selectByIndex(i);
			 }
			 public void selectByOption(WebElement element)
			 {
				Select sel=new Select(element) ;
				sel.getOptions();
			 }
			 public void mouseMoveonElement(WebDriver driver,WebElement element) {
				 Actions act=new Actions(driver);
						 act.moveToElement(element).perform();
			 }
			 public void Rightclick(WebDriver driver,WebElement element) 
			 {
				 Actions act=new Actions(driver);
				 act.contextClick(element).perform();
				 
			 }
			 public void doubleClick(WebDriver driver,WebElement element) 
			 {
				 Actions act=new Actions(driver);
				 act.doubleClick(element).perform();
				 
			 }
			 public void dragAndDrop(WebDriver driver,WebElement source,WebElement target) 
			 {
				 Actions act=new Actions(driver);
				 act.dragAndDrop(source,target).perform();
				 
			 }
				 
			 }
			 
			
	


