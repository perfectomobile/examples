Examples
========

<a href="http://www.perfectomobile.com/">Perfecto Mobile</a> provides mobile app developers and quality assurance teams a hosted device lab and write-once-run-anywhere test automation for native, hybrid and mobile web apps. 

This repository contains code samples use our <a href="http://help.perfectomobile.com/article/AA-02326/">WebDriver implementation</a> and demonstrates execution with several test frameworks

<table border="1">
<tr>
<td>FileName</td>
<td>Description</td>
</tr>
<tr>
<td>HelloWorld</td>
<td>
Basic code which shows how to work with perfecto cloud, select a device and execute simple webDriver test.
The test open google and search for Perfecto Mobile.
    <br><b>prerequisite</b>: install Perfecto mobile add-in to Eclipse follow these <a href="http://help.perfectomobile.com/article/AA-02275/259/Guides-Documentation/Selenium/MobileCloud-WebDriver-MobileCloud-for-Eclipse-December-2013.html/">instructions</a>
 
</td>
</tr>
<tr>
<td>JUNITExample</td>
<td>
    Write your own JUnit with Perfecto Mobile:
    This example shows how to run Perfecto Mobile test on a real device as a JUnit.
    It also contains the option to provide the device ID as parameter
</td>
</tr>
<tr>
<td>JunitBOFAApp</td>
<td>
    This example shows how to execute test on real mobile with native application using visual object only (OCR objects)
    <br><b>prerequisite</b>: install bofa on the iphone device
</td>
</tr>
<tr>
<td>JUnitedWeb</td>
<td>
    This example shows how to run test on website using DOM object and Visual objects for validation. All based on webdriver interface and can be executed on any device in perfecto mobile system.
</td>
</tr>
<tr>
<td>uploadAndInstallApp</td>
<td>
    This code example shows how to use Perfecto Mobile driver to upload and install applications (.ipa or .apk) from local PC to <b>real devices</b> 
</td>
</tr>
<tr>
<td>TestNG</td>
<td>
    This code example shows how to run TestNG script on real devices in Perfecto Mobile cloud
</tr>
<tr>
<td>PerfectoCucumber</td>
<td>
    This code shows how to run Cucumber (JVM) test on real device in Perfecto Mobile cloud.
    The test open the post office web page and validate specific zip code.  
    The folder contains four files:<br>
    <b>PostOffice.Feature</b> the test case description in English. <br>
    <b>PostofficeDefs.java</b> the test case translator between the feature file and the test implementation. <br>
    <b>PostOffice.java</b> The java code which execute the test on the device in Perfecto Mobile cloud. <br>
    <b>RunCukesTest.java</b> the test executer  
</tr>
 <tr>
<td>getDOM</td>
<td>
    This code shows how to get the DOM object to your code.
</tr>
 <tr>
<td>ExecuteJavaScrip</td>
<td>
    This codes executes Java script on web on real devices.
</tr>
<td>executeLowLevelAPI </td>
<td>
    Perfecto Mobile provides HTTP API which allows the customer to execute any command on perfecto mobile cloud and on any device in the cloud.
    This code describes how to work with the API, as an example the code execute SMSme command on real device.
</td>    
</tr>
<tr>
<td> Download report and report attachments</td>
<td>
    Demonstrates how to download the Perfecto Mobile report to a specified location; and the report attachments.
</td>
</tr>
<tr>
<td> Parallel Script Execution</td>
<td>
    Demonstrates how to execute script on number of devices using Java Executor Interface.  
</td>
</tr>
<tr>
<td> APK and IPA files upload from PC to cloud folders</td>
<td>
    Demonstrates how to upload files from user PC to cloud folders.   
</td>
</tr>
<td> Install APK or IPA file across a list of devices</td>
<td>
    Using findDevices function (based on Manufacturer), opens List of devices and installs appropriate Application on device.   
</td>
</tr>
<tr>
<td> Using JUnit Annotations</td>
<td>
    Using @BeforeClass and @AfterClass JUnit Annotations
</td>
</tr>
<tr>
<td> Work with device reservation</td>
<td>
   Create,update,delete reservations
</td>
</tr>
<tr>
<td> getObjectList</td>
<td>
Get list of objects with specific property and manipulate it in the code, in this example (carmax.com) all the car items have the class <b>ui-link-inherit</b> and one command bring all the items to java List.
 <a href="http://blog.perfectomobile.com/2014/03/20/1872/">more details</a>
</td>
</tr>
<tr>
<td>DeviceFactory</td>
<td>
This factory return the next available device in Perfecto Mobile cloud based on the OS (Android or iOS)
</td>
</tr>
<tr>
<td>UISelect</td>
<td>
work with dropdown menu<br> 
the code contains to classes:<br>
1.	<b>execSelectTest</b> – main class which execute the test on the American express web page.<br>
2.	<b>PMUISelect</b> – drop down object manager.<br>

How to use it:<br>

Find to object with xpath:<br>
WebElement item  = webdriver.findElement(By.xpath("//*[@id='manage']"));<br>

Create new PMUISelect objwct with this item and the WebDriver (dom) <br>
PMUISelect sel = new PMUISelect(item,webdriver);<br>

Select the iteam by text or index <br>
	sel.selectByIndex(2);<br>
	sel.selectByVisibleText("Merchant Account");<br>
</td>
</tr>


</table>
