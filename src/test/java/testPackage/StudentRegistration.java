package testPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.Flib;
import genericPackage.WebDriverCommenLib;
import pagePackage.StudentRegi;
import pagePackage.indexPage;
import pagePackage.landingPage;

public class StudentRegistration extends BaseTest {
	@Test(priority = 1,invocationCount = 1)
	public void validSchoolLogin() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	{
		landingPage lp = new landingPage(driver);
		lp.getNMMS2022_23().click();
		
		indexPage ip = new indexPage(driver);
		ip.getSchoolLogin().click();

		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList al = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) al.get(1));

		driver.findElement(By.id("txtUDISE")).sendKeys("27110110002");
		driver.findElement(By.id("txtPassword")).sendKeys("3keG3f57");
		driver.findElement(By.name("btnSubmit")).click();
		WebElement success = driver.findElement(By.xpath("//h4[text()='Welcome to NMMS Examination  Online Registration']"));
		success.isDisplayed();
		Thread.sleep(4000);
		StudentRegi sr = new StudentRegi(driver);
		WebElement sr2 = sr.getStdRegiLink();
		if(sr2.isDisplayed())
		{
			Reporter.log("Student registration",true);
		sr.getStdRegiLink().click();
		WebElement vn = sr.getVinaanudanit();

		WebDriverCommenLib wdl = new WebDriverCommenLib();
		wdl.selectTheOption(vn, "No");
		WebElement kv = sr.getKendriyVidhyal();
		wdl.selectTheOption(kv,"No");

		WebElement jh = sr.getJavahr();
		wdl.selectTheOption(jh,"1");

		WebElement sh = sr.getShashkiyHostel();
		wdl.selectTheOption(sh,"No");
		WebElement ss = sr.getSainikiSchool();
		wdl.selectTheOption(ss,"No");
		Thread.sleep(1000);
		WebElement up = driver.findElement(By.xpath("//input[@name='ProfileFileUpload']"));
		//up.click();
	//	up.sendKeys("C:\\Users\\User\\Downloads\\TET210002610Photofinal (2).jpg");
		 Thread.sleep(2000); // suspending execution for specified time period
		 
	/*	   // creating object of Robot class
		    Robot rb = new Robot();
		 
		    // copying File path to Clipboard
		    StringSelection str = new StringSelection("C:\\Users\\User\\Downloads\\TET210002610Photofinal (2).jpg");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		     // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V);
		 
		    // for pressing and releasing Enter
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
		*/

		sr.getDOB().click();
		Flib flib = new Flib();
		int rc = flib.rowCount(EXCEL_PATH, "NMMS_StudentMasterList");
		for (int i=1;i<=1; i++)
		{

			//--- dob selection
			WebElement sss = driver.findElement(By.xpath("//div[@id='CalendarExtender1_title']"));
			String year = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,0);
			String month = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,1);
			String day = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,2);

			sss.click();
			Thread.sleep(1000);
			sss.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(year)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(month)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(day)).click();
			Thread.sleep(1000);
			

		StudentRegi sr1 = new StudentRegi(driver);
			String name = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,3);
			sr1.getStdFirstName().sendKeys(name);
			String sname = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,4);
			sr1.getStdSurname().sendKeys(sname);
			String fname = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,5);
			sr1.getStdFathersname().sendKeys(fname);
			String mname = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,6);
			sr1.getStdMothersName().sendKeys(mname);
			Thread.sleep(1000);
			double gender = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,7);
			String s = Double.toString(gender);
			Reporter.log(s, true);
			if(s.equalsIgnoreCase("1.0"))
			{
				WebElement dd = sr1.getStdGender();
				dd.click();
				wdl.selectTheOption(dd,1);

			}
			else
			{
				WebElement dd = sr1.getStdGender();
				dd.click();
				wdl.selectTheOption(dd, 2);
			}

			String adhar = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,8);
			if(adhar.isEmpty())
			{

			}
			else
			{
				sr1.getAdharNumber().sendKeys(adhar);
			}
			boolean dis = flib.readExcelDataBoolean(EXCEL_PATH,"NMMS_StudentMasterList" , i,10);

			String fl = Boolean.toString(dis);
			if(fl.equalsIgnoreCase("FALSE"))
			{
				WebElement ds = sr1.getDisability();
				wdl.selectTheOption(ds, 2);
			}
			else
			{
				WebElement ds = sr1.getDisability();
				wdl.selectTheOption(ds, 1);

				String disName = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,11);
				if(disName.equalsIgnoreCase("BLINDNESS AND LOW VISION (BLV)"))
				{
					WebElement type = sr1.getDisabilityType();
					wdl.selectTheOption(type,1);
				}
				else if(disName.equalsIgnoreCase("DEAF AND HARD HEARING (DH)"))
				{
					WebElement type = sr1.getDisabilityType();
					wdl.selectTheOption(type,2);
				}
				else if(disName.equalsIgnoreCase("LOCOMOTOR DISABILITY (LD)"))
				{
					WebElement type = sr1.getDisabilityType();
					wdl.selectTheOption(type,3);
				}
				else if(disName.equalsIgnoreCase("AUTISM,INTELETUAL DISABILTY SPECIFIC LEARNING DISABILTY AND MENTAL ILLNESS (AID)"))
				{
					WebElement type = sr1.getDisabilityType();
					wdl.selectTheOption(type,4);
				}
				else
				{
					WebElement type = sr1.getDisabilityType();
					wdl.selectTheOption(type,5);
				}
				Thread.sleep(1000);
				double per = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,12);
				String pr = Double.toString(per);
				sr1.getDisabilityPerc().sendKeys(pr);

				Thread.sleep(1000);

				boolean writer = flib.readExcelDataBoolean(EXCEL_PATH,"NMMS_StudentMasterList" , i,13);
				String wr = Boolean.toString(writer);
				if(wr.equalsIgnoreCase("FALSE"))
				{
					WebElement writter = sr1.getNeedWritter();
					wdl.selectTheOption(writter, 2);
				}
				else
				{
					WebElement writter = sr1.getNeedWritter();
					wdl.selectTheOption(writter, 1);
				}


			}

			double caste = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,14);

			String cast = Double.toString(caste);
			Reporter.log(cast+"  caste", true);
			if (cast.equalsIgnoreCase("1.0"))
			{
				WebElement cs = sr1.getCaste();
				Thread.sleep(1000);

				wdl.selectTheOption(cs, 1);
				boolean ews = flib.readExcelDataBoolean(EXCEL_PATH,"NMMS_StudentMasterList" , i,17);
				String yn = Boolean.toString(ews);
				if(yn.equalsIgnoreCase("False"))
				{
					WebElement ews1 = sr1.getEWS();
					wdl.selectTheOption(ews1, 2);
				}
				else
				{
					WebElement ews1 = sr1.getEWS();
					wdl.selectTheOption(ews1, 1);
				}

			}
			else
			{
				if (cast.equalsIgnoreCase("2.0"))
				{
					WebElement cs = sr1.getCaste();
					wdl.selectTheOption(cs, 2);
				}
				else if (cast.equalsIgnoreCase("3.0"))
				{
					WebElement cs = sr1.getCaste();
					wdl.selectTheOption(cs, 3);
				}
				else if (cast.equalsIgnoreCase("4.0"))
				{
					WebElement cs = sr1.getCaste();
					wdl.selectTheOption(cs, 4);
				}
				else if (cast.equalsIgnoreCase("5.0"))
				{
					WebElement cs = sr1.getCaste();
					wdl.selectTheOption(cs, 5);
				}
				else if (cast.equalsIgnoreCase("6.0"))
				{
					WebElement cs = sr1.getCaste();
					wdl.selectTheOption(cs, 6);
				}
				else if (cast.equalsIgnoreCase("7.0"))
				{
					WebElement cs = sr1.getCaste();
					wdl.selectTheOption(cs, 7);
				}
				else if (cast.equalsIgnoreCase("8.0"))
				{
					WebElement cs = sr1.getCaste();
					wdl.selectTheOption(cs, 8);
				}
				else if (cast.equalsIgnoreCase("9.0"))
				{
					WebElement cs = sr1.getCaste();

					wdl.selectTheOption(cs, 9);
				}

			}
			String casteName = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,16);
			sr1.getCasteName().sendKeys(casteName);

			double area = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,15);
			String area1 = Double.toString(area);
			if(area1.equalsIgnoreCase("1"))
			{
				WebElement ar = sr1.getResidenshialArea();
				wdl.selectTheOption(ar, 1);

			}
			else
			{
				WebElement ar = sr1.getResidenshialArea();
				wdl.selectTheOption(ar, 2);
			}

			String area2 = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,18);
			sr1.getArea().sendKeys(area2);

			String village = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,19);
			sr1.getVillage().sendKeys(village);

			String dist = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,20);

			WebElement di = sr1.getDistrict();

			wdl.selectTheOption(dist, di);

			Thread.sleep(1000);

			String tal = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,21);
			WebElement taluka = sr1.getTaluka();
			wdl.selectTheOption(tal, taluka);

			String pin = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,22);
			sr1.getPinCode().sendKeys(pin);

			double medium = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,23);
			String medium1 = Double.toString(medium);
			Reporter.log(medium1,true);
			if(medium1.equals("1.0"))
			{
				WebElement md = sr1.getMedium();
				wdl.selectTheOption(md, 1);
			}
			else if(medium1.equals("2.0"))
			{
				WebElement md = sr1.getMedium();
				wdl.selectTheOption(md, 2);
			}
			else if(medium1.equals("3.0"))
			{
				WebElement md = sr1.getMedium();
				wdl.selectTheOption(md, 3);
			}
			else if(medium1.equals("4.0"))
			{
				WebElement md = sr1.getMedium();
				wdl.selectTheOption(md, 4);
			}
			else if(medium1.equals("5.0"))
			{
				WebElement md = sr1.getMedium();
				wdl.selectTheOption(md, 5);
			}
			else if(medium1.equals("7.0"))
			{
				WebElement md = sr1.getMedium();
				wdl.selectTheOption(md, 7);
			}
			else if(medium1.equals("8.0"))
			{
				WebElement md = sr1.getMedium();
				wdl.selectTheOption(md, 8);
			}
			else { Reporter.log("Medium not selected",true);}

			boolean bankAvailable = flib.readExcelDataBoolean(EXCEL_PATH,"NMMS_StudentMasterList" , i,24);
			String bankA = Boolean.toString(bankAvailable);
			if(bankA.equalsIgnoreCase("False"))
			{
				WebElement info = sr1.getBankAccInfo();
				wdl.selectTheOption(info, 2);
			}
			else
			{
				WebElement info = sr1.getBankAccInfo();
				wdl.selectTheOption(info, 1);

				sr1.getBankHolderName().sendKeys(name);
				String accNo = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,25);
				sr1.getAccNumber().sendKeys(accNo);

				String address = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,26);
				sr1.getBankAddress().sendKeys(address);
				String bankName = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,27);
				sr1.getBankName().sendKeys(bankName);

				String ifsc = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,28);
				sr1.getIFSCCode().sendKeys(ifsc);
				String branch = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,29);
				sr1.getBranch().sendKeys(branch);

			}
			double fatherEdu = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,30);
			String fEdu = Double.toString(fatherEdu);
			if(fEdu.equalsIgnoreCase("1.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 1);
			}
			else if(fEdu.equalsIgnoreCase("2.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 2);
			}
			else if(fEdu.equalsIgnoreCase("3.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 3);
			}else if(fEdu.equalsIgnoreCase("4.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 4);
			}else if(fEdu.equalsIgnoreCase("5.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 5);
			}else if(fEdu.equalsIgnoreCase("6.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 6);
			}else if(fEdu.equalsIgnoreCase("7.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 7);
			}else if(fEdu.equalsIgnoreCase("8.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 8);
			}
			else if(fEdu.equalsIgnoreCase("9.0"))
			{
				WebElement fE = sr1.getFathersEduction();
				wdl.selectTheOption(fE, 9);
			}
			else
			{
				Reporter.log("father edu not set",true);
			}

			double FatherOccu = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,31);
			String fatherOccupation = Double.toString(FatherOccu);
			if(fatherOccupation.equals("1.0"))
			{
				WebElement fOccu = sr1.getFatherOccupation();
				wdl.selectTheOption(fOccu,1);

			}
			else if(fatherOccupation.equals("2.0"))
			{
				WebElement fOccu = sr1.getFatherOccupation();
				wdl.selectTheOption(fOccu,2);

			}
			else if(fatherOccupation.equals("3.0"))
			{
				WebElement fOccu = sr1.getFatherOccupation();
				wdl.selectTheOption(fOccu,3);

			}
			else if(fatherOccupation.equals("4.0"))
			{
				WebElement fOccu = sr1.getFatherOccupation();
				wdl.selectTheOption(fOccu,4);

			}
			else if(fatherOccupation.equals("5.0"))
			{
				WebElement fOccu = sr1.getFatherOccupation();
				wdl.selectTheOption(fOccu,5);

			}
			else if(fatherOccupation.equals("6.0"))
			{
				WebElement fOccu = sr1.getFatherOccupation();
				wdl.selectTheOption(fOccu,6);

			}
			else if(fatherOccupation.equals("7.0"))
			{
				WebElement fOccu = sr1.getFatherOccupation();
				wdl.selectTheOption(fOccu,7);

			}
			else if(fatherOccupation.equals("8.0"))
			{
				WebElement fOccu = sr1.getFatherOccupation();
				wdl.selectTheOption(fOccu,8);

			}
			else
			{
				Reporter.log("Father occupation not set",true);

			}

			double motherEdu = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,32);
			String medu = Double.toString(motherEdu);
			if(medu.equalsIgnoreCase("1.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 1);
			}
			else if(medu.equalsIgnoreCase("2.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 2);
			}
			else if(medu.equalsIgnoreCase("3.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 3);
			}else if(medu.equalsIgnoreCase("4.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 4);
			}else if(medu.equalsIgnoreCase("5.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 5);
			}else if(medu.equalsIgnoreCase("6.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 6);
			}else if(medu.equalsIgnoreCase("7.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 7);
			}else if(medu.equalsIgnoreCase("8.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 8);
			}
			else if(medu.equalsIgnoreCase("9.0"))
			{
				WebElement fE = sr1.getMothersEduction();
				wdl.selectTheOption(fE, 9);
			}
			else
			{
				Reporter.log("Mother edu not set",true);
			}

			double motherOccu = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,33);
			String mOccupation = Double.toString(motherOccu);

			if(mOccupation.equals("1.0"))
			{
				WebElement fOccu = sr1.getMotherOccuption();
				wdl.selectTheOption(fOccu,1);

			}
			else if(mOccupation.equals("2.0"))
			{
				WebElement fOccu = sr1.getMotherOccuption();
				wdl.selectTheOption(fOccu,2);

			}
			else if(mOccupation.equals("3.0"))
			{
				WebElement fOccu = sr1.getMotherOccuption();
				wdl.selectTheOption(fOccu,3);

			}
			else if(mOccupation.equals("4.0"))
			{
				WebElement fOccu = sr1.getMotherOccuption();
				wdl.selectTheOption(fOccu,4);

			}
			else if(mOccupation.equals("5.0"))
			{
				WebElement fOccu = sr1.getMotherOccuption();
				wdl.selectTheOption(fOccu,5);

			}
			else if(mOccupation.equals("6.0"))
			{
				WebElement fOccu = sr1.getMotherOccuption();
				wdl.selectTheOption(fOccu,6);

			}
			else if(mOccupation.equals("7.0"))
			{
				WebElement fOccu = sr1.getMotherOccuption();
				wdl.selectTheOption(fOccu,7);

			}
			else if(mOccupation.equals("8.0"))
			{
				WebElement fOccu = sr1.getMotherOccuption();
				wdl.selectTheOption(fOccu,8);

			}
			else
			{
				Reporter.log("Father occupation not set",true);

			}
			double noOfMember = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,34);
			String member = Double.toString(noOfMember);
			sr1.getNoOfMember().sendKeys(member);
			double noOfBrother = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,35);
			String brother = Double.toString(noOfBrother);
			 sr1.getNoOfBrother().sendKeys(brother);

			double noOfSister = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,36);
			String sister = Double.toString(noOfSister);
			 sr1.getNoOfSister().sendKeys(sister);
			 
			 double among = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,37);
			 String sisBro = Double.toString(among);
			 sr1.getAmongNumber().sendKeys(sisBro);
			String pemail = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,38);
			sr1.getParentemail().sendKeys(pemail);
			String pmobile = flib.readExcelData(EXCEL_PATH,"NMMS_StudentMasterList" , i,39);
			sr1.getParentmobile().sendKeys(pmobile);
			sr1.getAnnualIncome().sendKeys("100001 To 200000");
			double secureMark = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,42);
			String secureMark1 = Double.toString(secureMark);
			sr1.getSecuredMark().sendKeys(secureMark1);
			double outOff = flib.readExcelDataInt(EXCEL_PATH,"NMMS_StudentMasterList" , i,43);
			String outOff1 = Double.toString(outOff);
			sr1.getOutOfMarks().sendKeys(outOff1);
			Thread.sleep(2000);
	//		sr1.getSaveAndPreviewButton().click();
		//	wdl.acceptAlertPopup();
			
	//		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='ProfileFileUpload']")).sendKeys("C:\\Users\\User\\Downloads\\QMS2.jpg");
			Thread.sleep(1000);
			sr1.getSaveAndPreviewButton().click();
			driver.findElement(By.xpath("//input[@id='btnedit']"));
		}

	}
		else
		{
		Reporter.log("Student registration is close",true);	
		}
	}
	
}




