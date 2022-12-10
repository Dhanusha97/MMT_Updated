package com.makemytrip.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.baseclass.BaseClass;
import com.makemytrip.util.UtilFunctions;

public class HomePage extends BaseClass {

	public static WebDriver driver;

	@FindBy(xpath = "//a[contains(@href,'www.makemytrip.com/flights')]/span[contains(@class,'chFlights')]")
	private WebElement flightsMenu;

	@FindBy(xpath = "//li[contains(text(),'Round Trip')]")
	private WebElement roundTripMenu;

	@FindBy(xpath = "//input[@id='fromCity']")
	private WebElement fromCity;

	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement enterFromCity;

	@FindBy(xpath = "//div[@role='listbox']//descendant::p[text()]")
	private List<WebElement> suggestionFromList;

	@FindBy(xpath = "//input[@id='toCity']")
	private WebElement toCity;

	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement enterToCity;

	@FindBy(xpath = "//div[@role='listbox']//descendant::p[text()]")
	private List<WebElement> suggestionToList;
	
	@FindBy(xpath = "//span[text()='DEPARTURE']")
	private WebElement departureDate;
	
	@FindBy(xpath = "//span[text()='RETURN']")
	private WebElement returnDate;

	@FindBy(xpath = "//div[contains(@class,'dateFiled')][1]")
	private WebElement departureDrop;

	@FindBy(xpath = "//div[contains(@class,'dateFiled')][2]")
	private WebElement returnDrop;

	//String departureDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";
	//String returnDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";

	@FindBy(xpath = "//a[contains(@class,'widgetSearchBtn') and text()='Search']")
	private WebElement searchBtn;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFlightsMenu() {
		return flightsMenu;
	}

	public WebElement getRoundTripMenu() {
		return roundTripMenu;
	}

	public WebElement getFromCityDrop() {
		return fromCity;
	}

	public List<WebElement> getsuggestionFromList() {
		return suggestionFromList;
	}

	public WebElement getDepartureDrop() {
		return departureDrop;
	}

	public WebElement getReturnDrop() {
		return returnDrop;
	}

	public WebElement getDepartureDate() {
		return departureDate;
	}

	public WebElement getReturnDate() {
		return returnDate;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void selectFlightsMenu() {
		Actions ac = new Actions(driver);
		ac.moveToElement(flightsMenu).click().perform();
		flightsMenu.click();
	}

	public void selectRoundtripMenu() {
		roundTripMenu.click();
	}

	public void enterDepartureCity(String city) throws InterruptedException {
		fromCity.click();
		enterFromCity.sendKeys(city);
		Thread.sleep(1000);
		List<WebElement> suggestionFromList1 = suggestionFromList;
		for (WebElement suggestion : suggestionFromList1) {
			if (suggestion.getText().contains(city)) {
				suggestion.click();
				break;
			}
		}
		Thread.sleep(1000);
	}

	public void enterReturnCity(String city) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(toCity));
		toCity.click();
		enterToCity.sendKeys(city);
		Thread.sleep(1000);
		List<WebElement> suggestionToList2 = suggestionToList;
		for (WebElement suggestion : suggestionToList2) {
			if (suggestion.getText().contains(city)) {
				suggestion.click();
				break;
			}
		}
		Thread.sleep(1000);
	}

	public void enterDepartureDate() throws Exception {
		departureDate.click();
		departureDrop.click();
		UtilFunctions date = UtilFunctions.getCurrentAndReturnDates();
	//	driver.findElement(UtilFunctions.customXpath(departureDate, date.departureDate)).click();
	}
	
	public void enterReturnDate() throws Exception {
		returnDate.click();
		returnDrop.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@role='gridcell' and @aria-selected='true' ])[2]")).click();
		UtilFunctions date = UtilFunctions.getCurrentAndReturnDates();
	//	driver.findElement(UtilFunctions.customXpath(returnDate, date.returnDate)).click();
	}
	/*
	 * public FlightInfoPage search() { searchBtn.click();
	 * driver.manage().deleteAllCookies(); return new FlightInfoPage(); }
	 */

}
