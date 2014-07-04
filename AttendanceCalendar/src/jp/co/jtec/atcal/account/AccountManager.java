package jp.co.jtec.atcal.account;

import java.util.ArrayList;
import java.util.Iterator;

public class AccountManager {
	
	private Account primaryAccount;
	private ArrayList<Account> accountList;
	
	private static final AccountManager manager = new AccountManager();
	
	private AccountManager() {
		this.accountList = new ArrayList<Account>();
		this.clear();
	}
	
	public static AccountManager getInstance() {
		return manager;
	}
	
	public void clear() {
		this.accountList.removeAll( this.accountList );
		this.primaryAccount = new Account();
		this.accountList.add( this.primaryAccount );
	}
	
	public Account getPrimary() {
		return this.primaryAccount;
	}
	
	public void switchPrimary( int index ) {
		if ( index < 0 || this.accountList.size() <= index ) {
			throw new IllegalArgumentException( "AccountManager primary switch failed, because index is invalid." );
		}
		this.primaryAccount = this.accountList.get( index );
	}
	
	public void add( Account account ) {
		if ( this.accountList.contains( account ) ) {
			throw new IllegalArgumentException( "AccountManager add failed, because guest account can not add." );
		}
		this.accountList.add( account );
	}
	
	public void addPrimary( Account account ) {
		this.add( account );
		this.primaryAccount = account;
	}
	
	public void remove( Account target ) {
		if ( target.isDefault() ) {
			throw new IllegalArgumentException( "AccountManager remove failed, because guest account can not remove." );
		}
		if ( target.equals( this.primaryAccount ) ) {
			this.primaryAccount = this.accountList.get( 0 );
		}
		this.accountList.remove( target );
	}
	
	public int size() {
		return this.accountList.size();
	}
	
	public Iterator<Account> iterator() {
		return this.accountList.iterator();
	}
	
	
}
