
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;


public class getDom {

	public static void main(String[] args) {
		MobileDriver connector = new MobileDriver(Constants.PM_CLOUD,Constants.PM_USER,Constants.PM_PASSWORD);


		System.out.println("Script started");

		try {
			IMobileDevice device = connector.getDevice(Constants.DEVICE);
			device.open();

			WebDriver webDriver = device.getDOMDriver ("www.linkedin.com");
			WebDriver visualDriver = device.getVisualDriver();

			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			visualDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			visualDriver.findElement(By.linkText("Your Profile "));

			String source = ((IMobileWebDriver)webDriver).getProperty("innerHTML");

			System.out.println(source);


			// write your code here

		} catch (Exception e) {
			e.printStackTrace();
			//		onError(connector.getDevice(Constants.DEVICE););
		} finally {
			connector.quit();
		}
		System.out.println("Script ended");
	}
 
	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
