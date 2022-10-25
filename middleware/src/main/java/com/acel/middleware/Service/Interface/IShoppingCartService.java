package com.acel.middleware.Service.Interface;
import com.acel.middleware.Model.CartProduct;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IShoppingCartService {
    ResponseEntity<List<CartProduct>> listAllPrFromUs(Long userId);
    ResponseEntity<Integer> savePrToSc(Long userId, Long productId);
    ResponseEntity<Integer> deletePrFromSc(Long id);
}
