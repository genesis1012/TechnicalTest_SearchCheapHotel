package com.test.automation.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/test/feature/web/SearchCheapHotel.feature",
				glue = "com.test.automation.step_definitions")
public class SearchCheapHotelTestRunners {

}
