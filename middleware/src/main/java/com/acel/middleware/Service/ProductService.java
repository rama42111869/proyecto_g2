package com.acel.middleware.Service;

import com.acel.middleware.Model.Product;
import com.acel.middleware.Service.Connection.ApiConnection;
import com.acel.middleware.Service.Interface.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ProductService implements IProductService {
    private WebClient wCp = new ApiConnection('p').getClient();


    @Override
    public ResponseEntity<Integer> savePr(Product product) {
//        try {
//            ResponseEntity<Integer> rCp = wCp.post()
//                    //.header("Authorization",SecurityConnection.getToken())
//                    .body(Mono.just(product), Product.class)
//                    .retrieve()
//                    .toEntity(Integer.class)
//                    .block();
//            return rCp;
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

        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Integer> deletePr(Long id) {
//        try {
//            ResponseEntity<Integer> rDp = wCp.delete()
//                    .uri("/"+ id)
//                    //.header("Authorization",SecurityConnection.getToken())
//                    .retrieve()
//                    .toEntity(Integer.class)
//                    .block();
//            return rDp;
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
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<Integer> updatePr(Product product) {
//        try {
////            ResponseEntity<Integer> rUu = wCp.put()
////                    //.header("Authorization",SecurityConnection.getToken())
////                    .body(Mono.just(product),Product.class)
////                    .retrieve()
////                    .toEntity(Integer.class)
////                    .block();
////            return rUu;
////        }catch (WebClientResponseException e){
////            if(e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
////                return ResponseEntity.internalServerError().build();
////            }
////            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
////                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
////            }
////            return ResponseEntity
////                    .status(e.getStatusCode())
////                    .body((Integer.valueOf(e.getResponseBodyAsString())));
////        }
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<Product> readPr(Long id) {
//        try{
//            ResponseEntity<Product> rBp = wCp.get()
//                    //.header("Authorization",SecurityConnection.getToken())
//                    .retrieve()
//                    .toEntity(Product.class)
//                    .block();
//            return rBp;
//        }catch (WebClientResponseException e){
//            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//            }
//            return ResponseEntity.internalServerError().build();
//        }
        Product pEx = new Product(1l,"Air Force X Levis","Calzado urbano de tela de Jean",500f,"middleware/src/main/resources","Nike");
        return  ResponseEntity.status(HttpStatus.OK).body(pEx);
    }

    @Override
    public ResponseEntity<Product[]> listAllPr() {
//        try{
//            ResponseEntity<Product[]> lAp =wCp.get()
//                    //.header("Authorization",SecurityConnection.getToken())
//                    .retrieve()
//                    .toEntity(Product[].class)
//                    .block();
//            return lAp;
//        }catch (WebClientResponseException e){
//            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//            }
//            return ResponseEntity.internalServerError().build();
//        }

        Product pEx1 = new Product(1l,"Air Force X Levis","Calzado urbano de tela de Jean",700f,"middleware/src/main/resources","Nike");
        Product pEx2 = new Product(2l,"Air Force 1 X Louis Vuitton","Calzado urbano exclusivo",2000f,"middleware/src/main/resources","Nike");
        Product pEx3 = new Product(3l,"Chaqueta Takerlama Akira Kaneda","para hombre, abrigo rojo para Cosplay, cápsula, píldora estampada, bombardero, motociclista, disfraz de cuero, ropa de Anime",40f,"middleware/src/main/resources","AliRop");
        Product[] pExs = new Product[3];
        Array.set(pExs,0,pEx1);
        Array.set(pExs,1,pEx2);
        Array.set(pExs,2,pEx3);
        return ResponseEntity.status(HttpStatus.OK).body(pExs);
    }
}
