package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	@FindBy(linkText = "NMMS (2021-22)") private WebElement NMMS2021_22;
	@FindBy(linkText = "NMMS (2022-23)") private WebElement NMMS2022_23;
	
	//--------------------------------------------------------------------
	
	public landingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//----------------------------------------------------------------------
	
	
	public WebElement getNMMS2021_22() {
		return NMMS2021_22;
	}
	public WebElement getNMMS2022_23() {
		return NMMS2022_23;
	}
	
	
	
	//----------------------------------------------------------------------
	

}
