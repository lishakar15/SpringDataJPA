package com.aditi.springdatajpatutorial.Repository;

import com.aditi.springdatajpatutorial.Entity.Children;
import com.aditi.springdatajpatutorial.Entity.Parent;
import com.aditi.springdatajpatutorial.Entity.User;
import com.aditi.springdatajpatutorial.Entity.UserProfile;
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
    @Test
    public void saveParentChildDetails()
    {
        Parent p = Parent.builder().parentName("Ram Kumar").parentAge(36).build();
        Children c1 = Children.builder().childName("Anu Sri").childAge(16).parent(p).build();
        Children c2 = (Children.builder().childName("Sanjay").childAge(13)).parent(p).build();
        Children c3 = Children.builder().childName("Hannah").childAge(10).parent(p).build();
        List<Children> childList = new ArrayList<>(Arrays.asList(c1,c2,c3));
        parentRepository.save(p);
        childRepository.saveAll(childList);
    }
    @Test
    public void saveUserAndUserProfileDate()
    {
        UserProfile userProfile = UserProfile.builder().name("Lishakar").age(24).country("India").build();
        User user = User.builder().password("Pass@1234").role("Developer").build();
        userProfile.setUser(user);
        userRepository.save(user);
        userProfileRespository.save(userProfile);
    }

}
