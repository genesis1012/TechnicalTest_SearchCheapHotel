package com.test.automation.user_interface;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://js.devexpress.com/Demos/DXHotels/#home")
public class homePage extends PageObject{
	
    
	
	@WhenPageOpens
	public void waitUntilMainElementsAppears() {
		getDriver().manage().window().maximize();
	}
	
	public WebDriver MyDriver() {
		return getDriver();
	}
	
	public static final Target SELECT_CITY = Target.the("Select City")
			.locatedBy("//*[contains(@id,'location')]");
	
	public static final Target LOCATION = Target.the("Location")
			.locatedBy("//*[@class='dx-scrollview-content']//*[text()='{0}']");
	
	public static final Target CHECK_IN = Target.the("Check In")
			.locatedBy("//*[@name='checkIn']//ancestor::div[1]//*[@class='dx-button-content']");
	
	public static final Target DATE = Target.the("Date")
			.locatedBy("//*[@aria-label='Calendar']//ancestor::div[contains(@style,'opacity: 1')]//*[@data-value='{0}' and @class=\"dx-calendar-cell\"]");
	
	public static final Target CHECK_OUT = Target.the("Check Out")
			.locatedBy("//*[@name='checkOut']//ancestor::div[1]//*[@class='dx-button-content']");
	
	public static final Target SEARCH = Target.the("Search")
			.locatedBy("//*[text()='SEARCH']");

}
