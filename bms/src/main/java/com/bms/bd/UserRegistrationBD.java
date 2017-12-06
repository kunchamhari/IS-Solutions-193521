package com.bms.bd;

import org.springframework.transaction.annotation.Transactional;

import com.bms.dao.BMSDAOException;
import com.bms.dao.BmsMongoRepositoryDao;
import com.bms.dao.BmsMongoRepositoryDaoImpl;
import com.bms.model.Customer;
import com.bms.model.Transaction;


@Transactional
public class UserRegistrationBD  {
	public int insertNewUserDetails(Customer customer) throws BMSDAOException{
		
		BmsMongoRepositoryDao bmsMongoRepo = new BmsMongoRepositoryDaoImpl();
		int status = bmsMongoRepo.registerBMSUser(customer);
		System.out.println("acc no=="+customer.getAccountNumber());
		return status;
	}
	public Customer validateUser( String userId, String pwd){
		
		BmsMongoRepositoryDao bmsMongoRepo = new BmsMongoRepositoryDaoImpl();
		//Customer customerObj  = bmsMongoRepo.getRegisteredBMSUser(userId,pwd);
	    return null;
		
	}
	public boolean updateTransaction(Transaction transaction){
		BmsMongoRepositoryDao bmsMongoRepo = new BmsMongoRepositoryDaoImpl();
		bmsMongoRepo.insertUserTransactionDetails(transaction);
		
	}

	

}
