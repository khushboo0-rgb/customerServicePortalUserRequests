package com.customer.user.request.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CustomerRequests {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestId;
	private String requestTitle;
	private String requestCategory;
	private String requestStatus;
	private String customerEmail;
	private String requestDescription;
	private Date requestDate;
	
	
	public String getRequestDescription() {
		return requestDescription;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
	
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getRequestCategory() {
		return requestCategory;
	}
	public void setRequestCategory(String requestCategory) {
		this.requestCategory = requestCategory;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	
	
	
	
	public CustomerRequests(Integer requestId, String requestTitle, String requestCategory, String requestStatus,
			String customerEmail, String requestDescription, Date requestDate) {
		super();
		this.requestId = requestId;
		this.requestTitle = requestTitle;
		this.requestCategory = requestCategory;
		this.requestStatus = requestStatus;
		this.customerEmail = customerEmail;
		this.requestDescription = requestDescription;
		this.requestDate = requestDate;
	}
	public String getRequestTitle() {
		return requestTitle;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public CustomerRequests() {
		super();
	}
	
	
	}
