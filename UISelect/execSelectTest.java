import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.perfectomobile.httpclient.utils.FileUtils;
import com.perfectomobile.selenium.*;
import com.perfectomobile.selenium.api.*;
import com.perfectomobile.selenium.options.MobileDeviceProperty;
import com.perfectomobile.selenium.options.visual.text.MobileTextMatchMode;

public class execSelectTest
{
	public static void main(String[] args)
	{
	 	amex();
	
	}


	public static void amex()   {


		MobileDriver PMdriver = new MobileDriver();

		//	IMobileDevice device = PMdriver.getDevice("0149BCA71700D01F");

		IMobileDevice device = PMdriver.getDevice("3152168C4EAA1E2A5DE93CF7B89222720E3A62E0");


		IMobileWebDriver  webdriver = device.getDOMDriver ("http://www.americanexpress.com");

		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


		WebElement item  = webdriver.findElement(By.xpath("//*[@id='manage']"));
		PMUISelect sel = new PMUISelect(item,webdriver);
		
		sel.selectByIndex(2);
		//sel.selectByVisibleText("Merchant Account");

		
		
	
		webdriver.findElement(By.xpath("(//input[@id=\"Username\"])[1]")).sendKeys("uzi");
		webdriver.findElement(By.xpath("(//input[@id=\"Password\"])[1]")).sendKeys("pass");

		WebElement remember =   webdriver.findElement(By.xpath("(//input[@id=\"checkBox\"])[1]"));

		System.out.println(">>"+remember.getText());
		remember.click();


		// check box 
		System.out.println(">> before "+remember.getAttribute("checked"));
		remember.click();
		System.out.println(">> after "+remember.getAttribute("checked"));



	}
}
