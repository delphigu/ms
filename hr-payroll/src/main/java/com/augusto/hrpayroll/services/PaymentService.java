package com.augusto.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.augusto.hrpayroll.entities.Payment;
import com.augusto.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	public Payment getPayment(long workerId,int days) {
		Map<String,String> variables= new HashMap<String,String>();
		variables.put("id",String.valueOf(workerId));
		Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}",Worker.class,variables);
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
	}

}
