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
import com.pabb.staarcms.generic.objectrepository.CreateNewThirdPartyPage;
import com.pabb.staarcms.generic.objectrepository.CreateOrderPage;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.objectrepository.SalesOrderLinkPage;
import com.pabb.staarcms.generic.objectrepository.ThirdParty_contact_Page;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;
/**
 * 
 * @author bheem
 * this class is used to create a sales order 
 */
@Listeners(com.pabb.staarcms.generic.listenerutility.ListenerImpClass.class)
public class CreateSalesOrdertest extends BaseClass {
	@Test(groups = {"smokeTest" , "regressionTest"})
	public void CreateSalesOrderAndValidate() throws InterruptedException, EncryptedDocumentException, IOException {
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
		
		
		/* get the data from excel */
		UtilityClassObject.getText().log(Status.INFO, "Read data from Excel");
		//String third_party = eu.getDataFromExcel("third_party", 1, 2);//+ju.getRandomNumber();
		String date_createOder = eu.getDataFromExcel("third_party", 4, 2);
		String type = eu.getDataFromExcel("third_party", 4, 4);
		String enter_products = eu.getDataFromExcel("third_party", 4, 5);
		String product_netprice = eu.getDataFromExcel("third_party", 4, 6);
		String product_discount = eu.getDataFromExcel("third_party", 4, 7);
		String expected = eu.getDataFromExcel("third_party", 4, 9);
		
        /* click on commerce major Tab */
		UtilityClassObject.getText().log(Status.INFO, "click on commerce Tab");
		HomePage hp1 = new HomePage(driver);
		hp1.getCommerceTab().click();

		/* click on salesoderlink  */
		UtilityClassObject.getText().log(Status.INFO, "click on sales order link");
		CommerceAreaPage cap = new CommerceAreaPage(driver);
		cap.getSalesOrderLink().click();

		/* enter the third party with date of order and click on create draft button  */
		UtilityClassObject.getText().log(Status.INFO, "here we enter third party with date of order ");
		CreateOrderPage cop = new CreateOrderPage(driver);
		cop.ThirdPartyWithDateForCreateOrder(third_party, date_createOder);

		/* enter product details in the sales order page click on   */
		UtilityClassObject.getText().log(Status.INFO, "this method is handle product details ");
		SalesOrderLinkPage solp = new SalesOrderLinkPage(driver);
		solp.addProductCreateOrder(type, enter_products, product_netprice, product_discount);
     
		/* verify expected result  */
		//String expectedstatus = "Validated";
		UtilityClassObject.getText().log(Status.INFO, " verify expected result");
		String actualstatus = solp.getValidatedHeadermsg().getText();
		boolean status = actualstatus.equals(expected);
		Assert.assertEquals(status, true);

	}
}
