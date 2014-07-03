package jp.co.jtec.atcal;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.fxml.FXMLLoader;

/**
 * このアプリケーションのパス情報を管理するクラス
 * 
 * @author ssugino
 */
public class Location {

	/** カレントディレクトリ */
	private String curdir;
	
	/** インスタンス (Singleton) */
	private static Location location = new Location();
	
	/**
	 * コンストラクタ
	 * 
	 * @note Singletoneパターンのため外部呼出禁止
	 */
	private Location() {
		try {
			curdir = new File( "." ).getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * インスタンスを取得する
	 * 
	 * @return インスタンス
	 */
	public static Location getInstance() {
		return location;
	}
	
	/**
	 * 指定されたファイルのURLを取得する
	 * 
	 * @param fname　ファイル名
	 * @return URL
	 */
	public URL getURL( String fname ) {
		URL url = null;
		try {
			url = new URL( "file:\\" + this.curdir + "\\" + fname );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * 指定されたファイル名のPathを取得する
	 * 
	 * @param fname ファイル名
	 * @return　Path文字列
	 */
	public String getPath( String fname ) {
		return this.getURL(fname).getPath();
	}
	
	/**
	 * 指定されたFXMLをロードする
	 * 
	 * @param fxmlName FXMLファイル名
	 * @param component ベースとなるコンポーネント
	 */
	public void loadFxml( String fxmlName, Object component ) {
		FXMLLoader loader = new FXMLLoader( this.getURL( "fxml\\" + fxmlName ) );
		loader.setRoot( component );
		loader.setController( component );
		try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
