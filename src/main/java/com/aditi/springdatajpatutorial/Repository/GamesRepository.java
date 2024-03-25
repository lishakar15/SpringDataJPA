package com.aditi.springdatajpatutorial.Repository;

import com.aditi.springdatajpatutorial.Entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games,Integer> {
   public Games findGamesByName(String name);
   public List<Games> findGamesByNameContaining(String str);
}
