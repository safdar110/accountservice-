package com.itechneer.rasservproj.repository;

import com.itechneer.rasservproj.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Optional<User> findByUserName (String username);
    Optional<User> findByEmail(String email);

    //Boolean existsByUserName (String username);
    Boolean existsByEmail (String email);

    /*
    // Last Working COde
    List<User> findByName(String Name);
    List<User> findAll();

//    Object findByEmail(String email);
    */
}
