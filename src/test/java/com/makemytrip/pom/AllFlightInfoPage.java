package com.makemytrip.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.baseclass.BaseClass;
import com.makemytrip.util.UtilFunctions;

public class AllFlightInfoPage extends BaseClass {

	public static WebDriver driver;

	//@FindBy(xpath = "//div[@id='ow-domrt-jrny']/div/div[contains(@class,'fli-list splitVw-listing ')]")
	//private List<WebElement> allFlightInfo;

	@FindBy(xpath = "(//div[@class='paneView'])[1]//descendant::div//descendant::div[@class='listingCard ']//span/span[@class='boldFont blackText']")
	private List<WebElement> flightName;

	@FindBy(xpath = "(//div[@class='paneView'])[1]//descendant::div//descendant::div[@class='listingCard ']//descendant::div[@class='flexOne timeInfoLeft']/p/span")
	private List<WebElement> deptTime;

	@FindBy(xpath = "(//div[@class='paneView'])[1]//descendant::div//descendant::div[@class='listingCard ']//descendant::div[@class='stop-info flexOne']/p")
	private List<WebElement> duration;

	@FindBy(xpath = "(//div[@class='paneView'])[1]//descendant::div//descendant::div[@class='listingCard ']//descendant::div[@class='makeFlex column relative splitfare ']/p")
	private List<WebElement> amount;

	public AllFlightInfoPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	//public List<WebElement> getallFlightInfo() {
	//	return allFlightInfo;
	//}

	public List<WebElement> getFlightName() {
		return flightName;
	}

	public List<WebElement> getDeptTime() {
		return deptTime;
	}

	public List<WebElement> getDuration() {
		return duration;
	}

	public List<WebElement> getAmount() {
		return amount;
	}

}
