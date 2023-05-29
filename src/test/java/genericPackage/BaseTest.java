package genericPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstanst {
		
		protected static WebDriver driver;
		
		@BeforeMethod
		public void setUp() throws EncryptedDocumentException, IOException
		{
			Flib flib = new Flib();
			String browser = flib.readProperty(PROP_PATH,"browser");
			String url = flib.readProperty(PROP_PATH, "url");
			
			if (browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty(CHROME_KEY, CHROME_VALUE);
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(url);
			}
			
			else if (browser.equalsIgnoreCase("edge"))
			{
				System.setProperty(EDGE_KEY, EDGE_VALUE);
				driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				driver.get(url);
				
			}
			
			else
			{
				Reporter.log("Enter correct browser name" , true);
			}
			
		}
		
		public void failed(String methodName)
		{
			try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(SCREENSHOT_PATH + methodName+".png");
			Files.copy(src, dest);
			}
			
			catch (Exception e) {
				
			}
		}
		
		 
	@AfterMethod
		public void teardown() throws InterruptedException
		{
			Thread.sleep(4000);
			driver.quit();
		}

	}


