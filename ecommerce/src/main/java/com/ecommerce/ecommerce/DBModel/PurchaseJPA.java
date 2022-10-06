package com.ecommerce.ecommerce.DBModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Purchase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseJPA {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "product_id", nullable = false)
//    private ProductJPA product;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserJPA user;
//    @Column()
//    private short amount = 1;
//    @Column(name = "date", nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date date;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date date;
    
    private int amount;
    
    @ManyToOne
    @JoinColumn(name = "product")
    @JsonBackReference
    private ProductJPA product;
    
    @ManyToOne
    @JoinColumn(name = "user")
    @JsonBackReference
    private UserJPA user;
    
    public PurchaseJPA(Date date, int amount, ProductJPA product, UserJPA user){
        this.date = date;
        this.amount = amount;
        this.product = product;
        this.user = user;
    }
   
}
