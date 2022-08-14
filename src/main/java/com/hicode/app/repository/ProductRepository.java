package com.hicode.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hicode.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double min, double max);
    //Truy vấn có sắp xếp

    @Query("Select p from Product p where p.price > ?1 order by p.price desc")
    List<Product> findByPrice1(double min);

    @Query("select p from Product p where p.price > :min")
    List<Product> findByPrice2(double min, Sort sort);

    //Truy vấn có phân trang
    @Query("select p from Product p where p.price > :min")
    List<Product> findByPrice3(double min, Pageable pageable);

    // ngôn ngữ Query DSL
    //findBy_
    List<Product> findByFullnameLike(String name);
    //countBy_
    long countByFullnameEquals(String name);
    //getBy_
    Product getByIdLikeIs(String id);

    //And
    List<Product> findByUsernameAndPassword(String username, String password);
    //Or
    List<Product> findByFullnameOrEmail(String fullname, String email);
    //Is,Equals
    List<Product> findByFullnameEquals(String fullname);
    //BETWEEN
    List<Product> findByPriceBetween(double min , double max );
    //Lessthan < 
    List<Product> findByPriceLessThan(double min );
    //Lessthanequals <=
    List<Product> findByPriceLessThanEqual( double max );
    //Greater than >
    List<Product> findByPriceGreaterThan(double min);
    //Greater than equals
    List<Product> findByPriceGreatThanEqual(double min);
    //IsNull
    List<Product> findByPriceIsNull();
    //IsNotNull,NotNull
    List<Product> findByPriceIsNotNull();
    //NotLike
    List<Product> findByFullnameNotLike(String fullname);

    //StartingWith
    List<Product> findByFullnameStartingWith(String fullname);
    //EndingWith
    List<Product> findByFullnameEndingWith(String fullname);
    //Containing
    List<Product> findByFullnameContaining(String fullname);
    //OrderBy
    List<Product> findByFullnameOrderByDesc(String fullname);
    //not
    List<Product> findByFullnameNot(String fullname);
    //in
    List<Product> findByFullnameIn(List<String> fullnames);
    //notin
    List<Product> findByFullnameNotIn(List<String> full);
    //true
    List<Product> findByFullnameTrue();
    //false
    List<Product> findByFullnameFalse();
    

    



}
