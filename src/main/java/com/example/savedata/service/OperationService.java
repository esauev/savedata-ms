package com.example.savedata.service;

import java.util.List;

import com.example.savedata.dto.OperationDto;
import com.example.savedata.repository.models.Operation;

public interface OperationService {
	
	public Operation save(Operation operation);
	
	public List<OperationDto> getAll();

}
