package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	
	WebDriver driver;
	
	
	String username;
	String password;
	String fullName;
	String company;
	String eamil;
	String phone;
	String address;
	String city;
	String state;
	String zip;
	String country;
	
	@Test
	@Parameters({"userName","passWord","fullName","CompanyName","email","Phone","Address","City","Country","State","Zip"})
	public void validUserShouldBeAbleToAddCustomer(String username,String password,String fullName,String company,String eamil,String phone,String address,String city,String country,String state,String zip) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); 
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage =  PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertCompanyName(company);
		addCustomerPage.insertEmail(eamil);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.insertCountry(country);
		addCustomerPage.clickSubmitButton();
		dashboardPage.clickListCustomerButton();
		addCustomerPage.verifyEnteredName();
		
		
		
	}

}
