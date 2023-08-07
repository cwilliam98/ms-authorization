package com.programabolsas.instrutores.msauthorization.repositories;


import com.programabolsas.instrutores.msauthorization.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String email);

}
