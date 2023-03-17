package br.com.springboot.treinamento.repositories;

import br.com.springboot.treinamento.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
