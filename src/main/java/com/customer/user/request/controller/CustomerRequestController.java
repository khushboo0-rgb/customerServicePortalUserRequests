package com.customer.user.request.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.customer.user.request.model.CustomerRequests;
import com.customer.user.request.service.ICustomerRequestService;





@RestController
//@RequestMapping("/users")
//@CrossOrigin(origins= "http://localhost:4200")
@CrossOrigin(origins= "*")
public class CustomerRequestController {

	@Autowired
	ICustomerRequestService customerRequestService;
	
 
 
 @PostMapping("/savecustomerRequest")
 Integer createCustomerRequests(@RequestBody CustomerRequests customerRequest)
 {
	 Integer id = customerRequestService.saveCustomerRequests(customerRequest);
	 System.out.println(id);
	return id;
 }


	@GetMapping("/getCustomerRequest/{customerEmail}")
	public List<CustomerRequests> getCustomerRequests(@PathVariable String customerEmail){
		
		
		return customerRequestService.getAllCustomerRequests(customerEmail);
	}
	@GetMapping("/getClosedCustomerRequest/{customerEmail}")
	public List<CustomerRequests> getClosedCustomerRequests(@PathVariable String customerEmail){
		
		
		return customerRequestService.getAllClosedCustomerRequests(customerEmail);
	}
	 @GetMapping("/getRequestByTitle/{requestTitle}")
	 public List<CustomerRequests> getRequestByTitle(@PathVariable String requestTitle)
	 {
		 List<CustomerRequests> request = customerRequestService.getRequest(requestTitle);
		
		 return request;
	 }
 

 @GetMapping("/getcustomerRequest/{id}")
 public Optional<CustomerRequests> getCustomerRequests(@PathVariable Integer id)
 {
	 Optional<CustomerRequests> customerRequest = customerRequestService.getCustomerRequests(id);
	 return customerRequest;
 }
 @DeleteMapping("/customerRequest/{id}")
 public ResponseEntity<CustomerRequests> deleteCustomerRequests(@PathVariable Integer id)
 {
	 System.out.println(id);
	 	ResponseEntity<CustomerRequests> responseEntity = new ResponseEntity<>(HttpStatus.OK);
	 	try
	 	{
	 		customerRequestService.deleteCustomerRequests(id);
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 		responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 	}
	 	return responseEntity;
	 	
 }	
 
	 	
 
 @PutMapping("/update/{id}")
	public ResponseEntity<CustomerRequests> updateCustomerRequests(@PathVariable("id") Integer id , @RequestBody CustomerRequests customerRequest)
	{
		return new ResponseEntity<CustomerRequests>(customerRequestService.updateCustomerRequests(customerRequest, id), HttpStatus.OK);
	}
 
 
}


