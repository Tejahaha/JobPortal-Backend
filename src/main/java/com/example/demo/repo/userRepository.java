package com.example.demo.repo;


import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User , String> {

    @Query("Select count(u) from User u where u.email =:email")
    public int validateEmail(@Param("email") String email);



    @Query("select count(U) from User U where U.email=:email and U.password=:password")
    int validateCredentials(@Param("email") String email, @Param("password") String password);
}
