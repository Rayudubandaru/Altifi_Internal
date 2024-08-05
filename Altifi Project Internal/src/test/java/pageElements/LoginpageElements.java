package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageElements {
      WebDriver driver;
	
	@FindBy(name="UserName") WebElement userName_LoginPgae;
	@FindBy(name="Password") WebElement password_LoginPage;
	@FindBy(id="submitButton") WebElement siginIn_Button_LoginPage;
	@FindBy(xpath="//div[contains(text(),'Welcome Subbarayudu')]")
	WebElement text_welcome_internals;
	
	public LoginpageElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login_internal_withValidCredentials() throws InterruptedException {
		userName_LoginPgae.sendKeys("C.Subbarayudu@Northernarc.com");
		password_LoginPage.sendKeys("Rayudu@1988");
		siginIn_Button_LoginPage.click();
	}
	
	public String verify_welcome_text() {
		return text_welcome_internals.getText();
	}
}
