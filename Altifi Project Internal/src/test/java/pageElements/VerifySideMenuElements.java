package pageElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifySideMenuElements {
	
	WebDriver driver;
	@FindBy(xpath="//div[@class='single-info']//p")
	List<WebElement> sidmenus_internal;
	
	public VerifySideMenuElements(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getElements() {
		return sidmenus_internal;
	}
	
	public List<String> getSidemenus() {
		List<String> listOfsidemenus=new ArrayList<>();
		for (WebElement list : sidmenus_internal) {
			listOfsidemenus.add(list.getText());
		}
		return listOfsidemenus;
	}

}
