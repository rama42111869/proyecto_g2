package com.acel.middleware.Service;

import com.acel.middleware.Model.Product;
import com.acel.middleware.Service.Connection.ApiConnection;
import com.acel.middleware.Service.Interface.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService {
    private WebClient wCp = new ApiConnection('p').getClient();

    @Override
    public ResponseEntity<Product> savePr(Long idC,Product product) {
        try {
            ResponseEntity<Product> rCp = wCp.post()
                    .uri("/"+idC)
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(product), Product.class)
                    .retrieve()
                    .toEntity(Product.class)
                    .block();
            return rCp;
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
    public ResponseEntity<Integer> deletePr(Long idP) {
        try {
            ResponseEntity<Integer> rDp = wCp.delete()
                    .uri("/"+ idP)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Integer.class)
                    .block();
            return rDp;
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
    public ResponseEntity<Integer> updatePr(Long idP,Long idC,Product product) {
        try {
            ResponseEntity<Integer> rUu = wCp.put()
                    .uri("/"+idP+"/"+idC)
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(product),Product.class)
                    .retrieve()
                    .toEntity(Integer.class)
                    .block();
            return rUu;
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
    public ResponseEntity<Product> readPr(Long idP) {
        try{
            ResponseEntity<Product> rBp = wCp.get()
                    .uri("/"+idP)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Product.class)
                    .block();
            return rBp;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Product[]> listAllPr() {
        try{
            ResponseEntity<Product[]> lAp =wCp.get()
                    .retrieve()
                    .toEntity(Product[].class)
                    .block();
            return lAp;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }
}
