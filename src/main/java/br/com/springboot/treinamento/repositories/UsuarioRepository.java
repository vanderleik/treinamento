package br.com.springboot.treinamento.repositories;

import br.com.springboot.treinamento.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
