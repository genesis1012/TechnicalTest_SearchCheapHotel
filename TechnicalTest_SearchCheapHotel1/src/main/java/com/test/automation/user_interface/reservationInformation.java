package com.test.automation.user_interface;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class reservationInformation extends PageObject{
	
	public static final Target PRICE_PER_NIGHT = Target.the("Price per night")
			.locatedBy("//*[@class='total-pay']/h4[1]");
	
	public static final Target CHECK_IN = Target.the("Check In")
			.located(By.className("check-in"));
	
	public static final Target CHECK_OUT = Target.the("Check Out")
			.located(By.className("check-out"));
	
	public static final Target TOTAL_TO_PAY_NOW = Target.the("TOTAL TO PAY NOW")
			.located(By.className("total-price"));

}
