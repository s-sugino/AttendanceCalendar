package jp.co.jtec.atcal.account;

@SuppressWarnings("serial")
public class AuthenticationFailedException extends Exception {

	public AuthenticationFailedException( String name, String id ) {
		super( "Authentication Failed: ( name = " + name + " / id = " + id + " )" );
	}
}
