
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
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
import com.perfectomobile.selenium.options.rotate.*;
import com.perfectomobile.selenium.options.touch.*;
import com.perfectomobile.selenium.options.visual.*;
import com.perfectomobile.selenium.options.visual.image.*;
import com.perfectomobile.selenium.options.visual.text.*;

import com.perfectomobile.httpclient.MediaType;
import com.perfectomobile.httpclient.utils.FileUtils;

public class DeviceManagerWiFi {


	public static void main(String[] args) {

		String cloud = args[0];
		String user = args[1];
		String password = args[2];
		String deviceID = args[3];
		// action :
		// WIFI-ON - will restart the WIFI and turn it on if needed 
		// WIFI-OFF - turn  off the WIFI
		// WIFI-TOGGLE - toggle the WIFI 
		// WIFI-STATUS - return the starts + net network name  
		String action  = "WIFI-ON" ; // WIFI-ON ; WIFI-OFF ; WIFI-TOGGLE ; WIFI-STATUS ; FLIGHT-MODE
		 ManageDeviceWiFi(cloud,user,password,deviceID,action);

	//	ManageDeviceWiFi("","","","0149BCA71700D01F","FLIGHT-MODE");
	//	ManageDeviceWiFi("","","","39F3DA5531ADBE2A05CFF4D65E43A2C38D3D595A","FLIGHT-MODE");

	}
	
