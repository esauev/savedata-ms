package com.example.savedata.service;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.savedata.dto.OperationDto;
import com.example.savedata.repository.OperationRepository;
import com.example.savedata.repository.models.Operation;

@Service
public class OperationServiceImpl implements OperationService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OperationRepository  operationRepository;

	@Override
	public Operation save(Operation operation) {
		
		Random number = new Random();
		Integer aleatorio = number.nextInt(900000) + 100000;
		operation.setReferencia(aleatorio);
		operation.setEstatus(
				Objects.isNull(operation.getEstatus()) 
				? "Aprobada"
						: operation.getEstatus()
				);
		return operationRepository.save(operation);
	}

	@Override
	public List<OperationDto> getAll() {
		List<OperationDto> op = operationRepository.findAll().stream()
				.map(o -> new OperationDto(
						o.getId(),
						o.getOperacion(),
						o.getImporte().toString(),
						o.getCliente(),
						o.getReferencia(),
						o.getEstatus(),
						o.getSecreto()))
				.toList();
		log.info("lista operaciones: {}", op);
		return op;
	}

}
