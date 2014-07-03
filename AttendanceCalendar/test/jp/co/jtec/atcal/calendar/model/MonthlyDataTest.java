package jp.co.jtec.atcal.calendar.model;

import java.util.Calendar;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonthlyDataTest {

	private MonthlyData monthlyData;
	
	@Before
	public void setUp() throws Exception {
		this.monthlyData = new MonthlyData(2014, 6);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWeekOfMonth() {
		assert( this.monthlyData.getWeekOfMonth() == 5 );
	}
	
	@Test
	public void test1stWeek() {
		WeeklyData weeklyData = this.monthlyData.getWeeklyData( 0 );
		assert( weeklyData.get(WeeklyData.SUN_ID).getDate() == 1 );
		assert( weeklyData.get(WeeklyData.MON_ID).getDate() == 2 );
		assert( weeklyData.get(WeeklyData.TUE_ID).getDate() == 3 );
		assert( weeklyData.get(WeeklyData.WED_ID).getDate() == 4 );
		assert( weeklyData.get(WeeklyData.THU_ID).getDate() == 5 );
		assert( weeklyData.get(WeeklyData.FRI_ID).getDate() == 6 );
		assert( weeklyData.get(WeeklyData.SAT_ID).getDate() == 7 );
	}

	@Test
	public void test2ndWeek() {
		WeeklyData weeklyData = this.monthlyData.getWeeklyData( 1 );
		assert( weeklyData.get(WeeklyData.SUN_ID).getDate() == 8 );
		assert( weeklyData.get(WeeklyData.MON_ID).getDate() == 9 );
		assert( weeklyData.get(WeeklyData.TUE_ID).getDate() == 10 );
		assert( weeklyData.get(WeeklyData.WED_ID).getDate() == 11 );
		assert( weeklyData.get(WeeklyData.THU_ID).getDate() == 12 );
		assert( weeklyData.get(WeeklyData.FRI_ID).getDate() == 13 );
		assert( weeklyData.get(WeeklyData.SAT_ID).getDate() == 14 );
	}

	@Test
	public void test3rdWeek() {
		WeeklyData weeklyData = this.monthlyData.getWeeklyData( 2 );
		assert( weeklyData.get(WeeklyData.SUN_ID).getDate() == 15 );
		assert( weeklyData.get(WeeklyData.MON_ID).getDate() == 16 );
		assert( weeklyData.get(WeeklyData.TUE_ID).getDate() == 17 );
		assert( weeklyData.get(WeeklyData.WED_ID).getDate() == 18 );
		assert( weeklyData.get(WeeklyData.THU_ID).getDate() == 19 );
		assert( weeklyData.get(WeeklyData.FRI_ID).getDate() == 20 );
		assert( weeklyData.get(WeeklyData.SAT_ID).getDate() == 21 );
	}

	@Test
	public void test4thWeek() {
		WeeklyData weeklyData = this.monthlyData.getWeeklyData( 3 );
		assert( weeklyData.get(WeeklyData.SUN_ID).getDate() == 22 );
		assert( weeklyData.get(WeeklyData.MON_ID).getDate() == 23 );
		assert( weeklyData.get(WeeklyData.TUE_ID).getDate() == 24 );
		assert( weeklyData.get(WeeklyData.WED_ID).getDate() == 25 );
		assert( weeklyData.get(WeeklyData.THU_ID).getDate() == 26 );
		assert( weeklyData.get(WeeklyData.FRI_ID).getDate() == 27 );
		assert( weeklyData.get(WeeklyData.SAT_ID).getDate() == 28 );
	}

	@Test
	public void test5thWeek() {
		WeeklyData weeklyData = this.monthlyData.getWeeklyData( 4 );
		assert( weeklyData.get(WeeklyData.SUN_ID).getDate() == 29 );
		assert( weeklyData.get(WeeklyData.MON_ID).getDate() == 30 );
		assert( weeklyData.get(WeeklyData.TUE_ID) == null );
		assert( weeklyData.get(WeeklyData.WED_ID) == null );
		assert( weeklyData.get(WeeklyData.THU_ID) == null );
		assert( weeklyData.get(WeeklyData.FRI_ID) == null );
		assert( weeklyData.get(WeeklyData.SAT_ID) == null );
	}

	
	@Test
	public void testOutput() {
		Iterator<WeeklyData> witr = this.monthlyData.iterator();		
		while ( witr.hasNext() ) {
			WeeklyData weeklyData = witr.next();
			System.out.printf( "[%d]: ", weeklyData.getWeekOfMonth() );
			
			Iterator<DailyData> ditr = weeklyData.iterator();
			while ( ditr.hasNext() ) {
				DailyData dailyData = ditr.next();
				if ( dailyData != null ) {
					Calendar cal = dailyData.getCalendar();
					System.out.printf( "%2d ", cal.get(Calendar.DATE) );
				} else {
					System.out.print( "   " );
				}
			}
			System.out.print( "\n" );	
		}
	}
}
