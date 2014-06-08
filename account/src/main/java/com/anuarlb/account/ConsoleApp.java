package com.anuarlb.account;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anuarlb.account.model.Account;
import com.anuarlb.account.service.AccountService;

public class ConsoleApp {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("account-conf.xml");
		AccountService accountService = (AccountService) appCtx.getBean("accountService");
		
		List<Account> delinquentAccounts = accountService.findDeliquentAccounts();
		
		delinquentAccounts.forEach( a -> System.out.println("\t " + a));
		
	}

}