	public static void ManageDeviceWiFi(String Cloud,String User, String Password, String DeviceID,String action)
	{

		//	MobileDriver driver = new MobileDriver(cloud,user,password);
		MobileDriver driver = new MobileDriver();

		try {

			IMobileDevice device = driver.getDevice(DeviceID);
			String os = device.getProperty("OS");
			if (os.equals("iOS"))
			{
				if (action.equals("WIFI-STATUS"))
				{
					System.out.println(">>>>"+WiFIStatusIphone(device));

				}else if (action.equals("FLIGHT-MODE"))
				{
					flightModeResetIphone(device);
				}else 
				{
					//device.open();
					setWiFiIphone(device,action);
				}


			}else
			{
				if (action.equals("WIFI-STATUS"))
				{
					System.out.println(">>>>"+WiFIStatusAndroid(device));

				}else if (action.equals("FLIGHT-MODE"))
				{
					flightModeResetAndroid(device);
				}
				else
				{
					//device.open();
					setWiFiAndroid(device,action);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	public static boolean setWiFiAndroid(IMobileDevice device,String action)
	{
		IMobileWebDriver settingWD =device.getNativeDriver();
		openSettingAndroid(device);
		WebElement switchOnOff = settingWD.findElement(By.xpath("//switch")) ;
		String currentStatusStr = switchOnOff.getText();

		if (action.equals("WIFI-ON"))
		{
			if (currentStatusStr.equals("OFF"));
			{
				switchOnOff.click();
			}
		}else if (action.equals("WIFI-OFF"))
		{
			if (currentStatusStr.equals("ON"));
			{
				switchOnOff.click();
				return true;
			}
		}
		sleep(1000);

		switchOnOff.click();
		sleep(1000);
		switchOnOff.click();
		return true;
	}
	public static String WiFIStatusAndroid(IMobileDevice device)
	{
		openSettingAndroid(device);
		IMobileWebDriver settingWD =device.getNativeDriver();
		WebElement switchOnOff = settingWD.findElement(By.xpath("//switch")) ;
		String currentStatusStr = switchOnOff.getText();

		if (currentStatusStr.equals("OFF")) 
		{
			return "off";
		}

		String network;
		try {
			network = settingWD.findElement(By.xpath("//text[text()='Connected']/preceding-sibling::*")).getText();

		} catch (Exception e) {
			return "on";
		}
		return "on:"+network ;


	}
	public static boolean setWiFiIphone(IMobileDevice device,String action)
	{
		openSettingIphone(device);

		IMobileWebDriver settingWD =device.getNativeDriver();

		WebElement currentStatus = settingWD.findElement(By.xpath("(//text[text()='Wi-Fi']/following-sibling::*)[1]")) ;
		String currentStatusStr = currentStatus.getText();
		currentStatus.click();

		WebElement switchOnOff = settingWD.findElement(By.xpath("//switch")) ;

		if (action.equals("WIFI-ON"))
		{
			if (currentStatusStr.equals("off"));
			{
				switchOnOff.click();
			}
		}else if (action.equals("WIFI-OFF"))
		{
			if (currentStatus.getText().equals("on"));
			{
				switchOnOff.click();
			}
		}
		sleep(1000);

		switchOnOff.click();
		sleep(1000);
		switchOnOff.click();
		sleep(4000);

		return true;

	}


	public static void text (IMobileDevice device) 
	{
		IMobileWebDriver settingWD =device.getNativeDriver();
		WebElement switchOnOff = settingWD.findElement(By.xpath("//switch")) ;
		switchOnOff.click();
		sleep(1000);
		switchOnOff.click();

	}


	public static String WiFIStatusIphone(IMobileDevice device)
	{
		String RC;
		openSettingIphone(device);
		IMobileWebDriver settingWD =device.getNativeDriver();
		WebElement network;

		WebElement currentStatus = settingWD.findElement(By.xpath("(//text[text()='Wi-Fi']/following-sibling::*)[1]")) ;
		String currentStatusStr = currentStatus.getText();
		currentStatus.click();
		if (currentStatusStr.equals("off")) 
		{
			return "off";
		}
		try {
			network = settingWD.findElement(By.xpath("(//cell[@label='Wi-Fi']/following-sibling::*)[1]")) ;

		} catch (Exception e) {
			return "on";
		}
		return "on:"+network.getAttribute("label");


	}

	public static boolean flightModeResetIphone(IMobileDevice device)
	{
		openSettingIphone(device);
		IMobileWebDriver settingWD =device.getNativeDriver();
 		WebElement airplane = settingWD.findElement(By.xpath("//cell[@name='Airplane Mode']/switch")) ;
 
		// 0 = off , first turn it on 
		if (airplane.getAttribute("value").equals("0"))
		{
			airplane.click();
			sleep(3000);
		}
		airplane.click();

		return true;
	}
	public static boolean flightModeResetAndroid(IMobileDevice device)
	{
		openSettingAPAndroid(device);
		IMobileWebDriver settingWD =device.getNativeDriver();

		WebElement airplane = settingWD.findElement(By.xpath("//checkbox")) ;
		String checked = airplane.getAttribute("checked");
		
		// 0 = off , first turn it on 
	 	if (checked.equals("false"))
		{
			airplane.click();
			sleep(3000);
		}
		airplane.click();
 
		return true;
	}

	private static void openSettingAndroid(IMobileDevice device) {
		Map<String, String> commandParams = new HashMap<String, String>();
		commandParams.put("handsetId", device.getDeviceId());
		commandParams.put("command", "am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings");
		// 
		device.executeGenericCommand("handset", "shell",commandParams);

	}

	private static void openSettingAPAndroid(IMobileDevice device) {
		Map<String, String> commandParams = new HashMap<String, String>();
		commandParams.put("handsetId", device.getDeviceId());
		commandParams.put("command", "am start -a  android.settings.WIRELESS_SETTINGS");
		// 
		device.executeGenericCommand("handset", "shell",commandParams);

	}
	private static void openSettingIphone(IMobileDevice device) {

		// device is IMobileDevice
		device.getNativeDriver("Settings").open();
		sleep(1000);
		device.getNativeDriver("Settings").close();
		sleep(1000);
		device.getNativeDriver("Settings").open();

		/*   *** removed - opened always on the first page 
		IMobileWebDriver settingWD =device.getNativeDriver();
		try {
			WebElement back = settingWD.findElement(By.xpath("//button[text()='Back']")) ;
			back.click();
		} catch (Exception e) {
			// TODO: not found 
		}

		 */
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}

