package com.acel.middleware.Service;

import com.acel.middleware.Model.Purchase;
import com.acel.middleware.Service.Connection.ApiConnection;
import com.acel.middleware.Service.Interface.IPurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class PurchaseService implements IPurchaseService {
    private WebClient wCpu = new ApiConnection('r').getClient();

    @Override
    public ResponseEntity<Purchase[]> listAllPu() {
        try{
            ResponseEntity<Purchase[]> rLpu = wCpu.get()
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Purchase[].class)
                    .block();
            return rLpu;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Purchase[]> listPubyUS(Long idU) {
        try{
            ResponseEntity<Purchase[]> rLpuUs =wCpu.get()
                    .uri("/user/"+idU)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Purchase[].class)
                    .block();
            return rLpuUs;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Purchase> readPu(Long idP) {
        try{
            ResponseEntity<Purchase> rRpu = wCpu.get()
                    .uri("/"+idP)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Purchase.class)
                    .block();
            return rRpu;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Purchase> savePu(Long idP, Long idU, Purchase purchase) {
        try {
            ResponseEntity<Purchase> rSpu = wCpu.post()
                    .uri("/"+idP+"/"+idU)
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(purchase),Purchase.class)
                    .retrieve()
                    .toEntity(Purchase.class)
                    .block();
            return rSpu;
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

//    @Override
//    public ResponseEntity<Integer> deletePu(Long id) {
//        try {
//            ResponseEntity<Integer> rDpu = wCpu.delete()
//                    .uri("/"+ id)
//                    //.header("Authorization",SecurityConnection.getToken())
//                    .retrieve()
//                    .toEntity(Integer.class)
//                    .block();
//            return rDpu;
//        }catch (WebClientResponseException e){
//            if(e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
//                return ResponseEntity.internalServerError().build();
//            }
//            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//            }
//            return ResponseEntity
//                    .status(e.getStatusCode())
//                    .body((Integer.valueOf(e.getResponseBodyAsString())));
//        }
//    }

//    @Override
//    public ResponseEntity<Integer> updatePu(Purchase purchase) {
//        try {
//            ResponseEntity<Integer> rUpu = wCpu.put()
//                    //.header("Authorization",SecurityConnection.getToken())
//                    .body(Mono.just(purchase),Purchase.class)
//                    .retrieve()
//                    .toEntity(Integer.class)
//                    .block();
//            return rUpu;
//        }catch (WebClientResponseException e){
//            if(e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
//                return ResponseEntity.internalServerError().build();
//            }
//            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//            }
//            return ResponseEntity
//                    .status(e.getStatusCode())
//                    .body((Integer.valueOf(e.getResponseBodyAsString())));
//        }
//    }


}
