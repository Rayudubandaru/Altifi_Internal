package stepDefifinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageElements.LoginpageElements;
import pageElements.VerifySideMenuElements;

public class VerifySideMenus {
	LoginpageElements loginPage;
	VerifySideMenuElements sideMenu;
	
	WebDriver driver;
	
	@Given("user login to the application")
	public void user_login_to_the_application() throws Exception {
		driver=new ChromeDriver();
		driver.get("https://nimbusqa.northernarc.com:8443/altifi-internal/");
		driver.manage().window().maximize();
	    
	    loginPage=new LoginpageElements(driver);
	    loginPage.login_internal_withValidCredentials();
	    Thread.sleep(5000);
	}

	@When("Check the names of sidemenus and size")
	public void check_the_names_of_sidemenus_and_size() throws Exception {
		
		sideMenu=new VerifySideMenuElements(driver);
		List<String> names_sideMenu=sideMenu.getSidemenus();
		for (String text : names_sideMenu) {
			System.out.println(text);
		}
//		for(int i=0;i<names_sideMenu.size();i++) {
//			String names=names_sideMenu.get(i);
//			System.out.println(names);
//		}
//		System.out.println(names_sideMenu);
	}

}
