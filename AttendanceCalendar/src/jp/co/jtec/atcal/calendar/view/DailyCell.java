package jp.co.jtec.atcal.calendar.view;

import javafx.scene.control.TableCell;
import jp.co.jtec.atcal.calendar.model.DailyData;
import jp.co.jtec.atcal.calendar.model.WeeklyData;

public class DailyCell extends TableCell<WeeklyData, DailyData>{

	private DailyView dailyView;
	
	public DailyCell() {
		this.dailyView = null;
	}

	@Override
	public void cancelEdit() {
		
		DailyData dailyData = this.getItem();
		if ( dailyData == null ) {
			return ;
		}
		
		System.out.println( "[DailyCell]: cancelEdit call: date=" + dailyData.getDate() );
	}

	@Override
	public void startEdit() {
		
		DailyData dailyData = this.getItem();
		if ( dailyData == null ) {
			return ;
		}
		
		System.out.println( "[DailyCell]: startEdit call: date=" + dailyData.getDate() );
	}

	@Override
	protected void updateItem(DailyData dailyData, boolean empty) {
		
		if ( empty ) {
			this.setItem( null );
			return ;
		}
		
		if ( this.dailyView == null ) {
			this.dailyView = new DailyView( dailyData );
			this.setItem( dailyData );
		}
		
		// TODO only when initialized ?
		this.setGraphic( this.dailyView );
	}
}
