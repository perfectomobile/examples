import java.util.List;

import com.perfectomobile.selenium.*;
import com.perfectomobile.selenium.api.*;
import com.perfectomobile.selenium.options.MobileDeviceFindOptions;
import com.perfectomobile.selenium.options.MobileDeviceOS;
import com.perfectomobile.selenium.options.MobileDeviceProperty;

public class DeviceFactory
{
	public static void main(String[] args)
	{
		IMobileDevice deviceRT  = getDevice(DeviceType.Android);
		System.out.println( deviceRT.getProperty(MobileDeviceProperty.MODEL) );
	}

	public enum DeviceType {
		Android , iOS , Android_tablet ,iOS_tablet 
	}
	public static IMobileDevice  getDevice(DeviceType device )   {

		// Android , iOS 

		MobileDriver PMdriver = new MobileDriver();

		MobileDeviceFindOptions op = new MobileDeviceFindOptions();

		switch (device) {
		case Android: 

			op.setOS(MobileDeviceOS.ANDROID);


			break;

		case iOS: 
			op.setOS(MobileDeviceOS.IOS);


			break;


		default: System.out.println("no available  device");
		break;


		}


		List<IMobileDevice> devlist = PMdriver.findDevices(op);

		for (int i = 0 ; i <devlist.size() ; i++)
		{
			IMobileDevice dev = devlist.get(i);
			if (dev.getProperty(MobileDeviceProperty.IN_USE ).equals("false"))
				return dev;

		}
		return null;



	}
}
