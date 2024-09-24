package com.pabb.staarcms.generic.baseutility;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.pabb.staarcms.generic.fileutility.ExcelUtility;
import com.pabb.staarcms.generic.fileutility.FileUtility;
import com.pabb.staarcms.generic.objectrepository.HomePage;
import com.pabb.staarcms.generic.objectrepository.LoginPage;
import com.pabb.staarcms.generic.webdriverutility.JavaUtility;
import com.pabb.staarcms.generic.webdriverutility.UtilityClassObject;
import com.pabb.staarcms.generic.webdriverutility.WebdriverUtility;
/**
 *@author bheema 
 * this base class contains all the configuration method
 * 
 */
public class BaseClass {
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public WebdriverUtility wu = new WebdriverUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriver driver;
	static public WebDriver sdriver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() throws SQLException {
		System.out.println("===connect to db===");
	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC(/*String BROWSER*/) throws IOException {
		System.out.println("===open browser===");
		String BROWSER = fu.getDataFromProperties("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		sdriver = driver;
		UtilityClassObject.setDriver(sdriver);

		String URL = fu.getDataFromProperties("url");
		driver.get(URL);
		wu.waitforpageLoad(driver);
		driver.manage().window().maximize();
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws IOException {
		System.out.println("===login===");
		String URL = fu.getDataFromProperties("url");
		String USERNAME = fu.getDataFromProperties("username");
		String PASSWORD = fu.getDataFromProperties("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() throws InterruptedException {
		System.out.println("===logout===");
		HomePage hp = new HomePage(driver);
		hp.clickonLogout();  
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("===close thee browser==");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("===close db , Report backup===");

	}

}
