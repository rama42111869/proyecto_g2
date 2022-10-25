package com.acel.middleware.Service;
import com.acel.middleware.Model.CartProduct;
import com.acel.middleware.Model.Purchase;
import com.acel.middleware.Service.Connection.ApiConnection;
import com.acel.middleware.Service.Interface.IShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCartService {
    private WebClient wCpu = new ApiConnection('s').getClient();

    @Override
    public ResponseEntity<List<CartProduct>> listAllPrFromUs(Long userId) {
        try{
            ResponseEntity<Purchase[]> rLpu =wCpu.get()
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
    public ResponseEntity<Integer> savePrToSc(Long userId, Long productId) {
        return null;
    }

    @Override
    public ResponseEntity<Integer> deletePrFromSc(Long id) {
        return null;
    }
}
