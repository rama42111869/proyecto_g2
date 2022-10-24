package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.DBModel.CreditCardJPA;
import com.ecommerce.ecommerce.DBModel.UserJPA;
import com.ecommerce.ecommerce.model.CreditCard;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.repositories.ICreditCardRepository;
import com.ecommerce.ecommerce.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService {

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserService userService;

    public Integer createN1ewCreditCard(CreditCard creditCard, Long userId){

        UserJPA userJPA = userRepository.findById(userId).get();

        CreditCardJPA creditCardJPA = new CreditCardJPA();
        creditCardJPA.setCreditCardNumber(creditCard.getCreditCardNumber());
        creditCardJPA.setUser(userJPA);
        creditCardJPA.setSecurityCode(creditCard.getSecurityCode());
        creditCardJPA.setExpirationDate(creditCard.getExpirationDate());

        
        creditCardRepository.save(creditCardJPA);
        return 1;
        
    }

    public CreditCard getCreditCardByUser(Long userId){
        CreditCardJPA creditCardJPA = creditCardRepository.findByUserId(userId);

        User user = userService.mapEntityToUser(creditCardJPA.getUser());

        CreditCard creditCard = new CreditCard();
        creditCard.setId(creditCardJPA.getId());
        creditCard.setExpirationDate(creditCardJPA.getExpirationDate());
        creditCard.setSecurityCode(creditCardJPA.getSecurityCode());
        creditCard.setCreditCardNumber(creditCardJPA.getCreditCardNumber());
        creditCard.setUser(user);

        
            return creditCard;

    }

    public Integer deleteOneCreditCard(Long id){
        Optional<CreditCardJPA> creditCardJPA = creditCardRepository.findById(id);

        if(creditCardJPA.isPresent()){
            creditCardRepository.deleteById(id);
            return 1;
        }
        return 0;
    }
}
