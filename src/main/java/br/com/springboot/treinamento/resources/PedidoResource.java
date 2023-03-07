package br.com.springboot.treinamento.resources;

import br.com.springboot.treinamento.entities.Pedido;
import br.com.springboot.treinamento.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    //Endpoint para retornar todos pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> list = pedidoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Endpoint que retorna um pedido por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }
}
