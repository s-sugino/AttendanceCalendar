package jp.co.jtec.atcal.account;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
		
		this.manager.add( new Account( "sample1", "2003042" ) );
		this.manager.add( new Account( "sample2", "2003043" ) );
		this.manager.add( new Account( "sample3", "2003044" ) );
		
		assert( this.manager.size() == 4 );
	}
	
	@Test
	public void testAddPrimary1() {
		
		this.manager.addPrimary( new Account( "sample", "2003042" ) );
		Account account = this.manager.getPrimary();
		
		assert( account.isDefault() == false );
		assert( account.getName().equals( "sample" ) );
		assert( account.getId().equals( "2003042" ) );
	}
	
	@Test
	public void testAddPrimary2() {
		
		this.manager.addPrimary( new Account( "sample1", "2003042" ) );
		this.manager.addPrimary( new Account( "sample2", "2003043" ) );
		this.manager.addPrimary( new Account( "sample3", "2003044" ) );
		
		Account account = this.manager.getPrimary();
		assert( account.isDefault() == false );
		assert( account.getName().equals( "sample3" ) );
		assert( account.getId().equals( "2003044" ) );
	}
	
	@Test
	public void testRemove1() {
		
		List<Account> list = Arrays.asList(
			new Account( "sample1", "2003042" ),
			new Account( "sample2", "2003043" ),
			new Account( "sample3", "2003044" )
		);
		
		Iterator<Account> itr = list.iterator();
		while ( itr.hasNext() ) {
			this.manager.add( itr.next() );
		}
		assert( this.manager.size() == 4 );
		
		itr = list.iterator();
		while ( itr.hasNext() ) {
			this.manager.remove( itr.next() );
		}
		assert( this.manager.size() == 1 );	
	}

	@Test
	public void testRemove2() {
		
		List<Account> list = Arrays.asList(
			new Account( "sample1", "2003042" ),
			new Account( "sample2", "2003043" ),
			new Account( "sample3", "2003044" )
		);
		
		Iterator<Account> itr = list.iterator();
		while ( itr.hasNext() ) {
			this.manager.addPrimary( itr.next() );
		}
		assert( this.manager.size() == 4 );
		
		itr = list.iterator();
		while ( itr.hasNext() ) {
			this.manager.remove( itr.next() );
		}
		assert( this.manager.size() == 1 );	
		
		Account account = this.manager.getPrimary();
		assert( account.isDefault() == true );
		assert( account.getName().equals( Account.DEFAULT_NAME ) );
		assert( account.getId().equals( Account.DEFAULT_ID ) );
	}
	
}
