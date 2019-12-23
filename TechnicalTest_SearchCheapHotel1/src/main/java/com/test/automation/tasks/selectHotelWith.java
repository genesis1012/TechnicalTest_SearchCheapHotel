package com.test.automation.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.ArrayList;
import java.util.List;

import static com.test.automation.user_interface.hotelResult.RESULT_PAGES;
import static com.test.automation.user_interface.hotelResult.ROOM_PRICE;
import static com.test.automation.user_interface.hotelResult.HOTEL;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class selectHotelWith implements Task{
	
	private ArrayList<Integer> cheapestHotel = new ArrayList<Integer>();

	@Override
	public <T extends Actor> void performAs(T actor) {
		List<WebElementFacade> listPages = RESULT_PAGES.resolveAllFor(actor);
		int numPage = 1;
		if(RESULT_PAGES.resolveFor(actor).isVisible()) {
			for(WebElementFacade row : listPages ) {
				actor.attemptsTo(Click.on(RESULT_PAGES.getCssOrXPathSelector()+ "//*[text()='"+numPage+"']"));
				getMinPrice(actor,numPage);		
				numPage++;
			}
		}else {
			getMinPrice(actor,numPage);
		}

		if(RESULT_PAGES.resolveFor(actor).isVisible()) {
			actor.attemptsTo(Click.on(RESULT_PAGES.getCssOrXPathSelector()+ "//*[text()='"+cheapestHotel.get(0)+"']"));
		}
		actor.attemptsTo(Click.on(HOTEL.of(cheapestHotel.get(1).toString())));
		
	}
	
	private void getMinPrice(Actor actor, int page) {
		List<WebElementFacade> listObjeto = ROOM_PRICE.resolveAllFor(actor);
		int min = 0;
		int count=1;
		for(WebElementFacade row : listObjeto ) {
	    	int priceMin = Integer.parseInt(row.getText().substring(1, row.getText().length()));
	    	if(count == 1) {
            	min = priceMin;
            	cheapestHotel.clear();
            	cheapestHotel.add(page);
            	cheapestHotel.add(count);
            }else if(priceMin < min) {
                min = priceMin;
                cheapestHotel.clear();
                cheapestHotel.add(page);
            	cheapestHotel.add(count);
            }
	    	count++;
		}
	}

	public static selectHotelWith cheaperPrice() {
		return instrumented(selectHotelWith.class);
	}

}
