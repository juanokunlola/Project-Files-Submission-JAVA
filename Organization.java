package javaTrashTracker;

import java.time.DayOfWeek;

public class Organization extends User {
	
	private DayOfWeek collectionDay = DayOfWeek.MONDAY;
	private DayOfWeek recycleDay = DayOfWeek.TUESDAY;
	
	public Organization(String user, String password, DayOfWeek collectionDay, DayOfWeek recycleDay) {
		super(user, password);
		this.collectionDay = collectionDay;
		this.recycleDay = recycleDay;
	}
	
	//GUI Input for Organizations to update their Trash Collection Days [UNFINISHED]
	public void updateCollectionDay(DayOfWeek newCollectionDay) {
		setCollectionDay(newCollectionDay);
	}
	
	//GUI Input for Organizations to update their Recycle Collection Days [UNFINISHED]
	public void updateRecycleDay(DayOfWeek newRecycleDay) {
		setRecycleDay(newRecycleDay);
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
