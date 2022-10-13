package com.acel.middleware.Service.Connection;


import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Data
public class ApiConnection {
    private WebClient client;

    public ApiConnection(char conn){
        this.client = this.getConnection(conn);
    }

    private WebClient getConnection(char conn){
        WebClient connection = null;
        try {
            switch (conn) {
                case 'a':
                    connection = this.createConection("http://localhost:8080/api");
                    break;
                case 'u':
                    connection = this.createConection("http://localhost:8080/api/users");
                    break;
                case 'p':
                    connection = this.createConection("http://localhost:8080/api/products");
                    break;
                case 'r':
                    connection = this.createConection("http://localhost:8080/api/purchases");
                    break;
                case 'c':
                    connection = this.createConection("http://localhost:8080/api/category");
                    break;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return connection;
    }

    private WebClient createConection(String url) {
        return WebClient.builder().baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
