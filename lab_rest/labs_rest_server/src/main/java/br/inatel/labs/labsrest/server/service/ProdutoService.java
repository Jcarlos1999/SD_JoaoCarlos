package br.inatel.labs.labsrest.server.service;

import br.inatel.labs.labsrest.server.model.Produto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();
    @PostConstruct
    private void etup(){
        Produto p1 = new Produto(1L, "Furadeira", new BigDecimal(230.00));
        Produto p2 = new Produto(2L, "Furadeira", new BigDecimal(230.00));
        Produto p3 = new Produto(3L, "Furadeira", new BigDecimal(230.00));
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
    }

    public Optional<Produto> findById(long id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Produto> findByDescricao(String descricao){
        if(Objects.isNull(descricao) || descricao.isBlank()){
            return List.of();
        }

        return this.produtos.stream().filter(p -> p.getDescricao().trim().toLowerCase().contains(descricao.trim().toLowerCase())).toList();
    }

    public List<Produto> findAll(){
        return this.produtos;
    }

    public Produto create(Produto p){
        long id = new Random().nextLong();
        p.setId(id);
        produtos.add(p);
        return p;
    }

    public void update(Produto p){
        produtos.remove(p);
        produtos.add(p);
    }

    public void delete(Produto p){
        produtos.remove(p);
    }
}
