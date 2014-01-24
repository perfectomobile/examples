
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.perfectomobile.httpclient.MediaType;
import com.perfectomobile.httpclient.utils.FileUtils;
import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileDriver;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.options.visual.text.MobileTextMatchMode;

public class JunitBOFAApp {

	static MobileDriver driver;
	@BeforeClass
	public static void testSetup() {
		String host = Constants.PM_CLOUD;
		String user = Constants.PM_USER;
		String password = Constants.PM_PASSWORD;
		driver = new MobileDriver(host, user, password);

	}

	@AfterClass
	public static void testCleanup() {
		driver.quit();
		InputStream reportStream = ((IMobileDriver) driver).downloadReport(MediaType.HTML);
		String repName= Constants.REPORT_LIB+"JUnitTest.HTML";
		if (reportStream != null) {
			File reportFile = new File(repName);
			FileUtils.write(reportStream, reportFile);
			
		}
		System.out.println("Rep:"+repName);
	}

	
	@Test 
	public void testDeviPhone() {
		//  
		IMobileDevice device = ((IMobileDriver) driver).getDevice("4DF1F4C107319F79");
		ExectueTest(device);


	}
	public static void ExectueTest(IMobileDevice device) {
 
 
		device.open();
		device.home();
		/// get visual webdriver
		IMobileWebDriver webDriver = device.getVisualDriver();
		//open the app by looking the text bofa
		webDriver.findElement(By.linkText("Bofa")).click();
		
		 
		// set the time-out to 20 s 
		// now every time we will use this webdriver the timeout to wait for the object will be 20 m 
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		webDriver.manageMobile().visualOptions().textMatchOptions().setMode(MobileTextMatchMode.LAST);
		//press on the button account
		webDriver.findElement(By.linkText("Account")).click();	


		// validate we are on the first page by finding the text "save this onlien"
		webDriver.findElement(By.linkText("Save this online"));

		// press on the location button , by setting the textMatchOptions to LAST
		// the system will press on the last "account" string on the screen 
		// I used the last because I know the button in the the bottom of the screen 
		 webDriver.manageMobile().visualOptions().textMatchOptions().setMode(MobileTextMatchMode.LAST);
		 webDriver.findElement(By.linkText("Locations")).click();
		 webDriver.findElement(By.linkText("Find Bank of America ATMs"));

		 
		 // defining a new visual webdriver to press the zip code button which appear in the next to screen 
		 IMobileWebDriver zip = device.getVisualDriver();
		 zip.manageMobile().visualOptions().textMatchOptions().setMode(MobileTextMatchMode.LAST);
		 zip.findElement(By.linkText("zip code")).click();
		 sleep(2000);
		 zip.findElement(By.linkText("zip code")).click();
		 sleep(2000);

		 // Entering the zip code 02459 to the zipcode field 
		 webDriver.manageMobile().visualOptions().textMatchOptions().setMode(MobileTextMatchMode.LAST);
		 webDriver.manageMobile().visualOptions().ocrOptions().setLevelsLow(120);
		 webDriver.findElement(By.linkText("Code")).sendKeys("02459");
		 
		 // Press Done and Go button
		 zip.findElement(By.linkText("Done")).click();
		 zip.findElement(By.linkText("Go")).click();
		 
		 //validate we find the location Newton 
		 webDriver.findElement(By.linkText("Newton MA"));
		 
       


	}

	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}


} 
