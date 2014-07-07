package jp.co.jtec.atcal.account;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountManagerTest {

	private AccountManager manager;
	
	@Before
	public void setUp() throws Exception {
		this.manager = AccountManager.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		this.manager.clear();
	}

	@Test
	public void testInitialize() {
		Account account = this.manager.getPrimary();
		assert( account.isDefault() == true );
		assert( account.getName().equals( Account.DEFAULT_NAME ) );
		assert( account.getId().equals( Account.DEFAULT_ID ) );
	}

	@Test
	public void testAdd() {
		
		try {
			this.manager.add( new Account( "sample1", "2003042", "sample" ) );
			this.manager.add( new Account( "sample2", "2003043", "sample" ) );
			this.manager.add( new Account( "sample3", "2003044", "sample" ) );
		} catch (AuthenticationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assert( this.manager.size() == 4 );
	}
	
	@Test
	public void testAddPrimary1() {
		
		try {
			this.manager.addPrimary( new Account( "sample", "2003042", "sample" ) );
		} catch (AuthenticationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account account = this.manager.getPrimary();
		
		assert( account.isDefault() == false );
		assert( account.getName().equals( "sample" ) );
		assert( account.getId().equals( "2003042" ) );
	}
	
	@Test
	public void testAddPrimary2() {
		
		try {
			this.manager.addPrimary( new Account( "sample1", "2003042", "sample" ) );
			this.manager.addPrimary( new Account( "sample2", "2003043", "sample" ) );
			this.manager.addPrimary( new Account( "sample3", "2003044", "sample" ) );
		} catch (AuthenticationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Account account = this.manager.getPrimary();
		assert( account.isDefault() == false );
		assert( account.getName().equals( "sample3" ) );
		assert( account.getId().equals( "2003044" ) );
	}
	
	@Test
	public void testRemove1() {
		
		Account account1 = null, account2 = null, account3 = null;
		try {
			account1 = new Account( "sample1", "2003042", "sample" );
			account2 = new Account( "sample2", "2003043", "sample" );
			account3 = new Account( "sample3", "2003044", "sample" );
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		}
		
		assert( this.manager.size() == 4 );
		
		this.manager.remove( account1 );
		this.manager.remove( account2 );
		this.manager.remove( account3 );

		assert( this.manager.size() == 1 );	
	}

	@Test
	public void testRemove2() {

		Account account1 = null, account2 = null, account3 = null;
		try {
			account1 = new Account( "sample1", "2003042", "sample" );
			account2 = new Account( "sample2", "2003043", "sample" );
			account3 = new Account( "sample3", "2003044", "sample" );
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		}
		
		this.manager.addPrimary( account1 );
		this.manager.addPrimary( account2 );
		this.manager.addPrimary( account3 );
		
		assert( this.manager.size() == 4 );
		
		this.manager.remove( account1 );
		this.manager.remove( account2 );
		this.manager.remove( account3 );
		assert( this.manager.size() == 1 );	
		
		Account account = this.manager.getPrimary();
		assert( account.isDefault() == true );
		assert( account.getName().equals( Account.DEFAULT_NAME ) );
		assert( account.getId().equals( Account.DEFAULT_ID ) );
	}
	
}
