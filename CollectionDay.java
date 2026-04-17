package javaTrashTracker;


import java.time.*;


public class CollectionDay {

	private DayOfWeek collectionDay = DayOfWeek.FRIDAY;
	private DayOfWeek recycleDay = DayOfWeek.SATURDAY;
	private String stringCollectionDay = "";
	private String stringRecycleDay = "";
	
	
	public CollectionDay() {
		
	}

	
	public int checkCollectionDay() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		DayOfWeek currentDay = today.getDayOfWeek();
		DayOfWeek nextDay = tomorrow.getDayOfWeek();
		int dayCheck = 0;
		
		
		if(currentDay.equals(collectionDay)) {
			
			System.out.println("Trash is being collected today! Make sure to take out your trash.");
			dayCheck = 1;
		}
		else if(nextDay.equals(collectionDay)) {
			System.out.println("Trash is being collected tomorrow, don't forget to take out your trash!");
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

			System.out.println("Recycling is being collected today! Make sure to take out your recyclables.");
			dayCheck = 1;
		}
		else if(nextDay.equals(recycleDay)) {
			System.out.println("Recycling is being collected tomorrow, don't forget to take out your recyclables!");
			dayCheck = 2;
		}
		else{
			stringRecycleDay =  recycleDay.toString().charAt(0) + recycleDay.toString().substring(1).toLowerCase() + ".";
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
