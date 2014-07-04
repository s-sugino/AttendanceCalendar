package jp.co.jtec.atcal;

import javafx.stage.Stage;

public class DialogFactory {

	/**
	 * コンストラクタの外部呼出し禁止
	 */
	private DialogFactory() {
	}
	
	/**
	 * Dialogインスタンス生成
	 * 
	 * @param className　生成対象クラス名
	 * @param ownerStage プライマリステージ
	 * @return Dialogインスタンス
	 */
	public static final Dialog createInstance( String className, Stage ownerStage ) {
		
		try {
			@SuppressWarnings("unchecked")
			Class<Dialog> dialogClass = (Class<Dialog>) Class.forName( className );
			if ( dialogClass != null ) {
				Dialog dialog = dialogClass.newInstance();
				dialog.setup( ownerStage );
				return dialog;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
