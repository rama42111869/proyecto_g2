package com.acel.middleware.Service.Interface;

import com.acel.middleware.Model.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<User[]> listAllU();
    public ResponseEntity<User> readU(Long idU);
    public ResponseEntity<User> saveU(User user);
    public ResponseEntity<Integer> updateU(Long idU, User user);
    public ResponseEntity<Integer> deleteU(Long idU);
}
