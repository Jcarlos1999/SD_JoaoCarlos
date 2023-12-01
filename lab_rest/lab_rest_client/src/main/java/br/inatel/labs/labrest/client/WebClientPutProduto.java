package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import br.inatel.labs.labrest.client.model.dto.WebClientPostMonoProduto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientPutProduto
{
    public static void main(String[] args) {
        ProdutoDTO produtoExistente = new ProdutoDTO();
        produtoExistente.setId(1L);
        produtoExistente.setDescricao("Furadeira a bateria");

        ResponseEntity<Void> responseEntity = WebClient.create("http://localhost:8080").put()
                .uri("/produto").bodyValue(produtoExistente).retrieve().toBodilessEntity().block();

        HttpStatusCode statusCode =responseEntity.getStatusCode();

        System.out.println("Produto atualizado");
        System.out.println("Status de resposta: " + statusCode);
    }
}
