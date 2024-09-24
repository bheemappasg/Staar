package com.pabb.staarcms.third_partytest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.generic.baseutility.BaseClass;
import com.pabb.staarcms.generic.objectrepository.CreateNewThirdPartyPage;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.objectrepository.ThirdParteisListPage;
import com.pabb.staarcms.generic.objectrepository.ThirdParty_contact_Page;
import com.pabb.staarcms.generic.objectrepository.Third_party_LinkPage;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;

@Listeners(com.pabb.staarcms.generic.listenerutility.ListenerImpClass.class)
public class ModifyThirdPartytest extends BaseClass {

	@Test(groups = {"smokeTest" , "regressionTest"})
	public void modifyThirdParty() throws InterruptedException, EncryptedDocumentException, IOException
	{
		UtilityClassObject.getText().log(Status.INFO, "Read data from Excel");
		String third_party = eu.getDataFromExcel("third_party", 1, 2)+ju.getRandomNumber();
		String customer = eu.getDataFromExcel("third_party", 1, 3);

		/* click on third party tab */
		UtilityClassObject.getText().log(Status.INFO, " click on the third party tab");
		HomePage hp = new HomePage(driver);
		hp.getThird_partiesTab().click();

		/* click on the new third party link */
		UtilityClassObject.getText().log(Status.INFO, " click on the third party link ");
		ThirdParty_contact_Page tplp = new ThirdParty_contact_Page(driver);
		tplp.getThirdpartylink().click();

		/* enter the required details in the third_party details page */
		UtilityClassObject.getText().log(Status.INFO, "using this method enter the third paty and select customer");
		CreateNewThirdPartyPage cntpg = new CreateNewThirdPartyPage(driver);
		cntpg.EntertheMandatoryFieldThirdParty(third_party, customer);

		/* verify expected result */
		UtilityClassObject.getText().log(Status.INFO, "verify expected result");
		String atualresult = driver.findElement(By.xpath("//div[@style=\"vertical-align: middle\"]/descendant::div[text()='" + third_party + "']")).getText();
		boolean data = atualresult.contains(third_party);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(true, data);
		sa.assertAll();
		/* get the data from excel */
		//String third_party = eu.getDataFromExcel("third_party", 1, 2)+ju.getRandomNumber();
		UtilityClassObject.getText().log(Status.INFO, "get the data from excel");
		String Expected_address = eu.getDataFromExcel("third_party", 10, 2);
		
		/* navigate through thirdParty majorTab */
		UtilityClassObject.getText().log(Status.INFO, "click on the party tab");
		HomePage hp1=new HomePage(driver);
		hp1.getThird_partiesTab().click();
		
		/*modify third party address  */
		UtilityClassObject.getText().log(Status.INFO, "modify third party address");
		ThirdParteisListPage tplp1=new ThirdParteisListPage(driver);
		tplp1.modifyAddressOfThirdParty(third_party, Expected_address);
		
		/*verify expected result */
	
		Third_party_LinkPage tpl=new Third_party_LinkPage(driver);
		String actualaddress = tpl.getModified_address().getText();
		boolean data1 = actualaddress.contains(Expected_address);
		
		UtilityClassObject.getText().log(Status.INFO, "verify expected result");
		SoftAssert sa1=new SoftAssert();
		sa1.assertEquals(true, data);
		sa1.assertAll();		
	}
}
