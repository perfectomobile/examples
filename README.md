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
    Write your own JUnit with perfecto mobile:
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
    This example shows how to run test on website useing DOM object and Visual objects for validation.
    All based on webdriver interface and can be executed on any device in perfecto mobile system 
</td>
</tr>
<tr>
<td>uploadAndInstallApp</td>
<td>
    This code example shows how to use perfecto mobile driver to upload and install applicaitons (.ipa or .apk) from local PC to <b>real devices</b> 
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
    This code showes how to run cucmber (JVM) test on real device in perfectomobile cloud.
    the test open the post office web page and vlaidate spcific zip code.
    The folder contains four files:<br>
    <b>PostOffice.Feature</b> the test case description in english. <br>
    <b>PostofficeDefs.java</b> the test case translator between the feature file and the test implementation. <br>
    <b>PostOffice.java</b> The java code which execute the test on the device in Perfecto Mobile cloud. <br>
    <b>RunCukesTest.java</b> the test executer  
</tr>
 
</table>
