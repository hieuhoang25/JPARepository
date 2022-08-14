package com.hicode.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@NamedQuery(name="findByKeyword", query="select u from User u where u.fullname like ?1")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "nvarchar(50) not null")
    private String fullname;
    @Column(columnDefinition = "nvarchar(50) not null")
    private String password;
    @Column(columnDefinition = "nvarchar(50) not null")
    private String email;

    @Column(nullable = false)
    private boolean role;
    @Column(columnDefinition = "nvarchar(50)")
    private String phone;
    @Column(columnDefinition = "nvarchar(255)")
    private String address;

    @OneToMany(mappedBy ="userBuy")
    private List<Order> ordersOfUser;
}
