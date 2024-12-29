package com.abcShopApp.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println("Today's date is :"+today);
		
		LocalDate dob=LocalDate.of(2000, 10, 07);
		System.out.println("DOB :"+dob);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Current date and time"+dateTime);
		
		//Date manipulation
		LocalDate todayDate = LocalDate.now();
		
		LocalDate afterDays=todayDate.plusDays(35);
		
		System.out.println("After 35 days date is :"+afterDays);
		
		//task : input is date of birth ; output is calculate age

		int age= calculateAge(dob,today);
		System.out.println("The age according to DOB is "+age+" years");
		
	}
	public static int calculateAge(LocalDate dob,LocalDate currentDate) {
		if((dob!=null) && (currentDate!=null)) {
			return Period.between(dob, currentDate).getYears();
		}else {
			throw new IllegalArgumentException("Date of birth and current date should not be null");
		}
	}

}
