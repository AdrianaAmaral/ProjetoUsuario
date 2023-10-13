package projeto.usuario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projeto.usuario.entity.Usuario;
import projeto.usuario.entity.enums.TipoSenha;
import projeto.usuario.entity.vo.UsuarioVO;
import projeto.usuario.exception.RegrasFactoryException;
import projeto.usuario.repository.UsuarioRepository;
import projeto.usuario.util.RegrasSenhaVO;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(rollbackFor = Throwable.class)
	public UsuarioVO salvar(UsuarioVO usuarioVO) throws Exception {
		Usuario usuario = passarDadosUsuario(usuarioVO);
		
		var regras = regras(usuarioVO);
		if(Boolean.FALSE.equals(regras.getResultado())) {
			throw new RegrasFactoryException(regras.getMensagem().toString());
		}
		
		usuarioRepository.save(usuario);
        return new UsuarioVO(usuario);
	}

	private Usuario passarDadosUsuario(UsuarioVO usuarioVO) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioVO.getNome());
		usuario.setSenha(usuarioVO.getSenha());
		return null;
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	private RegrasSenhaVO regras(UsuarioVO usuarioVO) {
		
		RegrasSenhaVO regras = new RegrasSenhaVO();
		List<String> resposta = new ArrayList<String>();
		regras.setResultado(true);
		
		if (usuarioVO.getSenha().isEmpty()) {
			regras.setResultado(false);
			resposta.add("Favor inserir uma senha válida");
		}
		if (usuarioVO.getSenha().length() < 8) {
			regras.setResultado(false);
			resposta.add("Senha válida com no mínimo 8 caracteres");
		}
		
		if (!usuarioVO.getSenha().isEmpty()) {			
			if (usuarioVO.getSenha().length() >= 8 && (usuarioVO.getSenha().length() / 4) != 3) {
				usuarioVO.setTipoSenha(TipoSenha.Ruim);
				resposta.add("Senha muito fraca");
			}
		}		
		
		regras.setMensagem(resposta);
		return regras;
	}

}
