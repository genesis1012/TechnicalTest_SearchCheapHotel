package com.test.automation.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.test.automation.user_interface.homePage.SELECT_CITY;
import static com.test.automation.user_interface.homePage.LOCATION;

public class selectTheCity implements Task{
	
	private String location;
	
	public selectTheCity (String Location) {
		this.location = Location;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
			actor.attemptsTo(Click.on(SELECT_CITY),
					Click.on(LOCATION.of(location)));
	}

	public static selectTheCity Of(String location) {
		return instrumented(selectTheCity.class, location);
	}
}
