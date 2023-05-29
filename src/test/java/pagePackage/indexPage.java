package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	@FindBy(linkText = "EO/EI लॉगइन") private WebElement EOLogin;
	@FindBy(partialLinkText = "शाळा लॉग इन") private WebElement schoolLogin;
	@FindBy(partialLinkText = " शाळा नोंदणी") private WebElement schoolRegistration;
	
	//---------------------------------------------------------------------------
	public indexPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	//------------------------------------------------------------------------
	
	public WebElement getEOLogin() {
		return EOLogin;
	}

	public WebElement getSchoolLogin() {
		return schoolLogin;
	}

	public WebElement getSchoolRegistration() {
		return schoolRegistration;
	}
	

	
	//-----------------------------------------------------------------------------
	

}
