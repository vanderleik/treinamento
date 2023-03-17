package br.com.springboot.treinamento.config;

import br.com.springboot.treinamento.entities.Categoria;
import br.com.springboot.treinamento.entities.Pedido;
import br.com.springboot.treinamento.entities.Produto;
import br.com.springboot.treinamento.entities.Usuario;
import br.com.springboot.treinamento.entities.enums.PedidoStatus;
import br.com.springboot.treinamento.repositories.CategoriaRepository;
import br.com.springboot.treinamento.repositories.PedidoRepository;
import br.com.springboot.treinamento.repositories.ProdutoRepository;
import br.com.springboot.treinamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

/**
 * Classe de configuração que instancia o banco de dados
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO,u1);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO,u2);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.CANCELADO,u1);

        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");

        Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""/*, p1*/);
        Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""/*, p1*/);
        Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""/*, p2*/);
        Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""/*, p2*/);
        Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""/*, p3*/);

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

        produto1.getCategorias().add(cat2);
        produto2.getCategorias().add(cat1);
        produto2.getCategorias().add(cat3);
        produto3.getCategorias().add(cat3);
        produto4.getCategorias().add(cat3);
        produto5.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
    }

}
