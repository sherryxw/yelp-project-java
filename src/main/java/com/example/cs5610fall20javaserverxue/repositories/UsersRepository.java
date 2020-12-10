package com.example.cs5610fall20javaserverxue.repositories;

import com.example.cs5610fall20javaserverxue.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Integer> {

    @Query(value = "select * from users where username=:username", nativeQuery = true)
    public User findUserByUsername(String username);

}





