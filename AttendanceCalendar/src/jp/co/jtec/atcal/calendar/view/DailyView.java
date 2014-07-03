package jp.co.jtec.atcal.calendar.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import jp.co.jtec.atcal.Location;
import jp.co.jtec.atcal.calendar.model.DailyData;

public class DailyView extends VBox {

	@FXML private Label dateLabel;
	@FXML private Label eventLabel;
	
	public DailyView( DailyData dailyData ) {
		super();
		if ( dailyData != null ) {
			Location.getInstance().loadFxml("daily_view.fxml", this);
			this.dateLabel.setText( new Integer( dailyData.getDate() ).toString() );
		}
	}
	
}
