package SeleniumBasics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	private void nullCheck(String value) {
		if (value == null) {
			throw new ElementException("The text field should not be null, plese pass some value.." + value);
		}
	}

	public void doSendKeys(By locator, String value) {
		nullCheck(value);
		doGetElement(locator).sendKeys(value);
	}

	public WebElement doGetElement(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element;
		} catch (NoSuchElementException e) {
			System.out.println("Element is not present on the page.." + locator);
			return null;
		}

	}
	
	public  boolean doIsDisplay(By locator) {
		try {
		boolean flag = doGetElement(locator).isDisplayed();
		System.out.println("Element is displayed.." +locator);
		return flag;
		}catch(NoSuchElementException e){
			System.out.println("Element is not displayed.. " +locator);
			return false;
		}
	}
	
	/**
	 * To validate the web element is displayed or not without using .isDisplayed()
	 * 
	 * @param locator
	 * @return
	 */
	
	public  boolean isElementsDisplayed(By locator) {
		int elementCount =getElements(locator).size();
		if(elementCount==1) {
			System.out.println("Single element is displayed.. ");
			return true;
		}
		else
		{
			System.out.println("Multiple/No elements are displayed..");
			return false;
		}
	}
	
	/**
	 * To validate the count of element displayed
	 * @param locator
	 * @param expectedElementCount
	 * @return boolean
	 */
	
	public  boolean isElementsDisplayed(By locator, int expectedElementCount) {
		int elementCount =getElements(locator).size();
		if(elementCount==expectedElementCount) {
			System.out.println("Element is displayed.. " +locator + " with the occurance of " +expectedElementCount );
			return true;
		}
		else
		{
			System.out.println("Multiple/No elements are displayed.." +locator + " with the occurance of " +expectedElementCount );
			return false;
		}
	}

	public void doClick(By locator) {
		doGetElement(locator).click();
	}

	public String doGetText(By locator) {
		return doGetElement(locator).getText();
	}

	public String doGetAttribute(By locator, String attributename) {
		return doGetElement(locator).getAttribute(attributename);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getElementCount(By locator) {
		return getElements(locator).size();
	}

	// WAF: to fetch the text of each link, text should not be empty/blank
	// name: getElementTextList
	// Parameter: By locator
	// Return: List<String>
	public List<String> getElementTextList(By locator) {
		List<WebElement> elemList = getElements(locator);
		List<String> elemTextList = new ArrayList<String>();

		for (WebElement e : elemList) {
			String text = e.getText();
			if (text.length() != 0) {
				elemTextList.add(text);
			}
		}

		return elemTextList;
	}

	// WAF: to fetch the text of each attribute, attribute should not be empty/blank
	// name: getElementAttributeList
	// Param: By locator
	// Return: List<String>

	public List<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> imageList = getElements(locator);
		List<String> attrList = new ArrayList<>();

		for (WebElement e : imageList) {
			String attrValue = e.getAttribute(attrName);

			if (attrValue != null && attrValue.length() != 0) {
				attrList.add(attrValue);
				System.out.println(attrValue);
			}
		}
		return attrList;
	}

	// ************************Select tag drop down Utils************

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(doGetElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(doGetElement(locator));
		select.selectByValue(value);
	}

	public void doSelectByVisibleText(By locator, String visibleText) {
		Select select = new Select(doGetElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public List<String> getDropDownOptionTextList(By locator) {
		Select select = new Select(doGetElement(locator));
		List<String> optionText = new ArrayList<>();
		List<WebElement> optionsList = select.getOptions();

		System.out.println("Number of options available in dropdown..." + optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionText.add(text);
		}
		return optionText;
	}

	public int getDropDownOptionSize(By locator) {
		Select select = new Select(doGetElement(locator));
		return select.getOptions().size();
	}
	
	public int getDropdownOptionSizeWithoutSelectClass(By locator) {
		List<WebElement> optionList = getElements(locator);
		return optionList.size();
	}

	public void selectValueFromDropdown(By locator, String optionText) {
		Select select = new Select(doGetElement(locator));

		List<WebElement> optionsList = select.getOptions();

		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(optionText.trim())) {
				e.click();
				break;
			}
		}
	}
	
	public void selectValueFromDropdownWithoutSelectClass(By locator, String optionValue) {
		List<WebElement> optionList = getElements(locator);
		for(WebElement e:optionList) {
			String text = e.getText();
			if(text.equals(optionValue)) {
				e.click();
			}
		}
	}
	
	public  void doSearch(By searchField, String searchValue, By suggestions, String value)
			throws InterruptedException {
		doSendKeys(suggestions, searchValue);
		Thread.sleep(3000);
		List<WebElement> suggestionList = getElements(suggestions);
		System.out.println("Number of suggestions:  " + suggestionList.size());
		for (WebElement e : suggestionList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) {
				e.click();
				break;
			}
		}
	}

}
