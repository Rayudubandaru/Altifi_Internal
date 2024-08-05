package stepDefifinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageElements.LoginpageElements;

public class LaunchTheApplication {
	
	public WebDriver driver;
	LoginpageElements loginPage;
	

	@Given("Launch the browser and open application")
	public void launch_the_browser_and_open_application() {
	    driver=new ChromeDriver();
	    driver.get("https://nimbusqa.northernarc.com:8443/altifi-internal");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("valid url and password")
	public void valid_url_and_password() throws InterruptedException {
		loginPage=new LoginpageElements(driver);
		loginPage.login_internal_withValidCredentials();
		
	   
	}

	@Then("click on login button and validate logout ensure we are in")
	public void click_on_login_button_and_validate_logout_ensure_we_are_in() {
	   String text_WelCome= loginPage.verify_welcome_text();
	   Assert.assertEquals(text_WelCome, "Welcome Subbarayudu");
	}
}
