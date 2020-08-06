package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {
    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        //user.setId();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-111-111");
        user.setCreateAt(LocalDateTime.now());
        user.setCreateBy("TestUser01");

        User newUser = userRepository.save(user);
        System.out.println("newUser:"+ newUser);




    }
    public void read(){}
    public void update(){}
    public void delete(){}

}
