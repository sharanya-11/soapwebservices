package com.example.demo.client.springsoapWebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.springsoapWebservice.client.SoapClient;
import com.example.demo.client.springsoapWebservice.loaneligibility.Acknowledgement;
import com.example.demo.client.springsoapWebservice.loaneligibility.CustomerRequest;

@SpringBootApplication
@RestController
public class SpringSoapWebservicesLoanApproverClientApplication { 
	@Autowired
	private SoapClient client;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		return client.getLoanStatus(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapWebservicesLoanApproverClientApplication.class, args);
	}

}
