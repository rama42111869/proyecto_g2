package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.CartProduct;
import org.springframework.http.ResponseEntity;

public interface IWishListService{
    public ResponseEntity<CartProduct[]> getPrFromWL(Long userId);
    ResponseEntity<Integer> savePrToWL(Long userId,Long productId);
    ResponseEntity<Integer> deletePrFromWL(Long id);
}
