package com.example.savedata.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.savedata.repository.models.Usuario;
import com.example.savedata.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
		log.info("get user: {}", usuario);
		
		try {
			return new ResponseEntity<Usuario>(usuarioService.login(
					usuario.getUsuario(), usuario.getPassword()),
					HttpStatus.OK);
		} catch (Exception e) {
			log.error("error: {}", e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {
		log.info("save user: {}", usuario);
		
		try {
			return new ResponseEntity<Usuario>(usuarioService
					.saveUser(usuario), HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("error save: {}", e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}
