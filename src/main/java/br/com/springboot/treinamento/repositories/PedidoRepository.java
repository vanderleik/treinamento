package br.com.springboot.treinamento.repositories;

import br.com.springboot.treinamento.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
