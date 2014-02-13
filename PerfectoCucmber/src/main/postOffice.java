
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileDriver;
import com.perfectomobile.selenium.api.IMobileWebDriver;


public class postOffice {

	MobileDriver driver;
	String state;
	String city;
	String zip;

	
	public postOffice (String addr)
	{

		String host = Constants.PM_CLOUD;
		String user = Constants.PM_USER;
		String password = Constants.PM_PASSWORD;
		driver = new MobileDriver(host, user, password);
		List<String> el = Arrays.asList(addr.split(","));

		city =el.get(0);
		state = el.get(1);
		zip = el.get(2);
	}
	public String checkFlight()
	{
		IMobileDevice device = ((IMobileDriver) driver).getDevice(Constants.DEVICE);
		
		
		device.open();
 		
		//device.getScreenText()
		//device.checkpointText("search");
		WebDriver webDriver = device.getDOMDriver ("m.usps.com/");
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//sleep(2000);
		IMobileWebDriver synDeiver = device.getVisualDriver();
		synDeiver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		synDeiver.findElement(By.linkText("Find a ZIP code"));

		webDriver.findElement(By.xpath("(//A)[3]")).click();
		synDeiver.findElement(By.linkText("Strert address"));

		webDriver.findElement(By.xpath("(//@name=\"txtCity\")[1]")).sendKeys(city);

		webDriver.findElement(By.xpath("(//@name=\"ddState\")[1]")).sendKeys(state);

		webDriver.findElement(By.xpath("(//@name=\"btnSearch\")[1]")).click();

		WebElement e =  synDeiver.findElement(By.linkText(zip));
		
		driver.quit();
		if (e!= null)
		{
			return zip;
		}
		return "error";
		
	}
	
	 
}
