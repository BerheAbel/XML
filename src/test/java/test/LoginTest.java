package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	WebDriver driver;
	
	
	String userName  ;
	String password ;
	
	@Test
	@Parameters({"userName","passWord"})
	public void validUserShouldBeAbleToLogin(String username, String password) {
		
		driver = BrowserFactory.init();
				//object variable
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); 
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		
		//BrowserFactory.tearDown();
		
	}

}
