package projeto.usuario.util;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RegrasSenhaVO {
	
	private Boolean resultado;
	private List<String> mensagem = new ArrayList<>();

}
