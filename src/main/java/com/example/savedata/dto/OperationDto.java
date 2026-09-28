package com.example.savedata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class OperationDto {
	
	private Long id;
	
	private String operacion;
	
	private String importe;
	
	private String cliente;
	
	private Integer referencia;
	
	private String estatus;
	
	private String secreto;

}
