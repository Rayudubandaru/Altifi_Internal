package pageElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyInstrumentTypesElements {
    WebDriver driver;

	@FindBy(xpath="//div[@class='flex-custom no-wrap mb-2']/ul/li")
	List<WebElement> instrument_types;
	
	public VerifyInstrumentTypesElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getInstrumentTypes() {
		return instrument_types;
		
	}
	
	public List<String> getAllTypes() {
		List<String> text=new ArrayList<>();
		for (WebElement instrumentNames : instrument_types) {
			text.add(instrumentNames.getText());
		}
		return text;
	}
}
