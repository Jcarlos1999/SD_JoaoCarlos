package br.inatel.labs.labrest.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebCLientDeleteId {
    public static void main(String[] args) {
        ResponseEntity<Void> responseEntity = WebClient.create("http://8080").delete()
                .uri("/produtos/3").retrieve().toBodilessEntity().block();

        HttpStatusCode statusCode = responseEntity.getStatusCode();

        System.out.println("Produto removido");
        System.out.println("Status da resposta: " + statusCode  );
    }
}
