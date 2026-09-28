package com.example.savedata.service;

import com.example.savedata.repository.models.Usuario;

public interface UsuarioService {
	
	public Usuario login(String usuario, String password);
	
	public Usuario saveUser(Usuario usuario);

}
