package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The Organization.java class extends the basic User class, adding the days the organization collects trash and recycling.
 * Contains: Organization, getCollectionDay(), setCollectionDay(DayOfWeek collectionDay), getRecycleDay(), setRecycleDay(DayOfWeek recycleDay) 
 * */

import java.time.DayOfWeek;

public class Organization extends User {
	
	private DayOfWeek collectionDay = DayOfWeek.MONDAY;
	private DayOfWeek recycleDay = DayOfWeek.TUESDAY;
	
	public Organization(String user, String password, DayOfWeek collectionDay, DayOfWeek recycleDay) {
		super(user, password);
		this.collectionDay = collectionDay;
		this.recycleDay = recycleDay;
	}
	
	//getters + setters
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
	
}
