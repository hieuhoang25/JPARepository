package com.hicode.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Categories")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Category implements Serializable {
    @Id
    @Column(length = 10)
    private String id;
    @Column(columnDefinition = "nvarchar(20) not null")
    private String name;

    @OneToMany(mappedBy ="category")
    private List<Product> productsOfCategory;
}
