package jp.co.jtec.atcal.calendar.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;
import jp.co.jtec.atcal.Dialog;
import jp.co.jtec.atcal.DialogManager;
import jp.co.jtec.atcal.Location;
import jp.co.jtec.atcal.account.Account;
import jp.co.jtec.atcal.account.AccountManager;
import jp.co.jtec.atcal.calendar.model.MonthlyData;

public class CalendarView extends BorderPane {

	@FXML private HeaderView headerView;
	@FXML private MonthlyView monthlyView;
	
	private final EventHandler<ActionEvent> prevMonthAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			monthlyView.slide( -1 );
			updateCalendar();
		}
	};
	
	private final EventHandler<ActionEvent> nextMonthAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			monthlyView.slide( +1 );
			updateCalendar();
		}
	};
	
	private final EventHandler<ActionEvent> authAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent arg0) {
			Dialog dialog = DialogManager.getInstance().get( "AuthenticationDialog" );
			if ( dialog != null ) {
				dialog.show();
			}
		}
	};
	
	private final EventHandler<WindowEvent> authFinAction = new EventHandler<WindowEvent>() {
		@Override
		public void handle(WindowEvent arg0) {
			updateAccount();
		}
	};
	
	private final EventHandler<ActionEvent> closeAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Platform.exit();
		}
	};
	
	public CalendarView() {
		
		super();
		Location.getInstance().loadFxml( "calendar_view.fxml", this );
		Location.getInstance().loadStyleSheet( "css\\calendar_view.css", this );
		
		this.headerView.setTitleButtonAction( "prevMonthButton", this.prevMonthAction );
		this.headerView.setTitleButtonAction( "nextMonthButton", this.nextMonthAction );
		
		this.headerView.setCtrlButtonAction( "accountButton", this.authAction );
		this.headerView.setCtrlButtonAction( "closeButton",   this.closeAction );
		
		Dialog authDialog = DialogManager.getInstance().get( "AuthenticationDialog" );
		if ( authDialog != null ) {
			authDialog.getStage().setOnHidden( this.authFinAction );
		}
		
		this.updateAccount();
		this.updateCalendar();
	}
	
	private void updateAccount() {
		Account account = AccountManager.getInstance().getPrimary();
		Button accountButton = (Button) this.headerView.getCtrlAreaNode( "accountButton" );
		accountButton.setText( account.getName() );
	}
	
	private void updateCalendar() {
		MonthlyData monthlyData = this.monthlyView.getItem();
		this.headerView.updateTitle( " " + monthlyData.getYear() + " / " + monthlyData.getMonth() + " " );
	}
}
