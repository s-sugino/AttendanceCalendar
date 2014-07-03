package jp.co.jtec.atcal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Applicationクラス
 * 
 * @author ssugino
 */
public class AttendanceCalendar extends Application {
	
	/**
	 * コンストラクタ
	 * 
	 * @note 外部呼出できてしまうが基本的に呼ぶ事はないので許容
	 */
	public AttendanceCalendar() {
		/* デフォルトコンストラクタ */
	}
	
	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(AttendanceCalendar.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		VBox root = new VBox();
		root.getChildren().addAll( new MainFrame( stage ) );
		
		Scene scene = new Scene( root );
		String styleSheetURL = Location.getInstance().getURL( "css\\atcal.css" ).toString();
		scene.getStylesheets().add( styleSheetURL );
		scene.setFill( null );
		
		stage.initStyle( StageStyle.TRANSPARENT );
		stage.setScene( scene );
		stage.setTitle( "Atcal" );
		
		stage.show();
	}
}
