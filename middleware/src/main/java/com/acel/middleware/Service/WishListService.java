package com.acel.middleware.Service;
import com.acel.middleware.Model.CartProduct;
import com.acel.middleware.Service.Connection.ApiConnection;
import com.acel.middleware.Service.Interface.IWishListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class WishListService implements IWishListService {
    private WebClient wCsc = new ApiConnection('s').getClient();

    @Override
    public ResponseEntity<CartProduct[]> getPrFromWL(Long userId) {
        try{
            ResponseEntity<CartProduct[]> rLpu = wCsc.get()
                    .uri("/"+userId)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(CartProduct[].class)
                    .block();
            return rLpu;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            if(e.getStatusCode() ==  HttpStatus.NO_CONTENT){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Integer> savePrToWL(Long userId, Long productId) {
        try {
            ResponseEntity<Integer> rSwl = wCsc.post()
                    .uri("/user/"+userId+"/product/"+productId)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Integer.class)
                    .block();
            return rSwl;
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
    public ResponseEntity<Integer> deletePrFromWL(Long id) {
        try {
            ResponseEntity<Integer> rDpwl = wCsc.delete()
                    .uri("/"+ id)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Integer.class)
                    .block();
            return rDpwl;
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
