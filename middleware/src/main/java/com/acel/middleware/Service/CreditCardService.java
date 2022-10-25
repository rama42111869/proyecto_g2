package com.acel.middleware.Service;

import com.acel.middleware.Model.CreditCard;
import com.acel.middleware.Service.Connection.ApiConnection;
import com.acel.middleware.Service.Interface.ICreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class CreditCardService implements ICreditCardService {
    private WebClient wCcc = new ApiConnection('k').getClient();

    @Override
    public ResponseEntity<CreditCard> readCCByUser(Long userId) {
        try{
            ResponseEntity<CreditCard> rRcc = wCcc.get()
                    .uri("/"+userId)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(CreditCard.class)
                    .block();
            return rRcc;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Integer> saveCC(CreditCard creditCard, Long userId) {
        try {
            ResponseEntity<Integer> rScc = wCcc.post()
                    //.header("Authorization",SecurityConnection.getToken())
                    .uri("/"+userId)
                    .body(Mono.just(creditCard), CreditCard.class)
                    .retrieve()
                    .toEntity(Integer.class)
                    .block();
            return rScc;
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
    public ResponseEntity<Integer> deleteCC(Long idCC) {
        try {
            ResponseEntity<Integer> rDc = wCcc.delete()
                    .uri("/"+ idCC)
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
}
