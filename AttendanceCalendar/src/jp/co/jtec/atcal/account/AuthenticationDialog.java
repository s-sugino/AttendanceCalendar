package jp.co.jtec.atcal.account;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jp.co.jtec.atcal.Dialog;

public class AuthenticationDialog extends Dialog {
	
	@FXML private TextField nameField;
	@FXML private TextField idField;
	@FXML private PasswordField passField;
	
	@FXML private Button cancelButton;
	@FXML private Button ctrlButton;
	
	private final EventHandler<ActionEvent> cancelAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub		
		}
	};
	
	private final EventHandler<ActionEvent> ctrlAction = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
		}
	};
	
	public AuthenticationDialog( Stage ownerStage ) {
		super( ownerStage, "auth_dialog.fxml", "css\\auth_dialog.css" );
	}
}
