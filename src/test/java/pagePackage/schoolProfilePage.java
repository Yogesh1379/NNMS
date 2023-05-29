package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class schoolProfilePage {
	@FindBy(xpath = "//select[@class='btn btn-secondary dropdown-toggle']") private WebElement MediumOfSchool;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlSchooltype']") private WebElement SchoolType;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlAreaLocated']") private WebElement SchoolArea;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlSyllabus']") private WebElement SchoolSyllabus;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSchoolEmail']") private WebElement SchoolEmailID;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtStdCode']") private WebElement STDCode;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTelephoneNo']") private WebElement SchoolTelephone;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPrincipalName']" ) private WebElement PrincipalName;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPrincipalMobNo']") private WebElement PrincipalMoNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtHeadEmail']") private WebElement PrincipalEmail;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAlternateContact']") private WebElement AlternateNumber;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlHostel']") private WebElement Hostel;
	
	//-----------------------------------------------------------------------------------------------
	public schoolProfilePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//---------------------------------------------------------------------------------------------------------
	
	public WebElement getMediumOfSchool() {
		return MediumOfSchool;
	}
	
	public WebElement getSchoolType() {
		return SchoolType;
	}
	public WebElement getSchoolArea() {
		return SchoolArea;
	}
	public WebElement getSchoolSyllabus() {
		return SchoolSyllabus;
	}
	public WebElement getSchoolEmailID() {
		return SchoolEmailID;
	}
	public WebElement getSTDCode() {
		return STDCode;
	}
	public WebElement getSchoolTelephone() {
		return SchoolTelephone;
	}
	public WebElement getPrincipalName() {
		return PrincipalName;
	}
	public WebElement getPrincipalMoNo() {
		return PrincipalMoNo;
	}
	public WebElement getPrincipalEmail() {
		return PrincipalEmail;
	}
	public WebElement getAlternateNumber() {
		return AlternateNumber;
	}
	public WebElement getHostel() {
		return Hostel;
	}
	
	
 	

}
