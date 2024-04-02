package com.aditi.springdatajpatutorial.Repository;

import com.aditi.springdatajpatutorial.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRespository extends JpaRepository<UserProfile,String> {
}
