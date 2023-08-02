package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchCustomerPage;
import utility.Data;
import utility.ReadConfig;
import utility.ScreenshotHelper;
//import utility.Reusable;



public class SearchCustomer extends BaseTest {
	
	//@Test(dataProvider = "smokeTestData", dataProviderClass = Data.class)
	@Test(dataProvider = "smokeTestData")
	
	public void searchCustomerbyEmail(String url, String username, String password, String customerEmail1, String customerEmail2) throws Exception {
		ReadConfig conf = new ReadConfig();
		System.err.println(conf.getApp());
		lp = new LoginPage(driver);
		searchCust = new SearchCustomerPage(driver);
		logger.info("************* Taking Screenshot *****************");
		ScreenshotHelper sch = new ScreenshotHelper();
		sch.getScreenshot(driver,"customerSearchEmail");
		
		logger.info("************* Launching Browser *****************");
		logger.info("************* Opeining URL *****************");
		//driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.get(conf.getApp()); 
		//logger.info("************* Entering username *****************");
		lp.enterUserName(conf.getUserName());
		logger.info("************* Entering password *****************");
		lp.enterPassword(conf.getPassword());
		lp.clickLogin();
		logger.info("************* Login successful *****************");
		searchCust.clickCustomerMenu();
		Thread.sleep(3000);
		searchCust.clickCustomerMenuItem();
		logger.info("************* Entering email to search *****************");
		searchCust.setEmail(customerEmail1);
		searchCust.clickSearch();
		Thread.sleep(3000);
		logger.info("************* Search result received *****************");
		boolean status=searchCust.searchCustomerByEmail(customerEmail2);
		Assert.assertEquals(true, status);
		logger.info("************* Search successful *****************");
		//reuse.getScreenshot("test");
		sch.getScreenshot(driver,"customerSearchSuccessful");
		logger.info("************* Screenshot captured *****************");
		lp.clickLogout();
		//logger.info("************* Logout successful *****************");

	}


	@DataProvider
	public static Object[][] smokeTestData() {
		
		
		Object [][] data = { {"a","admin@yourstore.com", "admin","admin@yourstore.com","admin@yourstore.com"} };
		
		return data;
		
	}

}
