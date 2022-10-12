package com.customer.user.request.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.customer.user.request.exception.ResourceNotFoundException;
import com.customer.user.request.model.CustomerRequests;




@Service
public class CustomerRequestServiceImpl implements ICustomerRequestService {
	@Autowired
	ICustomerRequestRepository customerRequestRepository;

	@Override
	public Integer saveCustomerRequests(CustomerRequests customerRequest) {
		
		CustomerRequests savedCustomerRequests = customerRequestRepository.save(customerRequest);
		
		return savedCustomerRequests.getRequestId() ;
	}
	@Override
	public List<CustomerRequests> getAllCustomerRequests(String customerEmail)
	{
		return customerRequestRepository.findRequestsByCustomerEmail(customerEmail);
	}
	@Override
	public List<CustomerRequests> getAllClosedCustomerRequests(String customerEmail)
	{
		return customerRequestRepository.findRequestsByClosedCustomerEmail(customerEmail);
	}
	@Override
	public Optional<CustomerRequests> getCustomerRequests(Integer requestId) {
		
		return customerRequestRepository.findById(requestId);
	}
	@Override
	public void deleteCustomerRequests(Integer requestId) {
		customerRequestRepository.deleteById(requestId);
		
	}
	
	@Override
	public Optional<CustomerRequests> findRequestByTitle(String requestTitle) {
		CustomerRequests customerRequests =customerRequestRepository.findRequestByTitle(requestTitle);
		return Optional.ofNullable(customerRequests);
	}
	
	@Override
	public Optional<CustomerRequests> findPendingRequests(String requestStatus) {
		CustomerRequests customerRequests =customerRequestRepository.findPendingRequests( requestStatus);
		return Optional.ofNullable(customerRequests);
	}
	
	@Override
	public CustomerRequests updateCustomerRequests(CustomerRequests customerRequest , Integer requestId)
	{
		CustomerRequests existingCustomerRequests = customerRequestRepository.findById(requestId).orElseThrow(()
				-> new ResourceNotFoundException("CustomerRequests", "Id", requestId));
				existingCustomerRequests.setRequestCategory(customerRequest.getRequestCategory());
				existingCustomerRequests.setRequestTitle(customerRequest.getRequestTitle());
				existingCustomerRequests.setRequestStatus(customerRequest.getRequestStatus());
				existingCustomerRequests.setRequestDescription(customerRequest.getRequestDescription());
				existingCustomerRequests.setRequestDate(customerRequest.getRequestDate());
				existingCustomerRequests.setCustomerEmail(customerRequest.getCustomerEmail());
		
		customerRequestRepository.save(existingCustomerRequests);
		return existingCustomerRequests;
	}
	
	@Override
	public List<CustomerRequests> getRequest(String requestTitle) {
		return customerRequestRepository.findByTitle(requestTitle);
	}
	
	}

	

