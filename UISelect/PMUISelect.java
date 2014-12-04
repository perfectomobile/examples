import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import com.perfectomobile.selenium.api.IMobileWebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Models a SELECT tag, providing helper methods to select and deselect options.
 */
public class PMUISelect {

	private  WebElement _element = null;
	private  String _xpath = null;
	private  boolean isMulti =false;
	private  List<String> _listByValue = new   ArrayList<String>();
	private  List<String> _listBytext = new   ArrayList<String>();
	private IMobileWebDriver webdriver =null;
	private String elementID =null;
	private String nameID =null;

	public PMUISelect(WebElement element,WebDriver w)  
	{
		this(element,w,null);
	}

	public PMUISelect(WebElement element,WebDriver w,String Xpath) {
		String tagName = element.getTagName();
		_xpath = Xpath;
		webdriver = (IMobileWebDriver)w;
		if (null == tagName || !"select".equals(tagName.toLowerCase())) {
			throw new UnexpectedTagNameException("select", tagName);
		}

		_element = element;
		String value = element.getAttribute("multiple");
		// The atoms normalize the returned value, but check for "false"
		isMulti = (value != null && !"false".equals(value));

		// get the element ID for all the js
		nameID	=_element.getAttribute("name");



		// loop over the option and build element map


		// refresh the element if other select affected it 
		webdriver.executeScript(getRefreshJS());

		for (WebElement option : getOptions()) {
		//	_listByValue.add(option.getAttribute("value"));
		//	_listBytext.add(option.getText());
		}
	}

	/**
	 * @return Whether this select element support selecting multiple options at the same time? This
	 *         is done by checking the value of the "multiple" attribute.
	 */
	public boolean isMultiple() {
		return isMulti;
	}

	/**
	 * @return All options belonging to this select tag
	 */
	public List<WebElement> getOptions() {

		if (_xpath == null)
		{
			return _element.findElements(By.tagName("option"));
		}
		else
		{
			String listXpath = _xpath+"//child::*";
			return _element.findElements(By.xpath(listXpath));
		}
		// //*[@name='productName']/child::* 


	}

	/**
	 * @return All selected options belonging to this select tag
	 */
	private List<WebElement> getAllSelectedOptions() {
		List<WebElement> toReturn = new ArrayList<WebElement>();


		for (WebElement option : getOptions()) {
			if (option.isSelected()) {
				toReturn.add(option);
			}
		}

		return toReturn;
	}

	/**
	 * @return The first selected option in this select tag (or the currently selected option in a
	 *         normal select)
	 */
	private WebElement getFirstSelectedOption() {

		throw new NoSuchElementException("No options are selected");
	}


	public void selectByVisibleText(String text) {
		int i = 0;
		for (String val :_listBytext) {
			if (val.equals(text)) 
			{
				selectByIndex(i);
			}
			i++;
		}
	}


	public void selectByIndex(int index) {


		if (elementID!=null)
		{

			webdriver.executeScript("document.getElementById(\""+elementID+"\").options["+index+"].selected=false");
			webdriver.executeScript("document.getElementById(\""+elementID+"\").options["+index+"].selected=true");

		} else
		{
 			webdriver.executeScript("document.getElementsByName(\""+nameID+"\")[0].options["+index+"].selected=false");
			webdriver.executeScript("document.getElementsByName(\""+nameID+"\")[0].options["+index+"].selected=true");

		}

		webdriver.executeScript(getRefreshJS());

	}


	public void selectByValue(String value) {
		int i = 0;
		for (String val :_listByValue) {
			if (val.equals(value)) 
			{
				selectByIndex(i);
			}
			i++;
		}
	}


	public void deselectAll() {
		if (!isMultiple()) {
			throw new UnsupportedOperationException(
					"You may only deselect all options of a multi-select");
		}

		for (  int i = 0; i<getOptions().size(); i++) {
			webdriver.executeScript("document.getElementById(\""+elementID+"\").options["+i+"].selected=false");
		}
	}

	public void deselectByValue(String value) {
		int i = 0;
		for (String val :_listByValue) {
			if (val.equals(value)) 
			{
				deselectByIndex(i);
			}
			i++;
		}
	}

	public void deselectByIndex(int index) {
		webdriver.executeScript("document.getElementById(\""+elementID+"\").options["+index+"].selected=fatrue");
		webdriver.executeScript("document.getElementById(\""+elementID+"\").options["+index+"].selected=false");
		webdriver.executeScript(getRefreshJS());

	}

	public void deselectByVisibleText(String text) {
		int i = 0;
		for (String val :_listBytext) {
			if (val.equals(text)) 
			{
				deselectByIndex(i);

			}
			i++;
		}

	}


	// mine

	private String getRefreshJS()
	{
		String script = " if (\"createEvent\" in document) {"+
				"var evt = document.createEvent(\"HTMLEvents\");"+
				"evt.initEvent(\"change\", false, true);"+
				"document.getElementById(\""+elementID+"\").dispatchEvent(evt);"+
				"}"+
				"else"+
				"	document.getElementById(\""+elementID+"\").fireEvent(\"onchange\");";

		return script;
	}


}
