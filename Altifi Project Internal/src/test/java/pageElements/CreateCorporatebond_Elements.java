package pageElements;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCorporatebond_Elements {
	
	WebDriver driver;
	
	public CreateCorporatebond_Elements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@class='btn-btn-primary float-right']")
	WebElement button_Create_Instrument;
	
	@FindBy(xpath="//label[@for='fileupload']")
	WebElement chooseFile_label;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement closeIcon_internal;
	
	@FindBy(xpath="//button[@id='createInstrument_primary']")
	WebElement button_save;
	
	@FindBy(xpath="//table[@class='table body-table']//tr//td[@class='cw-200 word-break']")
	List<WebElement> instrumentNames;
	
	public void create_Instrument() {
		closeIcon_internal.click();
		button_Create_Instrument.click();
	}
	
	public void button_chooseFile() throws InterruptedException, Exception {
		
		chooseFile_label.click();
		
		Robot robo=new Robot();
		robo.delay(2000);
		
		StringSelection ss=new StringSelection("C:\\Users\\C.Subbarayudu\\Downloads\\Instrument_Upload_Template (8).xlsx");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.delay(2000);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.delay(2000);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
				
	}
	
	public void saveTheSheet() {
		button_save.click();
	}
	
	public List<WebElement> storeElements() {
		return instrumentNames;
	}
	
	public List<String> getElements_text() {
		List<String> inst_names=new ArrayList<>();
		for (WebElement instruments : instrumentNames) {
			inst_names.add(instruments.getText());
		}
		
		return inst_names;
	}
}
