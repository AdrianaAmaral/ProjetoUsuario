package projeto.usuario.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import projeto.usuario.entity.Usuario;
import projeto.usuario.entity.enums.TipoSenha;

@Data
@AllArgsConstructor
public class UsuarioVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String senha;
	private TipoSenha tipoSenha;
	
	public UsuarioVO(Usuario usuario) {
		if (usuario == null) return;
		
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
	}
	
}
