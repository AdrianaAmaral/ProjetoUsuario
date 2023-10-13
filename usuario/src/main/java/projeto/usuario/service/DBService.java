package projeto.usuario.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.usuario.entity.Usuario;
import projeto.usuario.repository.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instanciaDB() {
		Usuario usuario = new Usuario();
		usuarioRepository.saveAll(Arrays.asList(usuario));		
	}

}
