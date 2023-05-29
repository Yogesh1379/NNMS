package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class schoolSideHomePage {
	@FindBy(xpath = "//span[@class='fa fa-bars']") private WebElement profileMenu;
	@FindBy(xpath = "//a[.='School Profile']") private WebElement schoolProfile;
	@FindBy(xpath = "//a[.='Change Password']") private WebElement changePass;
	@FindBy(xpath = "//a[.='Logout']") private WebElement logout;
	//-------------------------------------------------------------------------
	
	public schoolSideHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//-------------------------------------------------------------------------
	public WebElement getProfileMenu() {
		return profileMenu;
	}
	
	public WebElement getSchoolProfile() {
		return schoolProfile;
	}
	public WebElement getChangePass() {
		return changePass;
	}
	public WebElement getLogout() {
		return logout;
	}
	
	//-----------------------------------------------------------------------------
	
}
