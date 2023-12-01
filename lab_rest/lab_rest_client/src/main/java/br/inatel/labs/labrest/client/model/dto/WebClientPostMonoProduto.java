package br.inatel.labs.labrest.client.model.dto;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.math.BigDecimal;

public class WebClientPostMonoProduto
{
    public static void main(String[] args) {
        try{
            ProdutoDTO novoProduto = new ProdutoDTO();
            novoProduto.setDescricao("Martelo");
            novoProduto.setPreco(new BigDecimal(25.00));

            ProdutoDTO produtoCriado = WebClient.create("http://localhost:8080").post()
                    .uri("/produto").bodyValue(novoProduto).retrieve().bodyToMono(ProdutoDTO.class).block();

            System.out.println("Produto criado");
            System.out.println(produtoCriado);
        }catch (WebClientResponseException e){
            System.out.println("Message code: " + e.getStatusCode());
            System.out.println("Message: " + e.getMessage());
        }
    }
}
