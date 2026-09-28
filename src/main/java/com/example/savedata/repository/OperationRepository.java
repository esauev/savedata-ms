package com.example.savedata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.savedata.repository.models.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

}
