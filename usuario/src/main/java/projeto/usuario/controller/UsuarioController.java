package projeto.usuario.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.usuario.entity.vo.UsuarioVO;
import projeto.usuario.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin("http://localhost:8081")
public class UsuarioController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/salvar")
	public ResponseEntity<Object> salvar(@RequestBody UsuarioVO usuarioVO) throws Exception {
		logger.info("UsuarioController.salvar()");
		return new ResponseEntity<Object>(usuarioService.salvar(usuarioVO), HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<Object> listarUsuarios(@RequestHeader Map<String, String> headers) {
		logger.info("UsuarioController.listarUsuarios()");
		return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
	}

}
