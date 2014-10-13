
import org.openqa.selenium.*;

import com.perfectomobile.selenium.*;
import com.perfectomobile.selenium.api.*;


public class MobileTest {
	
	public static void main(String[] args) {

		System.out.println("Run started");
		
		// The default empty constructor of MobileDriver should be used when running the code inside Eclipse.
		// The user must have the ECLIPSE role in this case.
		// Otherwise, use the constructor that receives the host, user and password. E.g.
		// MobileDriver driver = new MobileDriver(host, user, password);
		MobileDriver driver = new MobileDriver();
		
		try {
		//	MobileDeviceFindOptions devOp = new MobileDeviceFindOptions();
		//	devOp.setOS("iOS");
		//	IMobileDevice device = driver.findDevice(devOp);
			
			IMobileDevice device = driver.getDevice("3152168C4EAA1E2A5DE93CF7B89222720E3A62E0");
			device.open();
			IMobileWebDriver webDriver = device.getDOMDriver("google.com");
			webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			webdriver.findElement(By.xpath("(//input[@id=\"lst-ib\"])[1]")).sendKeys("Perfecto Mobile");
			webdriver.findElement(By.xpath("(//button[@id=\"tsbb\"])[1]")).click();

	

			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		System.out.println("Run ended");
	}
	
	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
