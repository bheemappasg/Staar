package com.pabb.staarcms.shipmentstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.generic.baseutility.BaseClass;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.objectrepository.ListOfShipmentsPage;
import com.pabb.staarcms.generic.objectrepository.emailPage;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;

@Listeners(com.pabb.staarcms.generic.listenerutility.ListenerImpClass.class)
public class Modifyshipmenttest extends BaseClass {
	
	@Test(groups = {"smokeTest" , "regressionTest"})
	public void ModifyShipment() throws InterruptedException, EncryptedDocumentException, IOException
	{
		/* get the data from excel*/
		UtilityClassObject.getText().log(Status.INFO, "click on list of commrcial tab");
		String shipping_method = eu.getDataFromExcel("third_party", 7, 2);
		String ref_number = eu.getDataFromExcel("third_party", 7, 3);
		String email = eu.getDataFromExcel("third_party", 7, 4);
		
		/* click on service major tab  */
		UtilityClassObject.getText().log(Status.INFO, "click on list of commrcial tab");
		HomePage hp=new HomePage(driver);
		hp.getServicesTab().click();
		
		/* clickOnRefNumber method is used to click on list and enter the ref number of customer into ref. test field and click on the ref number */
		UtilityClassObject.getText().log(Status.INFO, "click on list of commrcial tab");
		ListOfShipmentsPage losp=new ListOfShipmentsPage(driver);
		losp.clickOnRefNumber(ref_number);
		
       /*  using this modify shipping  */
		UtilityClassObject.getText().log(Status.INFO, "click on list of commrcial tab");
		losp.modifyShippingMethod(shipping_method);
		
		/* send mail to customer */
		UtilityClassObject.getText().log(Status.INFO, "click on list of commrcial tab");
		losp.sendemailToCustomer(email);
		
		/*verify expected result */
		UtilityClassObject.getText().log(Status.INFO, "click on list of commrcial tab");
		emailPage ep=new emailPage(driver);
		boolean failedresult = ep.getEmail_failed_text().isDisplayed();
		SoftAssert sa=new SoftAssert();
		sa.assertFalse(failedresult);
		sa.assertAll();
		//Assert.assertTrue(failedresult);
		
	}

}
