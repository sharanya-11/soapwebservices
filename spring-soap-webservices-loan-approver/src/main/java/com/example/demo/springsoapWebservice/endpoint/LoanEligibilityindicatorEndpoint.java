package com.example.demo.springsoapWebservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.springsoapWebservice.loaneligibility.Acknowledgement;
import com.example.demo.springsoapWebservice.loaneligibility.CustomerRequest;
import com.example.demo.springsoapWebservice.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityindicatorEndpoint {
	private static final String NAMESPACE = "http://www.example.com/demo/springsoapWebservice/loanEligibility";
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	} 

}
