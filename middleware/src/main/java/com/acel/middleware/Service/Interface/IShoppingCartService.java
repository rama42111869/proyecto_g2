package com.acel.middleware.Service.Interface;
import com.acel.middleware.Model.CartProduct;
import org.springframework.http.ResponseEntity;

public interface IShoppingCartService {
    ResponseEntity<CartProduct[]> listAllPrFromUs(Long userId);
    ResponseEntity<Integer> savePrToSc(Long userId, Long productId);
    ResponseEntity<Integer> deletePrFromSc(Long id);
}
