package com.bms.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bms.bd.UserRegistrationBD;
import com.bms.dao.BMSDAOException;
import com.bms.model.Customer;

@RestController
public class CustomerController {

	
	@RequestMapping("/home")
	public ModelAndView home(){
		
		ModelAndView model = new ModelAndView("register");
		return model;
	}
	
	
	@RequestMapping(value="/userregistration", method = RequestMethod.POST)
	public String registerUser(@RequestBody @Valid Customer customer){
		  System.out.println("username>>>"+customer.getUsername());
		 UserRegistrationBD userRegistrationBD =  new UserRegistrationBD();
		try {
			userRegistrationBD.insertNewUserDetails(customer);
		} catch (BMSDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "register";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam String userId,@RequestParam String password ){
		  System.out.println("username>>>"+userId);
		 UserRegistrationBD userRegistrationBD =  new UserRegistrationBD();
		userRegistrationBD.validateUser(userId,password);
		return "register";
	}
	@RequestMapping(value="/transaction", method = RequestMethod.POST)
	public String updateTransaction(@RequestParam String userId,@RequestParam String password ){
		  System.out.println("username>>>"+userId);
		 UserRegistrationBD userRegistrationBD =  new UserRegistrationBD();
		 //userRegistrationBD.updateTransaction(transaction).validateUser(userId,password);
		return "register";
	}
	
	
	
}
