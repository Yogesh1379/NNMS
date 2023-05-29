package testPackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.WebDriverCommenLib;
import pagePackage.indexPage;
import pagePackage.landingPage;
import pagePackage.schoolSideHomePage;

public class school extends BaseTest {
	@Test(priority = 1,invocationCount = 1)
	public void validSchoolLogin() throws InterruptedException
	{
	/*	landingPage lp = new landingPage(driver);
		lp.getNMMS2022_23().click();
		*/
		indexPage ip = new indexPage(driver);
		ip.getSchoolLogin().click();
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList al = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) al.get(1));
		
		driver.findElement(By.id("txtUDISE")).sendKeys("27110110002");
		driver.findElement(By.id("txtPassword")).sendKeys("8o53fAf7");
		driver.findElement(By.name("btnSubmit")).click();
		WebElement success = driver.findElement(By.xpath("//h4[text()='Welcome to NMMS Examination  Online Registration']"));
		success.isDisplayed();
		Thread.sleep(4000);
		schoolSideHomePage ss = new schoolSideHomePage(driver);
		ss.getProfileMenu().click();
		ss.getLogout().click();
			
	}
	
	@Test(priority = 2,invocationCount = 1)
	public void schoolProfile() throws InterruptedException
	{
		landingPage lp = new landingPage(driver);
		lp.getNMMS2022_23().click();
		
		indexPage ip = new indexPage(driver);
		ip.getSchoolLogin().click();
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList al = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) al.get(1));
		
		driver.findElement(By.id("txtUDISE")).sendKeys("27110110002");
		driver.findElement(By.id("txtPassword")).sendKeys("8o53fAf7");
		driver.findElement(By.name("btnSubmit")).click();
		WebElement success = driver.findElement(By.xpath("//h4[text()='Welcome to NMMS Examination  Online Registration']"));
		success.isDisplayed();
		schoolSideHomePage ss = new schoolSideHomePage(driver);
		ss.getProfileMenu().click();
		ss.getSchoolProfile().click();
		Thread.sleep(4000);
		
		ss.getProfileMenu().click();
		WebElement up = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_PhotoUploaded']"));
		up.sendKeys("D:\\QMS2.jpg");
	WebElement ss1 = driver.findElement(By.xpath("//select[@class='btn btn-secondary dropdown-toggle']"));
			
		Select se = new Select(ss1);
		se.selectByValue("3");
		
		WebDriverCommenLib wdcl = new WebDriverCommenLib();
	wdcl.getAllOptionsOfDropdown(ss1);
		
	driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_savebtn']")).click();
		
	} 

}
