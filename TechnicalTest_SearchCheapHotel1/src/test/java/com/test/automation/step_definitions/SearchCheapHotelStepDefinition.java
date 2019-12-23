package com.test.automation.step_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.test.automation.questions.totalPayForTheRoom;
import com.test.automation.tasks.openWeb;
import com.test.automation.tasks.selectHotelWith;
import com.test.automation.tasks.selectTheCity;
import com.test.automation.tasks.selectTheDate;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class SearchCheapHotelStepDefinition {
	
	@Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }
	
	@Given("^the user is on the DX HOTEL page$")
	public void the_user_is_on_the_DX_HOTEL_page() {
		theActorCalled("Heri").wasAbleTo(openWeb.HomePage());
	}

	@When("^The user searches for a room in (.*) for the dates from (.*) to (.*)$")
	public void the_user_searches_for_a_room_in_for_the_dates_from_to(String Location, String CheckIn, String CheckOut) {
		theActorInTheSpotlight().attemptsTo(selectTheCity.Of(Location));
		theActorInTheSpotlight().attemptsTo(selectTheDate.ofStayBetween(CheckIn, CheckOut));
	}

	@And("^the user selects the hotel with the most economical room$")
	public void the_user_selects_the_hotel_with_the_most_economical_room() {
		theActorInTheSpotlight().attemptsTo(selectHotelWith.cheaperPrice());
	}

	@Then("^the user validates that the correct price$")
	public void the_user_validates_that_the_correct_price() {
		theActorInTheSpotlight().should(seeThat(totalPayForTheRoom.isCorrect()));
	}

}
