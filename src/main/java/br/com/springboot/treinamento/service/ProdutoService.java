package br.com.springboot.treinamento.service;


import br.com.springboot.treinamento.entities.Produto;
import br.com.springboot.treinamento.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj =  produtoRepository.findById(id);
        return obj.get();
    }
}
