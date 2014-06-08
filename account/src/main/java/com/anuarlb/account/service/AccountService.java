package com.anuarlb.account.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import com.anuarlb.account.dao.AccountDao;
import com.anuarlb.account.model.Account;

public class AccountService {

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public List<Account> findDeliquentAccounts () throws Exception {
		List<Account> delinquentAccounts = new ArrayList<Account>();
		List<Account> accounts = accountDao.findAll();
		
		Date thirtyDaysAgo = daysAgo(30);
		
		delinquentAccounts = accounts.stream().filter(a -> a.getBalance().compareTo(BigDecimal.ZERO) > 0 && a.getLastPaidOn().compareTo(thirtyDaysAgo) <= 0).collect(Collectors.toList());
		
		return delinquentAccounts;
		
	}
	
	
	private static Date daysAgo (int days){
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.DATE,-days);
		return gc.getTime();
	}
	
}
