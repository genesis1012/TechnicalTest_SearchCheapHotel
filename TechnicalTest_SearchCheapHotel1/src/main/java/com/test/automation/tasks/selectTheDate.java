package com.test.automation.tasks;

import static com.test.automation.user_interface.homePage.CHECK_IN;
import static com.test.automation.user_interface.homePage.CHECK_OUT;
import static com.test.automation.user_interface.homePage.DATE;
import static com.test.automation.user_interface.homePage.SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class selectTheDate implements Task{
	
	private String checkIn;
	private String checkOut;
	
	public selectTheDate (String CheckIn, String CheckOut) {
		this.checkIn = CheckIn;
		this.checkOut = CheckOut;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(CHECK_IN),
				Click.on(DATE.of(checkIn)));
		actor.attemptsTo(Click.on(CHECK_OUT),
				Click.on(DATE.of(checkOut)));
		actor.attemptsTo(Click.on(SEARCH));
	}

	public static Performable ofStayBetween(String checkIn2, String checkOut2) {
		return instrumented(selectTheDate.class, checkIn2, checkOut2);
	}
	
	

}
