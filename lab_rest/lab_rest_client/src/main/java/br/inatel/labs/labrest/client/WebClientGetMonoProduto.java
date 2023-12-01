package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class WebClientGetMonoProduto {

    public static void main(String[] args) {
        try {
            Mono<ProdutoDTO> monoProduto = WebClient.create("http://localhost:8080").get()
                    .uri("/produto/9").retrieve().bodyToMono(ProdutoDTO.class);

            monoProduto.subscribe();
            ProdutoDTO produto = monoProduto.block();

            System.out.println("Produto encontrado");
            System.out.println(produto);
        }catch (WebClientResponseException e){
            System.out.println("Message code: " + e.getStatusCode());
            System.out.println("Message: " + e.getMessage());
        }
    }

}
