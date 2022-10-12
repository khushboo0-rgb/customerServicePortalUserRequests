package com.customer.user.request.service;

import java.util.List;
import java.util.Optional;
import com.customer.user.request.model.CustomerRequests;

	public interface ICustomerRequestService {
		Integer saveCustomerRequests(CustomerRequests customerRequest);
		public List<CustomerRequests> getAllCustomerRequests(String customerEmail);
	
		Optional<CustomerRequests> getCustomerRequests(Integer requestId);
		public void deleteCustomerRequests(Integer requestId);
		public List<CustomerRequests> getAllClosedCustomerRequests(String customerEmail);
		CustomerRequests updateCustomerRequests(CustomerRequests customerRequest , Integer id);
		List<CustomerRequests> getRequest(String requestTitle);
		Optional<CustomerRequests> findRequestByTitle(String requestTitle);
		Optional<CustomerRequests> findPendingRequests(String requestStatus);
}
