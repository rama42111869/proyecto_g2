package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<User> saveU(User user);
    public ResponseEntity<Integer> deleteU(Long idU);
    public ResponseEntity<Integer> updateUser(Long idU,User user);
    public ResponseEntity<User> readUById(Long idU);
    public ResponseEntity<User[]> listAllUsers();
}
