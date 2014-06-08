package com.anuarlb.account.dao;

import java.util.List;

import com.anuarlb.account.model.Account;


public interface AccountDao {

	
	 List<Account> findAll() throws Exception;

}
