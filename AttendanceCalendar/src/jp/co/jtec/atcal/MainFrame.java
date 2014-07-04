package jp.co.jtec.atcal;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import jp.co.jtec.atcal.authentication.AuthenticationFrame;

/**
 * Appllicationクラス
 * 
 * @note ベースの画面になるクラス
 * 
 * @author ssugino
 */
public class MainFrame extends BorderPane {
	
	/** ベースとなるStage */
	private Stage primaryStage;	
	
	@FXML private Button closeButton;
	
	@FXML private Button authButton;
	
	/**
	 * Authentication frame
	 */
	private AuthenticationFrame authFrame;
	
	/**
	 * close button action event
	 */
	private final EventHandler<ActionEvent> closeButtonAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle( ActionEvent arg0 ) {
			System.out.println( "push close button." );
			Platform.exit();
		}
	};
	
	/**
	 * Authentication frame action event
	 */
	private final EventHandler<WindowEvent> authFrameAction = new EventHandler<WindowEvent>() {
		@Override
		public void handle( WindowEvent arg0 ) {
			System.out.println( "close auth frame." );
			if ( authFrame.getAuthState() ) {
				authButton.setText( "logout" );
			} else {
				authButton.setText( "login" );
			}
		}
	};
	
	/**
	 * Authentication button action event
	 */
	private final EventHandler<ActionEvent> authButtonAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle( ActionEvent arg0 ) {
			System.out.println( "push login button" );
			authFrame.show();
		}
	};
	
	/**
	 * コンストラクタ
	 * 
	 * @param primaryStage
	 */
	public MainFrame( Stage primaryStage ) {
		
		this.primaryStage = primaryStage;
		Location.getInstance().loadFxml( "atcal.fxml", this );
		
		/* 最大化した時の高さ調節のためにbindしておく */
		this.prefHeightProperty().bind( primaryStage.heightProperty() );
		
		this.closeButton.setOnAction( this.closeButtonAction );
		this.authButton.setOnAction( this.authButtonAction );
		
		this.authFrame = new AuthenticationFrame( primaryStage );
		this.authFrame.getStage().setOnHidden( this.authFrameAction );
	}
	
	/**
	 * Primary Stageを取得する
	 * 
	 * @note PopUpを表示する場合に基点となるStageが必要になることがある
	 * 
	 * @return 基点となるStage
	 */
	public Stage getStage() {
		return this.primaryStage;
	}
}
