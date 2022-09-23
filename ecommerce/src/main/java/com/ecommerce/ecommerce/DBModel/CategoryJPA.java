package com.ecommerce.ecommerce.DBModel;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryJPA {
    @Id
    private String name;
    private String sizes;
    @OneToMany(mappedBy = "category")
    private Set<ProductJPA> products;
}
