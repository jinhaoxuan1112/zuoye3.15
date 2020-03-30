package com.example.demo;

import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UsersService usersService;

    @Test
    void contextLoads() {
    }
    @Test
    void selectall(){
        PageInfo<Users> usersPageInfo = usersService.pageinfo(1);
        List<Users> list = usersPageInfo.getList();
        for(Users users:list){
            System.out.println(users);
        }
    }

}
