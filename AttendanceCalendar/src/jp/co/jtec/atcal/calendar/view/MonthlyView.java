package jp.co.jtec.atcal.calendar.view;

import java.util.Iterator;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import jp.co.jtec.atcal.calendar.model.DailyData;
import jp.co.jtec.atcal.calendar.model.MonthlyData;
import jp.co.jtec.atcal.calendar.model.WeeklyData;

public class MonthlyView extends TableView<WeeklyData> {

	private MonthlyData monthlyData;
	
	private final
	Callback<TableColumn<WeeklyData, DailyData>, TableCell<WeeklyData, DailyData>> cellFactory = 
		new Callback<TableColumn<WeeklyData,DailyData>, TableCell<WeeklyData,DailyData>>() {
			@Override
			public TableCell<WeeklyData, DailyData> call( TableColumn<WeeklyData, DailyData> column) {
				return new DailyCell();
			}
		};
	
	private final
	Callback<CellDataFeatures<WeeklyData, DailyData>, ObservableValue<DailyData>> cellValueFactory = 
		new Callback<TableColumn.CellDataFeatures<WeeklyData,DailyData>, ObservableValue<DailyData>>() {
			@Override
			public ObservableValue<DailyData> call( CellDataFeatures<WeeklyData, DailyData> features ) {
				WeeklyData weeklyData = features.getValue();
				return new SimpleObjectProperty<DailyData>(
					weeklyData.get( features.getTableColumn().getText() )
				);
			}
		};
		
	public MonthlyView() {		
		super();
		this.setupColumn();
		this.setEditable( true );
	}
	
	private void setupColumn() {
		Iterator<String> itr = WeeklyData.dayOfWeeks().iterator();
		while ( itr.hasNext() ) {
			TableColumn<WeeklyData, DailyData> column = new TableColumn<WeeklyData, DailyData>(itr.next());
			column.setCellFactory( this.cellFactory );
			column.setCellValueFactory( this.cellValueFactory );
			this.getColumns().add( column );			
		}
	}
	
	public void update( int year, int month ) {
		
		/* @note null item setting for update view on TableView object */
		this.setItems( null );
		this.layout();
		
		this.monthlyData = new MonthlyData( year, month );		
		ObservableList<WeeklyData> weeklyDataList = FXCollections.observableArrayList();
		Iterator<WeeklyData> itr = this.monthlyData.iterator();
		while ( itr.hasNext() ) {
			weeklyDataList.add(itr.next());
		}
		
		this.setItems( weeklyDataList );
		this.layout();
	}
	
	public MonthlyData getItem() {
		return this.monthlyData;
	}
}
