package utility;

import org.testng.annotations.DataProvider;

public class Data {

	@DataProvider
	public Object[][] smokeTestData() {

		Object[][] data = { { "https://admin-demo.nopcommerce.com/login", "admin@yourstore.com", "admin", 
			"victoria_victoria@nopCommerce.com", "victoria_victoria@nopCommerce.com" }};

		return data;

	}

}
