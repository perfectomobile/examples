package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.options.visual.text.MobileTextMatchMode;

public class PerfectoTest {


	public String checkFlights(IMobileDevice device)
	{
		String text ;
		try
		{
			device.open();
			//device.home();

			// Define to types of web driver 
			// 1. DOM - standard web webdriver works with the DOM objects
			// 2. Visual Driver - allows to validate that text appear on the screen using visual analysis (OCR).
			//    This validation is very important and simulate the real user experience.

			IMobileWebDriver  webDriver = device.getDOMDriver ("www.united.com");
			WebDriver visualDriver = device.getVisualDriver();

			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//webDriver.clean();
			// press on the button "flight status"
			visualDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

			visualDriver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);

			visualDriver.findElement(By.linkText("My account")) ;

			visualDriver.findElement(By.linkText("Flight Status")).click();

			visualDriver.findElement(By.linkText("Search"));


			// press on the button "flight number"
			webDriver.findElement(By.xpath("(//input[@id=\"FlightNumber\"])[1]")).sendKeys("84");



			// press on the button "Search"
			visualDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			((IMobileWebDriver) visualDriver).manageMobile().visualOptions().textMatchOptions().setMode(MobileTextMatchMode.LAST);
			visualDriver.findElement(By.linkText("Search"));


			visualDriver.findElement(By.linkText("search")).click();


			// visual based validation - validate the text appear on the screen and can be seen by users.
			visualDriver.findElement(By.linkText("New York/Newark"));

			// object based validation - validate the text appear in the as part of the DOM structure 

			text = "New York/Newark, NJ (EWR)";

		}catch (Exception e)
		{
			return "error";
		}
		return  text;
	}
}
