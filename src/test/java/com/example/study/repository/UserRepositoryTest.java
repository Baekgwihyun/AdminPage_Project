package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        //user.setId();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-111-111");
        user.setCreateAt(LocalDateTime.now());
        user.setCreateBy("TestUser03");

        User newUser = userRepository.save(user);
        System.out.println("newUser:"+ newUser);

    }
    @Test
    public void read(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            System.out.println("user : "+ selectUser);
            System.out.println("email:" + selectUser.getEmail());

        });

    }
    @Test
    public void update() {


        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {

            selectUser.setAccount("pppp");
            selectUser.setUpdateAt(LocalDateTime.now());
            selectUser.setCreateBy("update method()");

            userRepository.save(selectUser);
        });
    }
    @Test

    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent()); // 데이터가 true

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });
        
        Optional<User> deleteUser = userRepository.findById(3L);

        Assert.assertFalse(deleteUser.isPresent()); // 데이터가 false
        
        /*if(deleteUser.isPresent()){
            System.out.println("데이터 존재:" + deleteUser.get()); // 데이터가 존재하는지 확인 get으로 가져온다
        }else{
            System.out.println("데이터 삭제 데이터 없음" );
        }*/


    }

}
