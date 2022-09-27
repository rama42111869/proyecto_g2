package com.ecommerce.ecommerce.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.repositories.IUserRepository;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserRepository userRepository;

    public UserModel getOneUser(Long id){
        if(userRepository.existsById(id)){
            UserModel user = mapEntityToUser(userRepository.findById(id).get());

            return user;
        }
    }

    public List<UserModel> getAllUsers(){
        List<UserModel> allUsers = mapEntityToUser(userRepository.findAll().toList());

        return allUsers;
    }

    public UserModel createNewUser(UserModel user){
        if(user != null){
            UserJPA userJPA = mapUserToEntity(user);

            userRepository.save(userJPA);

            return user;
        }
        return null;
    }
    
    public UserModel updateUser(Long id, UserModel user){
        if(userRepository.existsById(id)){
            UserJPA userToUpdate = userRepository.findById(id).get();

            UserModel userModel = mapEntityToUser(userToUpdate);

            userModel.setName(user.getName());
            userModel.setSurname(user.getSurname);
            userModel.setMail(user.getMail());

            userRepository.save(mapUserToEntity(userModel));

            return user;
        }
        return null;
    }

    public UserModel deleteUser(Long id){
        if(userRepository.existsById(id)){
            UserJPA userToDelete = userRepository.findById(id).get();

            UserModel userDeleted = mapEntityToUser(userToDelete);

            userRepository.deleteById(id);

            return userDeleted;
        }
        return null;
    }


    /* MAPPERS */

    public UserModel mapEntityToUser(UserJPA userJPA) {
        UserModel mapedProduct = modelMapper.map(userJPA, UserModel.class);
        return mapedProduct;
    }

    public UserJPA mapUserToEntity(UserModel user) {
        UserJPA mapedJPA = modelMapper.map(UserModel, UserJPA.class);
        return mapedJPA;
    }

}
