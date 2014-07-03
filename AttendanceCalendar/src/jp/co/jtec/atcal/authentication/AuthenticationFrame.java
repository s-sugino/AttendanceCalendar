package jp.co.jtec.atcal.authentication;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import jp.co.jtec.atcal.Dialog;

/**
 * LoginFrameクラス
 * 
 * @note Loginを行う画面
 */
public class AuthenticationFrame extends Dialog {
		
	@FXML private Button cancelButton;
	
	@FXML private Button loginButton;
	
	@FXML private Button closeButton;
	
	@FXML private TextField idField;
	
	@FXML private PasswordField passField;

	/**
	 * Authentication state
	 * 
	 * @note true : login
	 *       false: logout
	 */
	private boolean authState;
	
	/**
	 * login button action event
	 */
	private final EventHandler<ActionEvent> loginButtonAction = new EventHandler<ActionEvent>() {
		public void handle( ActionEvent arg0 ) {
			System.out.println( "[AuthenticationFrame] push login button." );
			changeAuthState( true );
			close();
		}
	};
	
	/**
	 * cancel button action event
	 */
	private final EventHandler<ActionEvent> cancelButtonAction = new EventHandler<ActionEvent>() {
		public void handle( ActionEvent arg0) {
			System.out.println( "[AuthenticationFrame] push cancel button." );
			changeAuthState( false );
			close();
		}
	};
	
	/**
	 * close button action event
	 */
	private final EventHandler<ActionEvent> closeButtonAction = new EventHandler<ActionEvent>() {
		public void handle( ActionEvent arg0) {
			System.out.println( "[AuthenticationFrame] push cancel button." );
			changeAuthState( false );
			close();
		}
	};
	
	/**
	 * コンストラクタ
	 * 
	 * @param ownerStage
	 */
	public AuthenticationFrame( Stage ownerStage ) {
		super( ownerStage, "auth\\login.fxml", "css\\auth\\auth.css");
		this.loginButton.setOnAction( this.loginButtonAction );
		this.cancelButton.setOnAction( this.cancelButtonAction );
		
		this.authState = false;
	}
	
	/**
	 * ログイン状態を変更する
	 * 
	 * @param state
	 */
	public void changeAuthState( boolean state ) {
		this.authState = state;
		
		if ( this.authState ) {
			super.changeDialog( "auth\\logout.fxml", "css\\auth\\auth.css" );
			this.closeButton.setOnAction( this.closeButtonAction );
		} else {
			super.changeDialog( "auth\\login.fxml", "css\\auth\\auth.css" );
			this.loginButton.setOnAction( this.loginButtonAction );
			this.cancelButton.setOnAction( this.cancelButtonAction );
		}
	}
	
	/**
	 * ログイン状態を取得する
	 */
	public boolean getAuthState() {
		return this.authState;
	}
}