package gridTools;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class downloadFile {

	RemoteWebDriver _driver;
	By name = By.id("Name");
	By Lname = By.id("LName");
	By Title = By.id("Title");
	By Age = By.id("Age");
	By EMail = By.id("EMail");
	By EMail2 = By.id("EMail2");
	By Pass1 = By.id("Pass1");
	By Pass2 = By.id("Pass2");
	By Mob = By.id("Mob");
	By Hom = By.id("Hom");
	By add = By.id("add");
	By add2 = By.id("add2");
	By City = By.id("City");
	By Country = By.id("Country");
	By Howfound = By.id("Howfound");
	By Other = By.id("Other");
	By futureoffers = By.id("futureoffers"); //checkbox
	By Tnc = By.id("Tnc");  //checkbox
	By saveForm = By.id("saveForm");  //submit
	By ERROR = By.xpath("//*[contains(text(),'Form not submitted')]");


	public downloadFile(WebDriver driver) {
		_driver = (RemoteWebDriver) driver;
	}


	public void editForm() {
		File inputWorkbook = new File("C:\\aaa\\CustomersTest\\GTFilmDataDriven.xls");
		Workbook w;
		boolean pass = true;

		try {
			String title = "";
			String cellVal = "";
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			// start from 1 > don't want to run on title raw
			for (int rowNum = 1; rowNum < sheet.getRows(); rowNum++) {
				//for (int rowNum = 1; rowNum < 2; rowNum++) {

				_driver.get("http://grid-tools-downloads.com/testpages/form2.html");
				Assert.assertTrue(_driver.findElement(name).isDisplayed() , "The login form is not presented");

				//create DC per line 

				for (int col = 0; col < sheet.getColumns(); col++) { 
					Cell cell = sheet.getCell(col,rowNum);
					title = sheet.getCell(col, 0).getContents();
					cellVal = cell.getContents();
					if (!cellVal.equals(""))
					{
						System.out.println("Add " + title + " " + cellVal);
						switch (title) {
						case "flow_nam":
							type(cellVal,name);
							break;
						case "LName":
							type(cellVal,Lname);
							break;
						case "Age":
							type(cellVal,Age);
							break;
						case "City":
							type(cellVal,City);
							break;
						case "Country":
							type(cellVal,Country);
							break;
						case "Hom":
							type(cellVal,Hom);
							break;
						case "Mob":
							type(cellVal,Mob);
							break;
						case "Howfound":
							type(cellVal,Howfound);
							break;
						case "Pass1":
							type(cellVal,Pass1);
							break;
						case "Pass2":
							type(cellVal,Pass2);
							break;
						case "add1":
							type(cellVal,add2);
							break;
						case "add2":
							type(cellVal,add2);
							break;
						case "futureoffers":
							type(cellVal,futureoffers);
							break;
						case "Title":
							type(cellVal,Title);
							break;
						case "expected_results":

							if (cellVal.equals("Validation Should Fail")) 
							{
								pass=false;
							}
							else
							{	
								pass = true;
							} 


							break;

						default:
							break;
						}
					}
				}
			}

			click(saveForm);
			if (pass)
			{

			}
			else
			{
				Assert.assertTrue(_driver.findElement(ERROR).isDisplayed() , "The login form is not presented");
			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public WebElement find(By locator) { return _driver.findElement(locator); }

	public void click(By locator) { find(locator).click(); }

	public void type(String inputText, By locator) { find(locator).sendKeys(inputText); }

	public void close() {_driver.quit(); }

}


