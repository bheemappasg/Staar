package com.pabb.staarcms.third_partytest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.generic.baseutility.BaseClass;
import com.pabb.staarcms.generic.objectrepository.CreateNewThirdPartyPage;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.objectrepository.ThirdParty_contact_Page;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;

@Listeners(com.pabb.staarcms.generic.listenerutility.ListenerImpClass.class)
public class CreateaThirdPartyasCustomerWithMandatoryFieldstest extends BaseClass {
	
	@Test(groups = {"smokeTest" , "regressionTest"})
	public void CreateaThirdPartyasCustomerwithMandatoryFields() throws Throwable, IOException {
		/* get the data from excel */
		UtilityClassObject.getText().log(Status.INFO, "Read data from Excel");
		String third_party = eu.getDataFromExcel("third_party", 1, 2)+ju.getRandomNumber();
		String customer = eu.getDataFromExcel("third_party", 1, 3);

		/* click on third party tab */
		UtilityClassObject.getText().log(Status.INFO, " click on the third party major tab");
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
	}
}
