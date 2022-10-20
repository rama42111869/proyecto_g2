package com.ecommerce.ecommerce.DBModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String description;
    
    private double price;
    
    private String images;
    
    private String brand;
    
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonBackReference
    private CategoryJPA category;
    
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<PurchaseJPA> purchases;

    public ProductJPA(String name, String description, double price, String images, String brand) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.images = images;
        this.brand = brand;
    }

    

}
