package com.example.savedata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.savedata.repository.UsuarioRepository;
import com.example.savedata.repository.models.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Usuario login(String usuario, String password) {
		
		 Usuario user = usuarioRepository
	                .findByUsuario(usuario)
	                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

	        boolean passwordMatches = passwordEncoder.matches(
	                password,
	                user.getPassword()
	        );

	        if (!passwordMatches) {
	            throw new RuntimeException("Invalid username or password");
	        }
		
		return user;
	}

	@Override
	public Usuario saveUser(Usuario usuario) {
		
		boolean userExists = usuarioRepository
                .findByUsuario(usuario.getUsuario())
                .isPresent();

        if (userExists) {
            throw new RuntimeException("Username already exists");
        }
        
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());

		usuario.setPassword(hashedPassword);
		usuario.setRole("USER");
		return usuarioRepository.save(usuario);
	}

}
