import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RWDtest {
	
	public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {

 		String browserName = "chrome";
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
		
		//select the device by properties
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.*");
		capabilities.setCapability("manufacturer", "Samsung");
		capabilities.setCapability("model", "Galaxy Nexus");

 		String host = Constants.PM_CLOUD;
		String user = URLEncoder.encode(Constants.PM_USER, "UTF-8");
		String password = URLEncoder.encode(Constants.PM_PASSWORD, "UTF-8");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + user + ':' + password + '@' + host + "/nexperience/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		capabilities = (DesiredCapabilities) driver.getCapabilities();
		String reportkey = (String) capabilities.getCapability("reportKey");
		String executionId = (String) capabilities.getCapability("executionId");
 		
 		
 		try {
 			 	
 			driver.get("google.com");
 			driver.findElement(By.xpath("//input[@id=\"lst-ib\"]")).sendKeys("PerfectoMobile");
  			driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
 			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}
	
	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	
}
