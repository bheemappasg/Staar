package com.pabb.staarcms.commercetest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.generic.baseutility.BaseClass;
import com.pabb.staarcms.generic.objectrepository.CommerceAreaPage;
import com.pabb.staarcms.generic.objectrepository.CommercialPraposalLinkPage;
import com.pabb.staarcms.generic.objectrepository.CreateNewThirdPartyPage;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.objectrepository.ThirdParty_contact_Page;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;
/**
 * @author bheem
 * this class is used to create a proposal and reject proposal
 */
@Listeners(com.pabb.staarcms.generic.listenerutility.ListenerImpClass.class)
public class CreateProposalAndRejecttest extends BaseClass {

	@Test(groups = {"smokeTest" , "regressionTest"})
	public void CreateProposal() throws InterruptedException, EncryptedDocumentException, IOException {
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
		
		/* get the data from excel   */
		UtilityClassObject.getText().log(Status.INFO, "Read data from Excel");
		//String third_party = eu.getDataFromExcel("third_party", 1, 2);//+ju.getRandomNumber();
		String DateofProposal = eu.getDataFromExcel("third_party", 4, 2);
		String validity_duration = eu.getDataFromExcel("third_party", 4, 3).toString();
		String type = eu.getDataFromExcel("third_party", 4, 4);
		String typeproduct = eu.getDataFromExcel("third_party", 4, 5);
		String price = eu.getDataFromExcel("third_party", 4, 6);
		String discount = eu.getDataFromExcel("third_party", 4, 7);
		String setstatusto = eu.getDataFromExcel("third_party", 4, 8);
		
		/* click on commerce major tab   */
		UtilityClassObject.getText().log(Status.INFO, "click on commerce tab");
		HomePage hp1 = new HomePage(driver);
		hp1.getCommerceTab().click();
		
		/* click on new commercial proposal link */
		UtilityClassObject.getText().log(Status.INFO, "click on new proposal link");
		CommerceAreaPage cap = new CommerceAreaPage(driver);
		cap.getNewproposalLink().click();
		
		/* enter required detail in the commerce area page here we using business method */
		UtilityClassObject.getText().log(Status.INFO, "handling commerce details page ");
        cap.newCommercialProposalDetailField(third_party, DateofProposal, validity_duration);
		cap.getCreatedraftBTN().click();

		/* here first select type drop down like product and add product with price,discount then click on add button */
		UtilityClassObject.getText().log(Status.INFO, " enter all the details of product ");
		CommercialPraposalLinkPage  cplp = new CommercialPraposalLinkPage(driver);
		cplp.enterProductDetail(type, typeproduct, price, discount);   
		
		/* here we clicking on set accepted button */
		UtilityClassObject.getText().log(Status.INFO, "click on the setaccepted/rejected btn and change status as not signed");
		cplp.ProposalLinkwithSetacceptedpopup(setstatusto);
		
		/* verify Expected result */
		UtilityClassObject.getText().log(Status.INFO, "verify expected result");
		boolean actualresult = cplp.getNot_shigned_headermsg().isDisplayed();
        Assert.assertTrue(actualresult);
	}

}
