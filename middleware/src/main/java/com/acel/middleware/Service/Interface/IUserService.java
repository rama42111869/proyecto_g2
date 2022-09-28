package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<Integer> saveU(User user);
    public ResponseEntity<Integer> deleteU(Long id);
    public ResponseEntity<Integer> updateMyUser(User user);
    public ResponseEntity<User> readUByUsername(String username);
    public ResponseEntity<User[]> listAllUsers();
}
