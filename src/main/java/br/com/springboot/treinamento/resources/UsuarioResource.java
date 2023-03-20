package br.com.springboot.treinamento.resources;

import br.com.springboot.treinamento.entities.Usuario;
import br.com.springboot.treinamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    //Endpoint para retornar todos usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = usuarioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Endpoint que retorna um usuário por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario user = usuarioService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    //Endpoint que cria um usuário
    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario obj) {
        obj = usuarioService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Endpoint que deleta um usuário
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
