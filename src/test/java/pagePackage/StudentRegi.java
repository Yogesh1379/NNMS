package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentRegi {
	@FindBy(xpath = "//a[text()='Student Registration ']" ) private WebElement StdRegiLink;
	@FindBy(xpath = "//select[@name='ddlSelect']") private WebElement Vinaanudanit;
	@FindBy(xpath = "//select[@name='ddlSelect2']") private WebElement KendriyVidhyal;
	@FindBy(xpath = "//select[@name='ddlSelect3']") private WebElement Javahr;
	@FindBy(xpath = "//select[@name='ddlselect4']") private WebElement ShashkiyHostel;
	@FindBy(xpath = "//select[@name='ddlSelect5']") private WebElement SainikiSchool;
	@FindBy(xpath = "//input[@id='txtSureName']") private WebElement StdSurname;
	@FindBy(xpath = "//input[@id='txtFirstName']") private WebElement StdFirstName;
	@FindBy(xpath = "//input[@id='txtFathersname']") private WebElement StdFathersname;
	@FindBy(xpath = "//input[@id='txtMothersName']") private WebElement StdMothersName;
	@FindBy(xpath = "//select[@id='ddlGender']") private WebElement StdGender;
	@FindBy(xpath = "//input[@id='DOB1']") private WebElement DOB;
	
	@FindBy(id = "txtAadhaarNumber") private WebElement AdharNumber;
	@FindBy(xpath = "//select[@id='DisabilityStudent']" ) private WebElement disability;
	@FindBy(xpath = "//select[@id='ddlTypeofDisability']") private WebElement disabilityType;
	@FindBy(xpath = "//input[@id='txtDisabilityPer']") private WebElement disabilityPerc;
	@FindBy(xpath = "//select[@id='ddlNeedforwriter']") private WebElement NeedWritter;
	@FindBy(xpath = "//select[@id='ddlCaste']") private WebElement Caste;
	@FindBy(id = "txtcasteName") private WebElement casteName;
	@FindBy(xpath = "//select[@id='ddlEWSNotification']") private WebElement EWS;
	@FindBy(xpath = "//select[@id='ddlResidenshialArea']") private WebElement ResidenshialArea;
	@FindBy(id = "txtAreaPlace") private WebElement Area;
	@FindBy(id = "txtVillageCity") private WebElement Village;
	@FindBy(xpath = "//select[@id='ddlDistrict']") private WebElement District;
	@FindBy(xpath = "//select[@id='ddlTaluka']") private WebElement Taluka;
	@FindBy(id = "txtpincode") private WebElement pinCode;
	@FindBy(xpath = "//select[@id='ddlMediumMAT']") private WebElement medium;
	@FindBy(xpath = "//select[@id='ddlbankAccInfo']") private WebElement BankAccInfo;
	@FindBy(id = "txtbankHoldername") private WebElement BankHolderName;
	@FindBy(id = "txtbankAccountNumber") private WebElement AccNumber;
	@FindBy(id = "txtIFSCCode") private WebElement IFSCCode;
	@FindBy(id="txtBankName") private WebElement BankName;
	@FindBy(id = "txtBranch") private WebElement Branch;
	@FindBy(id = "txtAddressBranch") private WebElement BankAddress;
	@FindBy(xpath = "//select[@name='ddlFathersEduction']") private WebElement FathersEduction;
	@FindBy(xpath = "//select[@name='ddlFatherOccupation']") private WebElement FatherOccupation;
	@FindBy(xpath = "//select[@name='ddlMothersEduction']") private WebElement MothersEduction;
	@FindBy(xpath = "//select[@name='ddlMotherOccuption']") private WebElement MotherOccuption;
	@FindBy(xpath = "//input[@id='ddlNooffamilyMembers']") private WebElement NoOfMember;
	@FindBy(xpath = "//select[@id='ddlNoofbrothers']") private WebElement NoOfBrother;
	@FindBy(xpath = "//select[@id='ddlNoofsisters']") private WebElement NoOfSister;
	@FindBy(xpath = "//select[@id='ddlAmongbrosisNo']") private WebElement AmongNumber;
	@FindBy(id = "txtparentmobile") private WebElement Parentmobile;
	@FindBy(id = "txtparentemail") private WebElement Parentemail;
	@FindBy(id = "txtTelephoneNumber") private WebElement ParenteTel;
	@FindBy(xpath = "//select[@id='ddlAnnualIncome']") private WebElement AnnualIncome;
	@FindBy(xpath = "//input[@id='txtninethper']") private WebElement securedMark;
	@FindBy(xpath = "//input[@name='txtobtainmark']") private WebElement outOfMarks;
	@FindBy(xpath = "//input[@name='previewbtn']") private WebElement saveAndPreviewButton;
	@FindBy(xpath = "//button[@id='btncacal']") private WebElement submit;
	
	
	//--------------------------------------------------------------------------------------
	public StudentRegi(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//-----------------------------------------------------------------------------------
	public WebElement getStdRegiLink() {
		return StdRegiLink;
	}
	
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getSaveAndPreviewButton() {
		return saveAndPreviewButton;
	}
	public WebElement getAdharNumber() {
		return AdharNumber;
	}
	public WebElement getDisability() {
		return disability;
	}
	public WebElement getDisabilityType() {
		return disabilityType;
	}
	public WebElement getDisabilityPerc() {
		return disabilityPerc;
	}
	public WebElement getNeedWritter() {
		return NeedWritter;
	}
	public WebElement getCaste() {
		return Caste;
	}
	public WebElement getCasteName() {
		return casteName;
	}
	public WebElement getEWS() {
		return EWS;
	}
	public WebElement getResidenshialArea() {
		return ResidenshialArea;
	}
	public WebElement getArea() {
		return Area;
	}
	public WebElement getVillage() {
		return Village;
	}
	public WebElement getDistrict() {
		return District;
	}
	public WebElement getTaluka() {
		return Taluka;
	}
	public WebElement getPinCode() {
		return pinCode;
	}
	public WebElement getMedium() {
		return medium;
	}
	public WebElement getBankAccInfo() {
		return BankAccInfo;
	}
	public WebElement getBankHolderName() {
		return BankHolderName;
	}
	public WebElement getAccNumber() {
		return AccNumber;
	}
	public WebElement getIFSCCode() {
		return IFSCCode;
	}
	public WebElement getBankName() {
		return BankName;
	}
	public WebElement getBranch() {
		return Branch;
	}
	public WebElement getBankAddress() {
		return BankAddress;
	}
	public WebElement getFathersEduction() {
		return FathersEduction;
	}
	public WebElement getFatherOccupation() {
		return FatherOccupation;
	}
	public WebElement getMothersEduction() {
		return MothersEduction;
	}
	public WebElement getMotherOccuption() {
		return MotherOccuption;
	}
	public WebElement getNoOfMember() {
		return NoOfMember;
	}
	public WebElement getNoOfBrother() {
		return NoOfBrother;
	}
	public WebElement getNoOfSister() {
		return NoOfSister;
	}
	public WebElement getAmongNumber() {
		return AmongNumber;
	}
	public WebElement getParentmobile() {
		return Parentmobile;
	}
	public WebElement getParentemail() {
		return Parentemail;
	}
	public WebElement getParenteTel() {
		return ParenteTel;
	}
	public WebElement getAnnualIncome() {
		return AnnualIncome;
	}
	public WebElement getSecuredMark() {
		return securedMark;
	}
	public WebElement getOutOfMarks() {
		return outOfMarks;
	}
	public WebElement getVinaanudanit() {
		return Vinaanudanit;
	}
	public WebElement getKendriyVidhyal() {
		return KendriyVidhyal;
	}
	public WebElement getJavahr() {
		return Javahr;
	}
	public WebElement getShashkiyHostel() {
		return ShashkiyHostel;
	}
	public WebElement getSainikiSchool() {
		return SainikiSchool;
	}
	public WebElement getStdSurname() {
		return StdSurname;
	}
	public WebElement getStdFirstName() {
		return StdFirstName;
	}
	public WebElement getStdFathersname() {
		return StdFathersname;
	}
	public WebElement getStdMothersName() {
		return StdMothersName;
	}
	public WebElement getStdGender() {
		return StdGender;
	}
	public WebElement getDOB() {
		return DOB;
	}
	
	

}
