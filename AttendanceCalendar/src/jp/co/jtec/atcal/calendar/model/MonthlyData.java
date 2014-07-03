package jp.co.jtec.atcal.calendar.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class MonthlyData {

	private int year;
	
	private int month;
	
	private ArrayList<WeeklyData> weeklyDataList;
	
	public MonthlyData( int year, int month ) {
		
		this.year = year;
		this.month = month;
		this.weeklyDataList = new ArrayList<WeeklyData>();
		
		this.generate( year, month );
	}
	
	private void generate( int year, int month ) {

		int date = 1;
		Calendar cal = Calendar.getInstance();
		
		WeeklyData weeklyData = new WeeklyData( 0 );
		weeklyDataList.add( weeklyData );
		cal.set(year, month-1, date);
		
		while ( month == cal.get(Calendar.MONTH) + 1 ) {
			weeklyData.put( new DailyData(year, month, date) );
			if ( cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ) {
				weeklyData = new WeeklyData( cal.get(Calendar.WEEK_OF_MONTH) );
				weeklyDataList.add( weeklyData );
			}
			cal.set( Calendar.DATE, ++date );		
		}
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getWeekOfMonth() {
		return this.weeklyDataList.size();
	}
	
	public Calendar getCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set( this.year, (this.month-1), 1 );
		return cal;
	}
	
	public WeeklyData getWeeklyData( int weekOfMonth ) {
		return this.weeklyDataList.get(weekOfMonth);
	}
	
	public Iterator<WeeklyData> iterator() {
		return this.weeklyDataList.iterator();
	}
}
