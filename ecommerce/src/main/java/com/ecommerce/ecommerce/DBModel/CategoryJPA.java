package com.ecommerce.ecommerce.DBModel;

import java.util.Set;

import javax.persistence.Entity;
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
    private String name;
    private String sizes;
    @OneToMany(mappedBy = "category")
    private Set<ProductJPA> products;

    public CategoryJPA(String name){
        this.name = name;
    }
}
