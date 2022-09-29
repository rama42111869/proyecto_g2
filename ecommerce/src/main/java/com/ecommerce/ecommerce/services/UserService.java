package com.ecommerce.ecommerce.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.UserJPA;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.repositories.IUserRepository;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserRepository userRepository;

    public User getOneUser(Long id){
        Optional<UserJPA> user = userRepository.findById(id);
        if(user.isPresent()){
            return mapEntityToUser(user.get());
        }
        else {
            return null;
        }
    }

    public List<User> getAllUsers(){
        List<User> allUsers = new LinkedList<User>();
    
        for (UserJPA userJPA : userRepository.findAll()) {
            allUsers.add(mapEntityToUser(userJPA));
        }

        return allUsers;
    }

    public User createNewUser(User user){
        if(user != null){
            UserJPA userJPA = mapUserToEntity(user);

            userRepository.save(userJPA);

            return user;
        }
        return null;
    }
    
    public User updateUser(Long id, User user){
        if(userRepository.existsById(id)){
            UserJPA userToUpdate = userRepository.findById(id).get();

            User User = mapEntityToUser(userToUpdate);

            User.setName(user.getName());
            User.setSurname(user.getSurname());
            User.setMail(user.getMail());

            userRepository.save(mapUserToEntity(User));

            return user;
        }
        return null;
    }

    public User deleteUser(Long id){
        if(userRepository.existsById(id)){
            UserJPA userToDelete = userRepository.findById(id).get();

            User userDeleted = mapEntityToUser(userToDelete);

            userRepository.deleteById(id);

            return userDeleted;
        }
        return null;
    }


    /* MAPPERS */

    public User mapEntityToUser(UserJPA userJPA) {
        User mapedProduct = modelMapper.map(userJPA, User.class);
        return mapedProduct;
    }

    public UserJPA mapUserToEntity(User user) {
        //UserJPA mapedJPA = modelMapper.map(User.class, UserJPA.class);
        UserJPA mapedJPA = new UserJPA(user.getMail(), user.getName(), user.getMail());
        return mapedJPA;
    }

}
