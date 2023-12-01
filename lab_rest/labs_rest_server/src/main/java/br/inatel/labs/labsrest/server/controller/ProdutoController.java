package br.inatel.labs.labsrest.server.controller;

import br.inatel.labs.labsrest.server.model.Produto;
import br.inatel.labs.labsrest.server.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping()
    public List<Produto> getProduto(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable("id") long produtoId){

        return service.findById(produtoId).orElseThrow(() -> {
            String msg = String.format("Nenhum produto encontrado com esse id [%s]", produtoId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        });
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto postProduto(@RequestBody Produto p) {
        Produto produtoCriacao = service.create(p);
        return produtoCriacao;
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void putProduto(@RequestBody Produto p){
        service.update(p);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable("id") Long id){
        Produto produtoEncontrado = getProdutoById(id);
        service.delete(produtoEncontrado);
    }

    @GetMapping("/pesquiaa")
    public List<Produto> getByDescricao(@RequestParam("descricao") String descricao){
        return service.findByDescricao(descricao);
    }

}
