package gridTools;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import ver66.Constants;

public class exe {

	public exe() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		String browserName = "MobileOS";
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
		capabilities.setCapability("platformName", "Android");
	//	capabilities.setCapability("platformVersion", "4.*");
		capabilities.setCapability("manufacturer", "Samsung");
	//	capabilities.setCapability("deviceName", "0149BCA71700D01F");
		capabilities.setCapability("user", "uzie@perfectomobile.com");
		capabilities.setCapability("password", "*******");

		
 
 		try {
			RemoteWebDriver driver = new RemoteWebDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
			downloadFile f = new downloadFile(driver);
			f.editForm();
			f.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
