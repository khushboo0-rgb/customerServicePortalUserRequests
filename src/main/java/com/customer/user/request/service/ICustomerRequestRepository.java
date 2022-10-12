package com.customer.user.request.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.customer.user.request.model.CustomerRequests;



public interface ICustomerRequestRepository extends JpaRepository<CustomerRequests, Integer> {

	

	@Query(value = "select * from customer_requests  where customer_Email=?1  and request_status = 'pending'  or request_status= 'reopen'",nativeQuery = true)
	List<CustomerRequests> findRequestsByCustomerEmail(String customerEmail);
	
	@Query(value = "select * from customer_requests  where customer_Email=?1  and request_status = 'closed'",nativeQuery = true)
	List<CustomerRequests> findRequestsByClosedCustomerEmail(String customerEmail);
	@Query(value = "select * from customer_requests  where request_title=?1 ",nativeQuery = true)
	List<CustomerRequests> findByTitle(String requestTitle);
	@Query(value = "select * from customer_requests  where request_title=?1 ",nativeQuery = true)
	CustomerRequests  findRequestByTitle(String requestTitle);
	@Query(value = "select * from customer_requests  where customer_Email=?1  and request_status = 'pending'  or request_status= 'reopen'",nativeQuery = true)
	CustomerRequests  findPendingRequests(String requestStatus);
}
