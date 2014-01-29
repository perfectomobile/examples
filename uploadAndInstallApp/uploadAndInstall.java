

import java.io.File;

import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;


public class uploadAndInstall {


	public static void main(String[] args) {
		String device = Constants.DEVICE;
		String host = Constants.PM_CLOUD;
		String user = Constants.PM_USER;
		String password = Constants.PM_PASSWORD;
		MobileDriver d = new MobileDriver(host, user, password);
		
		uploadfilewithPM(d);
		installAppOnDevice(d,device);

		d.quit();
	  
 	}

	 
	private static void uploadfilewithPM(MobileDriver driver ) {

		String host = Constants.PM_CLOUD;
		String user = Constants.PM_USER;
		String password = Constants.PM_PASSWORD;
		MobileDriver d = new MobileDriver(host, user, password);
		File app = new File(Constants.WORK_LIB+Constants.APP_NAME);
		driver.uploadMedia(Constants.REPOSITORY_KEY, app);
		
		
	}
	private static void installAppOnDevice(MobileDriver driver,String DeviceId ) {
		 IMobileDevice device = driver.getDevice(DeviceId);
		 device.installApplication(Constants.REPOSITORY_KEY); 
		
	}


}
