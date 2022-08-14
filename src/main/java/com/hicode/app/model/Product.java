package com.hicode.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Products")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition = "nvarchar(50) not null")
    private String name;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    @Column(columnDefinition = "nvarchar(50)")
    private String image;

    @Column(columnDefinition = "nvarchar(50)")
    private String description;

    private double price;
    private int discount;

    @OneToMany(mappedBy = "productBuy")
    private List<OrderDetail> orderDetails;


}
