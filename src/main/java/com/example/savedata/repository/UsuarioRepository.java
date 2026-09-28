package com.example.savedata.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.example.savedata.repository.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	//@Query
	//Usuario findByUsuarioAndPassword(String usuario, String password);
	
	Optional<Usuario> findByUsuario(String usuario);

}
