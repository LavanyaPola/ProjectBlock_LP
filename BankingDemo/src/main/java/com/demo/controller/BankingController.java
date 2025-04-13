package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Account updateAmount(@RequestBody Account a)
	{
		return acc.save(a);
	}
	
	@PostMapping("/delete")
	public String deleteAmount(@RequestBody Account a)
	{
		acc.deleteAll();
		return "Deleted";
	}
}
