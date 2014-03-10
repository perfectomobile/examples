import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;


public class executeJavaCode {

	public static void main(String[] args) {
		MobileDriver driver = new MobileDriver(Constants.PM_CLOUD,Constants.PM_USER,Constants.PM_PASSWORD);


		System.out.println("Script started");

		try {
			IMobileDevice device = driver.getDevice(Constants.DEVICE);


			device.open();
			device.home();

			WebDriver webDriver = device.getDOMDriver ("cnnmobile.com");
			webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			((IMobileWebDriver) webDriver).executeScript("alert('Perfecto Mobile');");

		} catch (Exception e) {
			e.printStackTrace();
			//		onError(connector.getDevice(Constants.DEVICE););
		} finally {
			driver.quit();
		}
		System.out.println("Script ended");
	}

}
