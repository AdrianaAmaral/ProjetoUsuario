package projeto.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import projeto.usuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, ID>{

}
