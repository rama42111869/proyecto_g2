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
    private WebClient wCpr = new ApiConnection('p').getClient();

    @Override
    public ResponseEntity<Product[]> listAllPr() {
        try{
            ResponseEntity<Product[]> rLpr = wCpr.get()
                    .retrieve()
                    .toEntity(Product[].class)
                    .block();
            return rLpr;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Product[]> listPrCarrousel() {
        try{
            ResponseEntity<Product[]> rLprC = wCpr.get()
                    .uri("/carrouselProducts")
                    .retrieve()
                    .toEntity(Product[].class)
                    .block();
            return rLprC;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }
    @Override
    public ResponseEntity<Product[]> listPrSearchBar(String sValue){
        try{
            ResponseEntity<Product[]> rLprS = wCpr.get()
                                                .uri("/search/"+sValue)
                                                //.header("Authorization",SecurityConnection.getToken())
                                                .retrieve()
                                                .toEntity(Product[].class)
                                                .block();
            return rLprS;
//            ResponseEntity<Product[]> rLprS = wCpr.get().uri(uriBuilder -> uriBuilder
//                        .path("/search")
//                        .queryParam("param",param)
//                        .build())
//                    .retrieve()
//                    .toEntity(Product[].class)
//                    .block();
//            return rLprS;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Product[]> listPrCategory(String catN){
        try{
            ResponseEntity<Product[]> rLprC = wCpr.get()
                                            .uri("/category/"+catN)
                                            //.header("Authorization",SecurityConnection.getToken())
                                            .retrieve()
                                            .toEntity(Product[].class)
                                            .block();
            return rLprC;
//            ResponseEntity<Product[]> rLprS = wCpr.get().uri(uriBuilder -> uriBuilder
//                            .path("/category")
//                            .queryParam("param",param)
//                            .build())
//                    .retrieve()
//                    .toEntity(Product[].class)
//                    .block();
//            return rLprS;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Product[]> listPrPaginated(int offset,int pageSize){
        try{
            ResponseEntity<Product[]> rLprP = wCpr.get().uri(uriBuilder -> uriBuilder
                            .path("/pagination")
                            .queryParam("offset",offset)
                            .queryParam("pageSize",pageSize)
                            .build())
                    .retrieve()
                    .toEntity(Product[].class)
                    .block();
            return rLprP;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }


    @Override
    public ResponseEntity<Product> readPr(Long idP) {
        try{
            ResponseEntity<Product> rRpr = wCpr.get()
                    .uri("/"+idP)
                    //.header("Authorization",SecurityConnection.getToken())
                    .retrieve()
                    .toEntity(Product.class)
                    .block();
            return rRpr;
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Product> savePr(Long idC,Product product) {
        try {
            ResponseEntity<Product> rSpr = wCpr.post()
                    .uri("/"+idC)
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(product), Product.class)
                    .retrieve()
                    .toEntity(Product.class)
                    .block();
            return rSpr;
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
    public ResponseEntity<Product> updatePr(Long idP, Long idC, Product product) {
        try {
            ResponseEntity<Product> rUpr = wCpr.put()
                    .uri("/"+idP+"/"+idC)
                    //.header("Authorization",SecurityConnection.getToken())
                    .body(Mono.just(product),Product.class)
                    .retrieve()
                    .toEntity(Product.class)
                    .block();
            return rUpr;
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
            ResponseEntity<Integer> rDp = wCpr.delete()
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
}
