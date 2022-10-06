package com.ecommerce.ecommerce.DBModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false)
//    private String name;
//    @Column(columnDefinition = "text")
//    private String description;
//    @Column(nullable = false)
//    private float price;
//    @Column(columnDefinition = "text")
//    private String images;
//    private String brand;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "category", nullable = false)
//    private CategoryJPA category;
//    @OneToMany(mappedBy = "product")
//    private Set<PurchaseJPA> purchases;
    
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
