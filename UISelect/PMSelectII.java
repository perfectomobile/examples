import org.openqa.selenium.WebDriver;

import com.perfectomobile.selenium.api.IMobileWebDriver;


public class PMSelectII {


	IMobileWebDriver _webdriver =null;
	boolean _identifiedByName = false;
	String _field;

	public PMSelectII(WebDriver d,String fieldID)
	{
		this (d,fieldID,false);
	}

	public PMSelectII(WebDriver d,String fieldID,boolean byname) {
		_webdriver =(IMobileWebDriver) d;
		_field=fieldID;
		_identifiedByName = byname;
	}


	public void selectElementbyVal(String val)
	{
		if (_identifiedByName)
		{
			_webdriver.executeScript(selectNameByVal(val,_field)+refreshString())  ;

		}else
		{		
			_webdriver.executeScript(selectByVal(val,_field)+refreshString())  ;
		}
	}

	public void selectElementByIndex(int index) {
		if (_identifiedByName)
		{
			_webdriver.executeScript(selectNameByIndex(index,_field)+refreshString())  ;

		}else
		{		
			_webdriver.executeScript(selectByIndex(index,_field)+refreshString())  ;
		}

	}


	private static String selectByVal(String val,String fieldID )
	{
		String script = "lc = document.getElementById('"+fieldID+"');"+
				"for (i=0; i<lc.options.length; i++)"+
				"{   "+
				"	if (lc.options[i].value.localeCompare(\""+val+"\")==0)"+
				"	{"+
				" 		lc.selectedIndex = i; "+
				"	}"+
				"}";

		return script;
	}

	private static String selectByIndex(int i,String fieldID)
	{
		String script = "lc = document.getElementById('"+fieldID+"');"+
				"lc.selectedIndex= "+i+";" ;

		return script;
	}
	private static String selectNameByVal(String val,String fieldID )
	{
		String script = "lc = document.getElementsByName('"+fieldID+"')[0];"+
				"for (i=0; i<lc.options.length; i++)"+
				"{   "+
				"	if (lc.options[i].value.localeCompare(\""+val+"\")==0)"+
				"	{"+
				" 		lc.selectedIndex = i; "+
				"	}"+
				"}";

		return script;
	}

	private static String selectNameByIndex(int i,String fieldID)
	{
		String script = "lc = document.getElemenstByName('"+fieldID+"')[0];"+
				"lc.selectedIndex= +i+;" ;

		return script;
	}

	private static String refreshString()
	{
		String script ="  "+
				"if (\"createEvent\" in document) "+
				"    {"+
				"    	var evt = document.createEvent(\"HTMLEvents\");"+
				"   	evt.initEvent(\"change\", false, true);"+
				"   	lc.dispatchEvent(evt);"+
				"   }"+
				" else"+
				" 	lc.fireEvent(\"onchange\");";
		return script;


	}
}


