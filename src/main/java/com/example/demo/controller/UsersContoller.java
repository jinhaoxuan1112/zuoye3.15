package com.example.demo.controller;

import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("users")
public class UsersContoller {
    @Autowired
    private UsersService usersService;
    @RequestMapping("findusers")
    @ResponseBody
    public PageInfo<Users> findusers(int pagenum){
        PageInfo<Users> usersPageInfo = usersService.pageinfo(pagenum);
        return usersPageInfo;
    }
    @RequestMapping("deletes")
    @ResponseBody
    public boolean deletes(int uid){
        if(usersService.delete(uid)){
            return true;
        }else{
            return false;
        }
    }
    @RequestMapping("insert")
    @ResponseBody
    public boolean insert(Users users){
        if(usersService.insert(users)){
            return true;
        }else{
            return false;
        }
    }
    @RequestMapping("findone")
    @ResponseBody
    public Users findone(int uid){
        return usersService.findone(uid);
    }

    @RequestMapping("update")
    @ResponseBody
    public boolean update(Users users){
        if(usersService.update(users)){
            return true;
        }else{
            return false;
        }
    }
    @RequestMapping("deleteall")
    @ResponseBody
    public boolean deleteall(String ids){
        boolean a = true;
       String[]idss = ids.split(",");
       for(int i=0;i<idss.length;i++){
           int id = Integer.parseInt(idss[i]);
           if(usersService.delete(id)){
           }else{
               a = false;
           }
       }
       return a;
    }
}
