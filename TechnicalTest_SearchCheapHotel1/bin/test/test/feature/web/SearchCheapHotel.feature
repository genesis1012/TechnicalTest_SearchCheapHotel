#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>


@tag
Feature: Room Reservation
  I want to validate that the price charged to customers is correct for each of the destinations

    Background: The user starts out on the login page
        Given the user is on the DX HOTEL page

    Scenario Outline: The user searches for the cheapest room for each destination

         When The user searches for a room in <Location> for the dates from <CheckIn> to <CheckOut>
         And the user selects the hotel with the most economical room
         Then the user validates that the correct price 

         Examples:
         |Location			| CheckIn 	| CheckOut 	|
         |Los Angeles		| 2019/12/29|	2019/12/31|
         |San Francisco	| 2019/12/25|	2019/12/30|
         |Las Vegas			| 2019/12/25|	2019/12/30|
         |Honolulu			| 2019/12/25|	2019/12/30|
         |New York			| 2019/12/25|	2019/12/30|
         |Nassau				| 2019/12/25|	2019/12/30|
         |Paris					| 2019/12/25|	2019/12/30|
         |London				| 2019/12/25|	2019/12/30|
         |Rome					| 2019/12/25|	2019/12/30|
         |Hamburg				| 2019/12/25|	2019/12/30|
