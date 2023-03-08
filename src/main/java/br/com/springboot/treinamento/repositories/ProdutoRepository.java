package br.com.springboot.treinamento.repositories;

import br.com.springboot.treinamento.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
