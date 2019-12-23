package com.test.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import java.text.ParseException;

import static com.test.automation.user_interface.reservationInformation.*;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class totalPayForTheRoom implements Question<Boolean>{

	@Override
	public Boolean answeredBy(Actor actor) {
		String totalToPayText = Text.of(TOTAL_TO_PAY_NOW).viewedBy(actor).asString();
		double totalToPay = Double.parseDouble(totalToPayText.substring(1, totalToPayText.length()));
		
		double totalPay = getTotalToBuy(actor);
		System.out.println(totalPay +" - - "+totalToPay);
		if(totalPay == totalToPay) {
			return true;
		}else {
			return false;
		}
	}
	
	private double getTotalToBuy(Actor actor) {
		String pricePerNightText = Text.of(PRICE_PER_NIGHT).viewedBy(actor).asString();
		
		String checkIn = Text.of(CHECK_IN).viewedBy(actor).asString();
		String checkOut = Text.of(CHECK_OUT).viewedBy(actor).asString();
		double pricePerNight = Double.parseDouble(pricePerNightText.substring(1, pricePerNightText .length()));
		
		
		String[] partsIn = checkIn.split("/");
		checkIn = partsIn[1] +"/"+ partsIn[0] +"/"+ partsIn[2];
		String[] partsOut = checkOut.split("/");
		checkOut = partsOut[1] +"/"+ partsOut[0] +"/"+ partsOut[2];
		
		Date dateIn = getDate(checkIn);
		Date dateOut = getDate(checkOut);
		
		double days =  getDaysDifference(dateIn,dateOut);
		
		double totalPay = (days+1) * pricePerNight;

		return totalPay;
	}
	
	private Date getDate(String Date) {
		Date date1 = new Date();
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(Date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    return date1;
	}
	
	private double getDaysDifference(Date dateIn, Date dateOut) {
		double dias=(int) ((dateOut.getTime()-dateIn.getTime())/86400000);
		return dias;
	}

	public static totalPayForTheRoom isCorrect() {
		return new totalPayForTheRoom();

	}

}
