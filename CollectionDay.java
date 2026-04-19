package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The CollectionDay.java class contains the information for trash collection day recycling collection day in both DayOfWeek enum format and as strings.
 * 	It allows for comparing the current date of the user's system to the collection days, and returns based on whether the collection day is the current day, the 
 *  next day, or some other day of the week. It contains getters and setters for the collection days.
 * Called By: CheckCollectionDayWindow, CheckRecycleDayWindow
 * Contains:CollectionDay, checkCollectionDay(), checkRecycleDay(), getCollectionDay(), setCollectionDay(DayOfWeek collectionDay), getRecycleDay(), getRecycleDay()
 *  setRecycleDay(DayOfWeek recycleDay), getPrintableCollectionDay(), getPrintableRecycleDay()
 * */

import java.time.*;

public class CollectionDay {

	private DayOfWeek collectionDay;
	private DayOfWeek recycleDay;
	private String stringCollectionDay;
	private String stringRecycleDay;
	
	
	public CollectionDay() {	
		this.collectionDay = DayOfWeek.TUESDAY;
		this.recycleDay = DayOfWeek.SUNDAY;
		this.stringCollectionDay = collectionDay.toString().charAt(0) + collectionDay.toString().substring(1).toLowerCase();
		this.stringRecycleDay = recycleDay.toString().charAt(0) + recycleDay.toString().substring(1).toLowerCase();
	}

	
	public int checkCollectionDay() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		DayOfWeek currentDay = today.getDayOfWeek();
		DayOfWeek nextDay = tomorrow.getDayOfWeek();
		int dayCheck = 0;
		
		
		if(currentDay.equals(collectionDay)) {
			dayCheck = 1;
		}
		else if(nextDay.equals(collectionDay)) {
			dayCheck = 2;
		}
		else{
			stringCollectionDay = collectionDay.toString().charAt(0) + collectionDay.toString().substring(1).toLowerCase();
			dayCheck = 3;
		}
		return dayCheck;
	}

	public int checkRecycleDay() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		DayOfWeek currentDay = today.getDayOfWeek();
		DayOfWeek nextDay = tomorrow.getDayOfWeek();
		int dayCheck = 0;
		
		if(currentDay.equals(recycleDay)) {
			dayCheck = 1;
		}
		else if(nextDay.equals(recycleDay)) {
			dayCheck = 2;
		}
		else{
			stringRecycleDay =  recycleDay.toString().charAt(0) + recycleDay.toString().substring(1).toLowerCase();
			dayCheck = 3;
		}
		return dayCheck;
	}
	
	public DayOfWeek getCollectionDay() {
		return collectionDay;
	}

	public void setCollectionDay(DayOfWeek collectionDay) {
		this.collectionDay = collectionDay;
	}
	
	public DayOfWeek getRecycleDay() {
		return recycleDay;
	}

	public void setRecycleDay(DayOfWeek recycleDay) {
		this.recycleDay = recycleDay;
	}
	
	public String getPrintableCollectionDay(){
		return stringCollectionDay;
	}
	
	public String getPrintableRecycleDay(){
		return stringRecycleDay;
	}
	
}
