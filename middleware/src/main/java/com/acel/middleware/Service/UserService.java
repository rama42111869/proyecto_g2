package com.acel.middleware.Service;

import com.acel.middleware.Model.User;
import com.acel.middleware.Service.Connection.ApiConnection;
import com.acel.middleware.Service.Interface.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {
    private WebClient wCu = new ApiConnection('u').getClient();

    @Override
    public ResponseEntity<User[]> listAllU() {
        try{
            ResponseEntity<User[]> rLu =wCu.get()
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(User[].class)
                    .block();
            return rLu;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<User> readU(Long idU) {
        try{
            ResponseEntity<User> rRu = wCu.get()
                    .uri("/"+idU)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(User.class)
                    .block();
            return rRu;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<User> saveU(User user) {
        try {
            ResponseEntity<User> rSu = wCu.post()
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(user), User.class)
                    .retrieve()
                    .toEntity(User.class)
                    .block();
            return rSu;
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
    public ResponseEntity<Integer> updateU(Long idU, User user) {
        try {
            ResponseEntity<Integer> rUu = wCu.put()
                    .uri("/"+idU)
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(user),User.class)
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
    public ResponseEntity<Integer> deleteU(Long idU) {
        try {
            ResponseEntity<Integer> rDu = wCu.delete()
                    .uri("/"+ idU)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Integer.class)
                    .block();
            return rDu;
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
