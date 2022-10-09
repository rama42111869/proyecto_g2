package com.acel.middleware.Service;

import com.acel.middleware.Model.Category;
import com.acel.middleware.Service.Connection.ApiConnection;
import com.acel.middleware.Service.Interface.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class CategoryService implements ICategoryService {
    private WebClient wCc = new ApiConnection('c').getClient();

    @Override
    public ResponseEntity<Category> saveC(Category category) {
        try {
            ResponseEntity<Category> rCc = wCc.post()
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(category), Category.class)
                    .retrieve()
                    .toEntity(Category.class)
                    .block();
            return rCc;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
                return ResponseEntity.internalServerError().build();
            }
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity
                    .status(e.getStatusCode()).build();
            //                    .body((Integer.valueOf(e.getResponseBodyAsString())));

        }
    }

    @Override
    public ResponseEntity<Integer> deleteC(String name) {
        try {
            ResponseEntity<Integer> rDc = wCc.delete()
                    .uri("/"+ name)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Integer.class)
                    .block();
            return rDc;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
                return ResponseEntity.internalServerError().build();
            }
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity
                    .status(e.getStatusCode())
                    .body((Integer.valueOf(e.getResponseBodyAsString())));
        }
    }

    @Override
    public ResponseEntity<Integer> updateC(String name,Category category) {
        try {
            ResponseEntity<Integer> rUc = wCc.put()
                    .uri("/"+name)
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(category),Category.class)
                    .retrieve()
                    .toEntity(Integer.class)
                    .block();
            return rUc;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
                return ResponseEntity.internalServerError().build();
            }
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity
                    .status(e.getStatusCode())
                    .body((Integer.valueOf(e.getResponseBodyAsString())));
        }
    }

    @Override
    public ResponseEntity<Category> readC(String name) {
        try{
            ResponseEntity<Category> rBc = wCc.get()
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Category.class)
                    .block();
            return rBc;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Category[]> listAllC() {
        try{
            ResponseEntity<Category[]> lAc =wCc.get()
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Category[].class)
                    .block();
            return lAc;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }
}
