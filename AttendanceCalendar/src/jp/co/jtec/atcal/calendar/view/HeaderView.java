package jp.co.jtec.atcal.calendar.view;

import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import jp.co.jtec.atcal.Location;

public class HeaderView extends HBox{

	@FXML private HBox titleBox;
	@FXML private HBox ctrlBox;
	
	public HeaderView() {
		
		super();
		Location.getInstance().loadFxml( "header_view.fxml" , this );
		this.getStylesheets().add( Location.getInstance().getURL( "css\\header_view.css" ).toString() );

		/* @note for ".hbox" style in css */
		this.getStyleClass().add( "hbox" );
		
		/* @note for side layout setting */
		HBox.setHgrow( this.titleBox, Priority.ALWAYS );
		HBox.setHgrow( this.ctrlBox, Priority.ALWAYS );
		
		/* TODO How specified escape for "<",">" in FXML ? */
		((Button)this.getTitleAreaNode( "prevMonthButton" )).setText( "<" );
		((Button)this.getTitleAreaNode( "nextMonthButton" )).setText( ">" );
	}
		
	private Node getChildNode( Pane target, String id ) {
		Iterator<Node> itr = target.getChildren().iterator();
		while ( itr.hasNext() ) {
			Node node = itr.next();
			if ( node.getId().equals( id ) ) {
				return node;
			}
		}
		return null;
	}
	
	public Node getTitleAreaNode( String id ) {
		return getChildNode(this.titleBox, id);
	}

	public Node getCtrlAreaNode( String id ) {
		return getChildNode(this.ctrlBox, id);
	}
	
	public void setTitleButtonAction( String id, EventHandler<ActionEvent> eventHandler ) {
		Button button = (Button) this.getChildNode( this.titleBox, id );
		button.setOnAction( eventHandler );
	}
	
	public void setCtrlButtonAction( String id, EventHandler<ActionEvent> eventHandler ) {
		Button button = (Button) this.getChildNode( this.ctrlBox, id );
		button.setOnAction( eventHandler );
	}
	
}
