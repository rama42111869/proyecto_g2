package com.ecommerce.ecommerce.DBModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    private String sizes;
    
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    List<ProductJPA> products;

    public CategoryJPA(String name){
        this.name = name;
    }
    
    public CategoryJPA(String name, String sizes){
        this.name = name;
        this.sizes = sizes;
    }
}
