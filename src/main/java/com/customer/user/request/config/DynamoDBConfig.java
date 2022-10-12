package com.customer.user.request.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.springframework.util.StringUtils;

public class DynamoDBConfig {

	 @Value("${amazon.dynamodb.endpoint}")
	    private String amazonDynamoDBEndpoint;

	    @Value("${amazon.aws.accesskey}")
	    private String amazonAWSAccessKey;

	    @Value("${amazon.aws.secretkey}")
	    private String amazonAWSSecretKey;
	    
	    @Autowired
	    private ApplicationContext context;

	    @SuppressWarnings("deprecation")
		@Bean
	    public AmazonDynamoDB amazonDynamoDB() {
	        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
	        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
	            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
	        }
	        return amazonDynamoDB;
	    }

	    @Bean
	    public AWSCredentials amazonAWSCredentials() {
	        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
	    }

	    @SuppressWarnings("deprecation")
		@Bean(name = "mvcHandlerMappingIntrospectorCustom")
		public HandlerMappingIntrospector mvcHandlerMappingIntrospectorCustom() {
			return new HandlerMappingIntrospector(context);
		}
	}