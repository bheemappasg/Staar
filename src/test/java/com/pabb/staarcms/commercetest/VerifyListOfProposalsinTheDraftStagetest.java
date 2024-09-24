package com.pabb.staarcms.commercetest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.pabb.staarcms.generic.baseutility.BaseClass;
import com.pabb.staarcms.generic.objectrepository.CommerceAreaPage;
import com.pabb.staarcms.generic.objectrepository.CommercialPraposalLinkPage;
import com.pabb.staarcms.generic.objectrepository.CommercialProposalPage;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;

/**
 * @author bheema using this class verify list of proposal in the draft
 * 
 */

@Listeners(com.pabb.staarcms.generic.listenerutility.ListenerImpClass.class)
public class VerifyListOfProposalsinTheDraftStagetest extends BaseClass {
	@Test(groups = { "smokeTest", "regressionTest" })
	public void verifyListOfProposalsinTheDraftStageTest() {
		/* click on commerce tab */
		UtilityClassObject.getText().log(Status.INFO, "click on commerce tab");
		HomePage hp = new HomePage(driver);
		hp.getCommerceTab().click();

		/* click on the list of commercial proposal */
		UtilityClassObject.getText().log(Status.INFO, "click on list of commrcial tab");
		CommerceAreaPage cap = new CommerceAreaPage(driver);
		cap.getListLinkOf_Commercial_Proposal().click();

		/**
		 * This business method used for click on draft and click on the ref.id of list
		 * of proposal
		 */
		UtilityClassObject.getText().log(Status.INFO, "click on the list of the proposal in the draft");
		CommercialProposalPage cpp = new CommercialProposalPage(driver);
		cpp.ListOfProposalInTheDraft();

		/* verify expected result */
		UtilityClassObject.getText().log(Status.INFO, "verify expected result");
		CommercialPraposalLinkPage cplp = new CommercialPraposalLinkPage(driver);
		boolean actual_draft = cplp.getDraft_Proposal().isDisplayed();
		Assert.assertTrue(actual_draft);
	}

}
