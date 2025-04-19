package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Account;
import com.demo.repository.Accinterface;

@RestController
public class BankingController 
{

	@Autowired
	private Accinterface acc;

	
	@GetMapping("/view")
	public List<Account> getbalance()
	{
		return acc.findAll();
    }
	
	
	@PostMapping("/insert")
	public  Account insertuser(@RequestBody Account a)
	{
		return acc.save(a);
	}
	
	
	
	@PostMapping("/deposit")
	public Account depositamount(@RequestBody Account a)
	{
		Account existing = acc.findById(a.getAccno()).orElse(null);
	    if (existing != null) 
	    {
	        existing.setAccbal(existing.getAccbal() + a.getAccbal());
	        return acc.save(existing);
	    } 
	    else {
	        return acc.save(a); // if account doesn't exist, save as new
	    }
	}
	
	@PostMapping("/withdraw")
	public Account withdrawAmount(@RequestBody Account a) {
	    Account existing = acc.findById(a.getAccno()).orElse(null);
	    if (existing != null && existing.getAccbal() >= a.getAccbal()) 
	    {
	        existing.setAccbal(existing.getAccbal() - a.getAccbal());
	        return acc.save(existing);
	    } 
	    else {
	        return null; // or throw an exception / custom error message
	    }
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateAccount(@RequestBody Account a) {
	    Account existing = acc.findById(a.getAccno()).orElse(null);

	    if (existing == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
	    }

	    // Update only allowed fields (excluding accno accname accbal)
	    existing.setAccadd(a.getAccadd());
	    existing.setAccph(a.getAccph());
	    
	    // Do NOT change accbal

	    acc.save(existing);
	    return ResponseEntity.ok("Account details updated, Account Number, Name, and Balance Unchanged");
	}
	
	@PostMapping("/delete")
	public String deleteAmount(@RequestBody Account a)
	{
		acc.deleteAll();
		return " Account is Deleted";
	}
}
