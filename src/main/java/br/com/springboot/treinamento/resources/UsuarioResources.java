package br.com.springboot.treinamento.resources;

import br.com.springboot.treinamento.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResources {

    //Endpoint para acessar os usuários
    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "Maria", "maria@maria.com.br", "1234-5678", "senha");
        return ResponseEntity.ok().body(u);
    }
}
