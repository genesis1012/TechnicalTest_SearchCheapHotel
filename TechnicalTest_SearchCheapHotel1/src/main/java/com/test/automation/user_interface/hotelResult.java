package com.test.automation.user_interface;

import org.openqa.selenium.By;
     
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class hotelResult extends PageObject{
	public static final Target HOTEL = Target.the("Hotel")
			.locatedBy("//*[@data-options=\"dxContentPlaceholder: { name: 'content' } \"]/div[contains(@class,'dx-active-view')]//*[@class='hotels-data'][{0}]//*[@class='dx-button-content']");
	
	public static final Target RESULT_PAGES = Target.the("Result Pages")
			.locatedBy("//*[@class='external-for-plagination']//*[@class='pagination']/div");
	
	public static final Target ROOM_PRICE = Target.the("Room Price")
			.located(By.className("rate-number"));
	
//	public final List<WebElementFacade> tabs = findAll(By.className("rate-number"));
//	
//	public List<WebElementFacade> getJobTabs() {
//		String precio = "";
//        List<WebElementFacade> tabs = findAll("//*[@class='night-button']");
//        
//        for(WebElementFacade row : tabs) {
//        	precio = row.find(By.className("rate-number")).getText();
//        	System.out.print(precio);
//        }
//        
//        return tabs;
//    }

}
