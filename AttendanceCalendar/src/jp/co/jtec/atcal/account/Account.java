package jp.co.jtec.atcal.account;

public class Account {
	
	public static final String DEFAULT_NAME = "guest";
	
	public static final String DEFAULT_ID   = "yyyyiii";
	
	private String name;
	
	private String id;
	
	public Account() {
		this.name = DEFAULT_NAME;
		this.id   = DEFAULT_ID;
	}
	
	public Account( String name, String id, String passwd) throws AuthenticationFailedException {
		this.authenticate(name, id, passwd);
		this.name = name;
		this.id   = id;
	}
	
	private void authenticate( String name, String id, String passwd) throws AuthenticationFailedException {
		
		boolean success = true;
		
		/* TODO  authentication function add. */
		
		if ( !success ) {
			throw new AuthenticationFailedException( name , id );
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public boolean isDefault() {
		return this.id.equals( DEFAULT_ID );
	}
	
	@Override
	public boolean equals(Object obj) {
		return (
			this.name.equals( ((Account)obj).name ) &&
			this.id.equals( ((Account)obj).id )
		);
	}	
}
