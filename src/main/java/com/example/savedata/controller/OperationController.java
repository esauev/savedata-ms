package com.example.savedata.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.savedata.dto.OperationDto;
import com.example.savedata.repository.models.Operation;
import com.example.savedata.service.OperationService;

@RestController
@RequestMapping(value = "/operation")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OperationService operationService;
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Operation> saveOperation(@RequestBody Operation operation) {
		
		log.info("save: {}", operation);
		
		try {
			return new ResponseEntity<Operation>(operationService.save(operation), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value = "/list-all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OperationDto>> getListOperation(){
		log.info("get operations");
		try {
			return new ResponseEntity<List<OperationDto>>(operationService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
