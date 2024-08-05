package stepDefifinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageElements.CreateCorporatebond_Elements;
import pageElements.LoginpageElements;

public class Create_corporate_bond {
	WebDriver driver;
	LoginpageElements loginPage;
	CreateCorporatebond_Elements corporate;

	@Given("Launch the application")
	public void launch_the_application() throws Exception {
		driver=new ChromeDriver();
		driver.get("https://nimbusqa.northernarc.com:8443/altifi-internal/");
		driver.manage().window().maximize();
		loginPage=new LoginpageElements(driver);
		loginPage.login_internal_withValidCredentials();
		Thread.sleep(5000);
	}

	@When("CLick on Create instrument button")
	public void c_lick_on_create_instrument_button() {
		corporate =new CreateCorporatebond_Elements(driver);
		corporate.create_Instrument();
	}

	@Then("Click on upload file button")
	public void click_on_upload_file_button() throws Exception {
		corporate.button_chooseFile();
		Thread.sleep(3000);
		corporate.saveTheSheet();
		driver.navigate().refresh();
		
	}
	
	@Then("validate instrument name in the list")
	public void validate_instrument_name_in_the_list() {
		List<String> instrument_names=corporate.getElements_text();
		for(int i=0;i<instrument_names.size();i++) {
			System.out.println(instrument_names.get(i));
			String NameInst=instrument_names.get(i);
			if(NameInst.contains("TestDemo928832")) {
				System.out.println("Instrument has been created");
			}
		}
	
	}

}
