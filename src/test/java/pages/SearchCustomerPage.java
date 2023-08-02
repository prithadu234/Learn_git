package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	public WebDriver driver;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "SearchEmail")
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "search-customers")
	WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH, using = "//i[not(contains(@class,'fa-dot-circle'))]//following-sibling::p[normalize-space()='Customers']")
	WebElement lnkCustomers_Menu;

	@FindBy(how = How.XPATH, using = "//i[contains(@class,'fa-dot-circle')]//following-sibling::p[normalize-space()='Customers']")
	WebElement lnkCustomers_Menuitem;

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
	}

	public void clickSearch() {
		btnSearch.click();

	}

	public int getNoOfRows() {
		return (tableRows.size());
		
	}

	public void clickCustomerMenu() {
		lnkCustomers_Menu.click();

	}
	
	public void clickCustomerMenuItem() {
		lnkCustomers_Menuitem.click();

	}

	public boolean searchCustomerByEmail(String email) {		
		boolean flag = false;
		for (int i = 1; i <= getNoOfRows(); i++) {
			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]")).getText();
			if (emailId.equalsIgnoreCase(email)) {
				flag = true;
				break;
			}
		}

		return flag;

	}

}
