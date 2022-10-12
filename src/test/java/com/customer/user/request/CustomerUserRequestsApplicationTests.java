//package com.customer.user.request;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//
//import java.util.Date;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//import com.customer.user.request.model.CustomerRequests;
//import com.customer.user.request.service.ICustomerRequestRepository;
//import com.customer.user.request.service.ICustomerRequestService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class CustomerUserRequestsApplicationTests {
//	
//	@Autowired
//	ICustomerRequestService customerRequestService;
//@MockBean
//ICustomerRequestRepository customerRequestRepository;
//
//CustomerRequests customerRequests = new CustomerRequests(1,"title","category","status","KhushbooSharma@cognizant.com","description",new Date(2022-10-07));
//Optional<CustomerRequests> op=Optional.of(customerRequests);
//
//@Test
//public void createRequestTest() {
//	when(customerRequestRepository.save(customerRequests)).thenReturn(customerRequests);
//	assertEquals(customerRequests.getRequestId(), customerRequestService.saveCustomerRequests(customerRequests));
//	
//}
//@Test
//public void getCustomerRequestByIdTest() {
//	when(customerRequestRepository.findById(1)).thenReturn(Optional.of(customerRequests));
//	assertEquals(op, customerRequestService.getCustomerRequests(1));
//	
//}
//@Test
//public void findCustomerRequestsByTitleTest() {
//	when(customerRequestRepository.findRequestByTitle("title")).thenReturn(customerRequests);
//	
//	assertEquals(op, customerRequestService.findRequestByTitle("title"));
//	
//}
//@Test
//public void findPendingRequestsTest() {
//	when(customerRequestRepository.findPendingRequests("pending")).thenReturn(customerRequests);
//	
//	assertEquals(op, customerRequestService.findPendingRequests("pending"));
//	
//}
//
//@Test
//@Rollback(false)
//public void testDeleteRequest() {
//   
//   
//    customerRequestRepository.deleteById(1);
//   
//    CustomerRequests deletedRequest =customerRequestRepository .findRequestByTitle("title");
//  
//    assertThat(deletedRequest).isNull();       
//     
//}
//@Test
//public void testUpdateCustomerRequests() {
//	
//	CustomerRequests savedRequest=new CustomerRequests( 1,"Khushboo","Sharma","Customer1Address","Uttar Pradesh","India",new Date(2022-10-07));
//
//	// when - action or the behaviour
//	String newEmail = "Khushboo1Sharma1@cognizant.com";
//
//	savedRequest.setCustomerEmail(newEmail);
//
//	// then - verify the output
//	assertThat(savedRequest).isNotNull();
//
//	assertThat(savedRequest.getCustomerEmail()).isEqualTo(newEmail);
//}}
//
