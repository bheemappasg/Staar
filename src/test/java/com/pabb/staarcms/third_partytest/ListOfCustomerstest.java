package com.pabb.staarcms.third_partytest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.generic.baseutility.BaseClass;
import com.pabb.staarcms.generic.objectrepository.CustomersPage;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.objectrepository.ThirdParty_contact_Page;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;

@Listeners(com.pabb.staarcms.generic.listenerutility.ListenerImpClass.class)
public class ListOfCustomerstest extends BaseClass {
	
	@Test(groups = {"smokeTest" , "regressionTest"})
	public void ListOfCustomer()
	{
		
		/* click on third_party tab */
		UtilityClassObject.getText().log(Status.INFO, "click on the third party tab");
		HomePage hp=new HomePage(driver);
		hp.getThird_partiesTab().click();
		
		/* click on the listOfCustomerLink  */
		UtilityClassObject.getText().log(Status.INFO, "click on list of customerLink");
		ThirdParty_contact_Page tplp=new ThirdParty_contact_Page(driver);
		tplp.getListofCustomerLink().click();
		
		/* verify expected result */
		UtilityClassObject.getText().log(Status.INFO, "verify expected result");
		CustomersPage cp=new CustomersPage(driver);
	
	 boolean actualcust = cp.getCustomersPage().isDisplayed();
		
		Assert.assertTrue(actualcust);
	}

}
