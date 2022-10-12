package com.customer.user.request.repositories;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.customer.user.request.model.CustomerRequests;

@EnableScan
public interface CustomerRequestInfoRepository extends CrudRepository<CustomerRequests, Integer> {
    Optional<CustomerRequests> findById(Integer requestId);
} 