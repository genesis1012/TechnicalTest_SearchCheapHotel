package com.test.automation.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.test.automation.user_interface.homePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class openWeb implements Task{
	
	private homePage home;
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.wasAbleTo(Open.browserOn().the(home));
	}
	
	public static openWeb HomePage() {
		return instrumented(openWeb.class);
	}

}
