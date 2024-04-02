package com.aditi.springdatajpatutorial.Repository;

import com.aditi.springdatajpatutorial.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
