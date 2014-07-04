package jp.co.jtec.atcal;

import java.util.HashMap;

import javafx.stage.Stage;

public class DialogManager {

	private Stage ownerStage;
	private HashMap<String, Dialog> dialogMap;
	
	public static DialogManager manager = new DialogManager();
	
	private DialogManager() {
		this.ownerStage = null;
		this.dialogMap = new HashMap<String, Dialog>();
	}
	
	public static DialogManager getInstance() {
		return manager;
	}

	public void setOwnerStage( Stage stage ) {
		this.ownerStage = stage;
	}
	
	public void add( String key, String className ) {
		this.dialogMap.put( 
			key, 
			DialogFactory.createInstance( className, this.ownerStage ) 
		);
	}
	
	public Dialog get( String key ) {
		return this.dialogMap.get( key );
	}
}
