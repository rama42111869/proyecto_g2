package com.acel.middleware.Controller;

import com.acel.middleware.Model.User;
import com.acel.middleware.Service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/middle/users")
@RestController
public class UserController {
        @Autowired
        private IUserService iU;

        @GetMapping()
        public ResponseEntity<User[]> listAll(){
            return iU.listAllU();
        }

        @PostMapping()
        public ResponseEntity<User> create(@RequestBody User user){
            return iU.saveU(user);
        }

        @GetMapping("/{idU}")
        public ResponseEntity<User> get(@PathVariable("idU") Long idU){
            return iU.readU(idU);
        }

        @PutMapping("/{idU}")
        public ResponseEntity<Integer> update(@PathVariable("idU") Long idU, @RequestBody User user){
            return iU.updateU(idU,user);
        }

        @DeleteMapping("/{idU}")
        public ResponseEntity<Integer> delete(@PathVariable("idU") Long idU){
            return iU.deleteU(idU);
        }
}
