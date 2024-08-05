package stepDefifinition;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageElements.LoginpageElements;
import pageElements.VerifyInstrumentTypesElements;

public class VerifyInstrumentTest {
	private WebDriver driver;
	LoginpageElements loginPage;
	LaunchTheApplication launchApp;
	VerifyInstrumentTypesElements instTypes;
	
	int size=0;
	 
	@Given("Launch the altifi internal screen")
	public void launch_the_altifi_internal_screen() throws Exception {
		driver=new ChromeDriver();
		driver.get("https://nimbusqa.northernarc.com:8443/altifi-internal/");
		driver.manage().window().maximize();
	    
	    loginPage=new LoginpageElements(driver);
	    loginPage.login_internal_withValidCredentials();
	   
	}

	@When("Verify the instruments types")
	public void verify_the_instruments_types() throws Exception {
		Thread.sleep(5000);
		instTypes=new VerifyInstrumentTypesElements(driver);
		List<String> typesOfInstr=instTypes.getAllTypes();
		for(int i=0;i<typesOfInstr.size();i++) {
			System.out.println(typesOfInstr.get(i));
		}
		System.out.println(typesOfInstr);
		size++;
	}

	@Then("Validate instrument name and count")
	public void validate_instrument_name_and_count() {
	    System.out.println(size);
	}
}
