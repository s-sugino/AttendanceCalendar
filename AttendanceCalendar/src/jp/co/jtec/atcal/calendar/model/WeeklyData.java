package jp.co.jtec.atcal.calendar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class WeeklyData {
	
	public static final String SUN_ID = "Sun";
	public static final String MON_ID = "Mon";
	public static final String TUE_ID = "Tue";
	public static final String WED_ID = "Wed";
	public static final String THU_ID = "Thu";
	public static final String FRI_ID = "Fri";
	public static final String SAT_ID = "Sat";
	
	public static final List<String> dayOfWeeks() {
		return Arrays.asList( SUN_ID, MON_ID, TUE_ID, WED_ID, THU_ID, FRI_ID, SAT_ID );
	}
	
	private int weekOfMonth;
	
	private ArrayList<DailyData> dailyDataList;
	
	public WeeklyData( int weekOfMonth ) {
		this.weekOfMonth = weekOfMonth;
		List<DailyData> initList = Arrays.asList( null, null, null, null, null, null, null );
		this.dailyDataList = new ArrayList<DailyData>( initList );
	}
	
	public int getWeekOfMonth() {
		return this.weekOfMonth;
	}
	
	public void put( DailyData dailyData ) {
		Calendar day = dailyData.getCalendar();		
		int dayOfWeekID = day.get(Calendar.DAY_OF_WEEK) - 1;
		this.dailyDataList.remove( dayOfWeekID );
		this.dailyDataList.add( dayOfWeekID, dailyData );
	}
	
	public Iterator<DailyData> iterator() {
		return this.dailyDataList.iterator();
	}
	
	public DailyData get( int dayOfWeekID ) {
		if ( dayOfWeekID < 1 && 7 < dayOfWeekID ) {
			throw new IllegalArgumentException( "Daily Data Search: Illegal day of week." );
		}
		return this.dailyDataList.get( dayOfWeekID - 1 );
	}
	
	public DailyData get( String dayOfWeek ) {
		int dayOfWeekID = 0;
		switch ( dayOfWeek ) {
		case SUN_ID: dayOfWeekID = Calendar.SUNDAY;    break;
		case MON_ID: dayOfWeekID = Calendar.MONDAY;    break;
		case TUE_ID: dayOfWeekID = Calendar.TUESDAY;   break;
		case WED_ID: dayOfWeekID = Calendar.WEDNESDAY; break;
		case THU_ID: dayOfWeekID = Calendar.THURSDAY;  break;
		case FRI_ID: dayOfWeekID = Calendar.FRIDAY;    break;
		case SAT_ID: dayOfWeekID = Calendar.SATURDAY;  break;
		default:     dayOfWeekID = 0; break;
		}
		return this.get(dayOfWeekID);
	}
}