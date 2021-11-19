package com.augusto.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.hrworker.entities.Worker;
import com.augusto.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);
	@Autowired
	WorkerRepository workerRepository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		
	
		List<Worker> lista = workerRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		logger.info("porta :"+environment.getProperty("local.server.port"));
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
	
		

}
