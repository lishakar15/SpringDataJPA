package com.aditi.springdatajpatutorial.Repository;

import com.aditi.springdatajpatutorial.Entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RepositoryTestTwo {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileRespository userProfileRespository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Test
    public void saveParentChildDetails()
    {
        Parent p = Parent.builder().parentName("Ram Kumar").parentAge(36).build();
        Children c1 = Children.builder().childName("Anu Sri").childAge(16).parent(p).build();
        Children c2 = (Children.builder().childName("Sanjay").childAge(13)).parent(p).build();
        Children c3 = Children.builder().childName("Hannah").childAge(10).parent(p).build();
        List<Children> childList = new ArrayList<>(Arrays.asList(c1,c2,c3));
        //parentRepository.save(p);
        childRepository.saveAll(childList);
    }
    @Test
    public void getPrentDetails()
    {
        List<Parent> parents = parentRepository.findAll();
        System.out.println(parents);
    }
    @Test
    public void deleteParentById()
    {
        parentRepository.deleteById(2);
    }
    @Test
    public void saveUserAndUserProfileDate()
    {
        UserProfile userProfile = UserProfile.builder().name("Lishakar").age(24).country("India").build();
        User user = User.builder().password("Pass@1234").role("Developer").build();
        userProfile.setUser(user);
        //userRepository.save(user);
        userProfileRespository.save(userProfile);
    }
    @Test
    public void saveActorAndMovieDetails()
    {
        Movie m1 = Movie.builder().movieName("Top Gun").genere("Action").build();
        Movie m2 = Movie.builder().movieName("Bird Box").genere("Thriller").build();
        Actor act1 = Actor.builder().actorName("Tom Cruise").age(48).build();
        Actor act2 = Actor.builder().actorName("Miles Teller").age(31).build();
        Actor act3 = Actor.builder().actorName("Sandra Bullock").age(36).build();

        List<Actor> actors1 = Arrays.asList(act1, act2);
        m1.setActors(actors1);

        List<Actor> actors2 = Arrays.asList(act2, act3);
        m2.setActors(actors2);

        List<Movie> movies1 = Arrays.asList(m1);
        act1.setMovies(movies1);

        List<Movie> movies2 = Arrays.asList(m1, m2);
        act2.setMovies(movies2);

        List<Movie> movies3 = Arrays.asList(m2);
        act3.setMovies(movies3);

// Save actors and movies
        actorRepository.saveAll(Arrays.asList(act1, act2, act3));
        movieRepository.saveAll(Arrays.asList(m1, m2));
    }


}
