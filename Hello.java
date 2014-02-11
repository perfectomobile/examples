
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.WebDriver.*;

import com.perfectomobile.selenium.*;
import com.perfectomobile.selenium.api.*;
import com.perfectomobile.selenium.by.*;
import com.perfectomobile.selenium.output.*;
import com.perfectomobile.selenium.options.*;
import com.perfectomobile.selenium.options.visual.*;
import com.perfectomobile.selenium.options.visual.image.*;
import com.perfectomobile.selenium.options.visual.text.*;
import com.perfectomobile.selenium.options.touch.*;
import com.perfectomobile.httpclient.MediaType;
import com.perfectomobile.httpclient.utils.FileUtils;

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
			
			webDriver.findElement(By.xpath("(//@id=\"lst-ib\")[1]")).sendKeys("PerfectoMobile");
			webDriver.findElement(By.xpath("(//@id=\"tsbb\")[1]")).click();


;			
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
