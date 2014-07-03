package jp.co.jtec.atcal.calendar.view;

import java.util.Calendar;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import jp.co.jtec.atcal.Location;

public class CalendarView extends BorderPane {

	@FXML private HeaderView headerView;
	@FXML private MonthlyView monthlyView;
	
	private final EventHandler<ActionEvent> prevMonthAction = 
		new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				Calendar cal = monthlyView.getItem().getCalendar();
				cal.add( Calendar.MONTH , -1 );
				
				int year  = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				
				monthlyView.update( year, month );
				headerView.setTitle( " " + year + "/" + month + " " );
			}
		};
	
	private final EventHandler<ActionEvent> nextMonthAction = 
		new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Calendar cal = monthlyView.getItem().getCalendar();
				cal.add( Calendar.MONTH , +1 );
				int year  = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				
				monthlyView.update( year, month );
				headerView.setTitle( " " + year + "/" + month + " " );
			}
		};
	
	private final EventHandler<ActionEvent> closeAction = 
		new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		};
	
	public CalendarView() {
		
		super();
		Location.getInstance().loadFxml( "calendar_view.fxml", this );
		this.getStylesheets().add(
			Location.getInstance().getURL( "css\\calendar_view.css" ).toString()
		);
		
		Calendar curDate = Calendar.getInstance();
		int year  = curDate.get( Calendar.YEAR );
		int month = curDate.get( Calendar.MONTH ) + 1;
		
		this.headerView.setTitle( " " + year + "/" + month + " " );
		this.headerView.setTitleButtonAction( "prevMonthButton" , this.prevMonthAction );
		this.headerView.setTitleButtonAction( "nextMonthButton" , this.nextMonthAction );
		this.headerView.setCtrlButtonAction( "closeButton", this.closeAction );
		
		this.monthlyView.update( year, month );
	}	
}
