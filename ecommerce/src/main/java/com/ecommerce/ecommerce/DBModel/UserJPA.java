package com.ecommerce.ecommerce.DBModel;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserJPA {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false, unique = true)
//    private String mail;
//    @Column(nullable = false)
//    private String name;
//    @Column(nullable = false)
//    private String surname;
//    @OneToMany(mappedBy = "user")
//    private Set<PurchaseJPA> purchases;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String surname;
    
    private String mail;
    
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<PurchaseJPA> purchases;
     
    public UserJPA(String mail, String name, String surname) {
        this.mail = mail;
        this.name = name;
        this.surname = surname;
    }

    
}
