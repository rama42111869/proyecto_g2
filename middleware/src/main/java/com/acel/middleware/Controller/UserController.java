package com.acel.middleware.Controller;

import com.acel.middleware.Model.User;
import com.acel.middleware.Service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/middle/user")
@RestController
public class UserController {
        @Autowired
        private IUserService iU;

        @GetMapping()
        public ResponseEntity<User[]> listAll(){
            return iU.listAllUsers();
        }

        @PostMapping()
        public ResponseEntity<Integer> create(@RequestBody User user){
            return iU.saveU(user);
        }

        @GetMapping("/{username}")
        public ResponseEntity<User> get(@PathVariable("username") String idU){
            return iU.readUByUsername(idU);
        }

        @PutMapping()
        public ResponseEntity<Integer> update(@RequestBody User user){
            return iU.updateMyUser(user);
        }

        @DeleteMapping("/{idU}")
        public ResponseEntity<Integer> delete(@PathVariable("idU") Long idU){
            return iU.deleteU(idU);
        }
}
