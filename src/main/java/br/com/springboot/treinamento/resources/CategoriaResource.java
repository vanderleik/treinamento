package br.com.springboot.treinamento.resources;

import br.com.springboot.treinamento.entities.Categoria;
import br.com.springboot.treinamento.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    //Endpoint para retornar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Endpoint que retorna uma categoria por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria user = categoriaService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
