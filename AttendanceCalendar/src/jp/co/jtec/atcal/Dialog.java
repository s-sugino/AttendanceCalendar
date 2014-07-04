package jp.co.jtec.atcal;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Dialogクラス
 */
public class Dialog extends BorderPane {
	
	private Stage dialogStage;
	
	/**
	 * コンストラクタ
	 * 
	 * @param ownerStage
	 */
	public Dialog() {
		this.dialogStage = new Stage();
	}
	
	public void setup( Stage ownerStage ) {
		this.dialogStage.initModality( Modality.APPLICATION_MODAL );
		this.dialogStage.initOwner( ownerStage );
		this.dialogStage.initStyle( StageStyle.TRANSPARENT );
	}
	
	protected void updateView( String fxmlFileName, String cssFileName ) {
		
		Location.getInstance().loadFxml( fxmlFileName, this );
		
		VBox dialogView = new VBox();
		dialogView.getChildren().add( this );
		
		Scene scene = new Scene( dialogView );
		Location.getInstance().loadStyleSheet( cssFileName, scene );
		scene.setFill( null );
		
		this.dialogStage.setScene( scene );
	}
	
	/**
	 * Dialog Stageを取得する
	 */
	public Stage getStage() {
		return this.dialogStage;
	}
	
	/**
	 * Dialog Stageを表示する
	 */
	public void show() {
		this.dialogStage.show();
	}
	
	/**
	 * Dialog Stageを閉じる
	 */
	public void close() {
		this.dialogStage.close();
	}
	
	/**
	 * Dialog Stageを隠す
	 */
	public void hide() {
		this.dialogStage.hide();
	}
}
