import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import com.perfectomobile.httpclient.utils.FileUtils;
import com.perfectomobile.selenium.*;
import com.perfectomobile.selenium.api.*;
import com.perfectomobile.selenium.options.visual.text.MobileTextMatchMode;

public class getObjList
{
	public static void main(String[] args)
	{
		objList();
	}

	private static void objList()
	{
	MobileDriver PMdriver = new MobileDriver();

		//IMobileDevice device = PMdriver.getDevice("0149BCA71700D01F");

		IMobileDevice device = PMdriver.getDevice("0149BCA71700D01F");
		device.open();
		IMobileWebDriver  webDriver = device.getDOMDriver ("www.carmax.com");
		WebDriver visualDriver = device.getVisualDriver();

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		visualDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		visualDriver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);


		visualDriver.findElement(By.linkText("Vehicle Type")).click();
		visualDriver.findElement(By.linkText("select a type")) ;

		List<WebElement> objList  = webDriver.findElements(By.xpath("(//div[@id=\"Content-\"])/ul/li/following::*[contains(@class,\"ui-link-inherit\")]"));

		
 		for (int i = 0 ; i <objList.size() ; i++)
		{
			WebElement item = objList.get(i);
			System.out.println("****"+item.getText());
		}
		 
		 
	}
	
}
