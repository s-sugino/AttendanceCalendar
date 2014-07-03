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
	public Dialog( Stage ownerStage, String fxml, String css ) {
		
		Location.getInstance().loadFxml( fxml, this );
		
		this.dialogStage = new Stage();
		VBox dialogWindow = new VBox();
		dialogWindow.getChildren().add( this );
		
		Scene scene = new Scene( dialogWindow );
		String styleSheetURL = Location.getInstance().getURL( css ).toString();
		scene.getStylesheets().add( styleSheetURL );
		scene.setFill( null );
		
		this.dialogStage.initModality( Modality.APPLICATION_MODAL );
		this.dialogStage.initOwner( ownerStage );
		this.dialogStage.initStyle( StageStyle.TRANSPARENT );
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
	
	/**
	 * Dialogの内容を変更する
	 */
	public void changeDialog( String fxml, String css ) {

		Location.getInstance().loadFxml( fxml, this );
		
		VBox dialogWindow = new VBox();
		dialogWindow.getChildren().add( this );
		
		Scene scene = new Scene( dialogWindow );
		String styleSheetURL = Location.getInstance().getURL( css ).toString();
		scene.getStylesheets().add( styleSheetURL );
		scene.setFill( null );
		
		this.dialogStage.setScene( scene );
	}
}