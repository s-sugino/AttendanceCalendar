package jp.co.jtec.atcal;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * MainFrameクラス
 * 
 * @note ベースの画面になるクラス
 * 
 * @author ssugino
 */
public class MainFrame extends BorderPane {
		
	/**
	 * コンストラクタ
	 * 
	 * @param primaryStage
	 */
	public MainFrame( Stage primaryStage ) {
		Location.getInstance().loadFxml( "atcal.fxml", this );
		/* 最大化した時の高さ調節のためにbindしておく */
		this.prefHeightProperty().bind( primaryStage.heightProperty() );
		this.setupDialog( primaryStage );
	}
	
	/**
	 * DialogManagerの設定を行う
	 * 
	 * @param primaryStage
	 */
	private void setupDialog( Stage primaryStage ) {
		DialogManager dialogManager = DialogManager.getInstance();
		dialogManager.setOwnerStage( primaryStage );
		dialogManager.add( "AuthenticationDialog", "jp.co.jtec.atcal.account.AuthenticationDialog" );	
	}
}
