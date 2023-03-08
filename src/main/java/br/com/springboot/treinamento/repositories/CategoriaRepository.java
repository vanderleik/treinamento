package br.com.springboot.treinamento.repositories;

import br.com.springboot.treinamento.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
