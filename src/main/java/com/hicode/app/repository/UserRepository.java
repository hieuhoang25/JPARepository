package com.hicode.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hicode.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
    @Query("select u from User u where u.password='lwd6PNBmw'")
    List<User> findByUserPassword();

    //JPQL có chứa tham số
    @Query("select u from User u where u.email=?1")
    List<User> findByEmail(String email);

    @Query("select u from User u where u.email=:email")
    List<User> findByEmail1(@Param("email") String email);

    //Truy vấn với câu lệnh sql đặc thù
    @Query(value="select * from Users where email like ?1", nativeQuery = true)
     List<User> getUsers(String email);

    @Query(value= "select count(*) from Users", nativeQuery=true)
    int countUsers();

    @Query(name="findByKeyword")
    List<User> findByKeyword(String keyword);
}
