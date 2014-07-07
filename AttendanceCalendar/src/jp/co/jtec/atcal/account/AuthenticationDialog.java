package jp.co.jtec.atcal.account;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jp.co.jtec.atcal.Dialog;

public class AuthenticationDialog extends Dialog {
	
	@FXML private Label title;
	
	@FXML private TextField nameField;
	@FXML private TextField idField;
	@FXML private PasswordField passField;
	
	@FXML private Button cancelButton;
	@FXML private Button ctrlButton;
	
	private final EventHandler<ActionEvent> cancelAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle( ActionEvent event ) {
			getStage().close();
		}
	};
	
	private final EventHandler<ActionEvent> ctrlAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle( ActionEvent event ) {
			Account account = AccountManager.getInstance().getPrimary();
			if ( account.isDefault() ) {
				try {
					login();
				} catch (AuthenticationFailedException e) {
					// TODO login failed action
				}
			} else {
				logout();
			}
		}
	};
	
	public AuthenticationDialog() {
		super();
		this.updateView( "auth_dialog.fxml" , "css\\auth_dialog.css" );
		this.cancelButton.setOnAction( cancelAction );
		this.ctrlButton.setOnAction( ctrlAction );
	}

	private void login() throws AuthenticationFailedException {
		
		String name   = this.nameField.getText();
		String id     = this.idField.getText();
		String passwd = this.passField.getText();
		
		Account account = new Account( name, id, passwd );
		AccountManager.getInstance().addPrimary(account);
		
		this.close();
		
		/* 事前にログアウト用に画面を切り替えておく */
		this.title.setText( "Logout ?" );
		this.ctrlButton.setText( "logout" );
	}

	private void logout() {
		
		AccountManager manager = AccountManager.getInstance();
		manager.remove( manager.getPrimary() );
		
		this.close();
		
		/* 事前にログイン用に画面を切り替えておく */
		this.title.setText( "Please input your account information." );
		this.nameField.setText( "" );
		this.idField.setText( "" );
		this.passField.setText( "" );
		this.ctrlButton.setText( "login" );
	}
	
}
