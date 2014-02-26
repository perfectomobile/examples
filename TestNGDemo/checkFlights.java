import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.perfectomobile.selenium.api.IMobileDevice;

public class PerfectoTest {


	public boolean checkFlights(IMobileDevice device)
	{
		try
		{
			device.open();
			device.home();

			// Define to types of web driver 
			// 1. DOM - standard web webdriver works with the DOM objects
			// 2. Visual Driver - allows to validate that text appear on the screen using visual analysis (OCR).
			//    This validation is very important and simulate the real user experience.

			WebDriver webDriver = device.getDOMDriver ("www.united.com");
			WebDriver visualDriver = device.getVisualDriver();

			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			// press on the button "flight status"
			WebElement webElement = webDriver.findElement(By.xpath("(//#text)[53]"));
			webElement.click();


			// press on the button "flight number"
			webElement = webDriver.findElement(By.xpath("(//@id=\"FlightNumber\")[1]"));
			webElement.sendKeys("84");

			// press on the button "Search"


			webDriver.findElement(By.xpath("(//INPUT)[5]")).click();

			// visual based validation - validate the text appear on the screen and can be seen by users.
			visualDriver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
			visualDriver.findElement(By.linkText("New York/Newark"));

			// object based validation - validate the text appear in the as part of the DOM structure 
			String text =  webDriver.findElement(By.xpath("(//#text)[177]")).getAttribute("text");
			//	assertEquals("New York/Newark, NJ (EWR)",text);	}
		}catch (Exception e)
		{
			return false;
		}
		return  true;
	}
}
