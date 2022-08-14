package com.hicode.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter

public class Order implements Serializable{
    
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User userBuy;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String address;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate= new Date();

    private double totalPrice; 

    @OneToMany(mappedBy = "orderBuy")
    private List<OrderDetail> orderDetails;
}
