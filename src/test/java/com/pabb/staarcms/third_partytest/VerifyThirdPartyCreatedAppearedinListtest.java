package com.pabb.staarcms.third_partytest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.pabb.staarcms.generic.baseutility.BaseClass;
import com.pabb.staarcms.generic.objectrepository.CreateNewThirdPartyPage;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.objectrepository.ThirdParteisListPage;
import com.pabb.staarcms.generic.objectrepository.ThirdParty_contact_Page;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;

@Listeners(com.pabb.staarcms.generic.listenerutility.ListenerImpClass.class)
public class VerifyThirdPartyCreatedAppearedinListtest extends BaseClass {

	@Test(groups = { "smokeTest", "regressionTest" })
	public void verifyThirdPartyCreatedAppearedinListTest() throws InterruptedException, Throwable, IOException {
		/* get the data from excel */
		UtilityClassObject.getText().log(Status.INFO, " get data from excel ");
		String third_party = eu.getDataFromExcel("third_party", 1, 2) + ju.getRandomNumber();
		String customer = eu.getDataFromExcel("third_party", 1, 3);

		/* cliclk on third party major tab */
		UtilityClassObject.getText().log(Status.INFO, "click on third paty major tab");
		HomePage hp = new HomePage(driver);
		hp.getThird_partiesTab().click();

		/* click on new third party link */
		UtilityClassObject.getText().log(Status.INFO, "click on new thirdparty link");
		ThirdParty_contact_Page tplnp = new ThirdParty_contact_Page(driver);
		tplnp.getNewthirdpartylink().click();

		/**
		 * This method is used to enter the mandatory field like third party and
		 * customer
		 */
		UtilityClassObject.getText().log(Status.INFO, "enter the mandatory field of third party ");
		CreateNewThirdPartyPage cntpp = new CreateNewThirdPartyPage(driver);
		cntpp.EntertheMandatoryFieldThirdParty(third_party, customer);

		/* click on list link */
		UtilityClassObject.getText().log(Status.INFO, "click on list link");
		tplnp.getListLink().click();

		/* search third party in the third party search box */
		UtilityClassObject.getText().log(Status.INFO, "search third party in the third party search box");
		ThirdParteisListPage tplp = new ThirdParteisListPage(driver);
		tplp.getThirdPartiessearchBox().sendKeys(third_party + Keys.ENTER);

		/* verify expected result */
		UtilityClassObject.getText().log(Status.INFO, "verify expected");
		String actualresult = driver.findElement(By.xpath(
				"//a[@class=\"classfortooltip refurl valignmiddle\"]/ancestor::tr/descendant::a[text()='" + third_party + "']"))
				.getText();
		// String actualheadermsg = tplp.getThirdpartylistPageheaderTitle().getText();

		boolean data = actualresult.contains(third_party);
		Assert.assertEquals(data, true);

	}
}
