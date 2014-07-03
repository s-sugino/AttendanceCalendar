package jp.co.jtec.atcal.calendar.model;

import java.util.Calendar;

public class DailyData {
	
	private Calendar calendar;
	
	public DailyData( int year, int month, int date ) {
		this.calendar = Calendar.getInstance();
		this.calendar.set(year, month-1, date);
	}
	
	public int getDate() {
		return this.calendar.get(Calendar.DATE);
	}
	
	public Calendar getCalendar() {
		return this.calendar;
	}
}
