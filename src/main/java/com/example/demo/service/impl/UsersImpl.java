package com.example.demo.service.impl;

import com.example.demo.dao.UsersDao;
import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Override
    public boolean insert(Users users) {
        int num = usersDao.insert(users);
        if(num==1){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<Users> pageinfo(int pagenum) {
        PageHelper.startPage(pagenum, 3);
        List<Users> list = usersDao.selectAll();
        PageInfo<Users> pageInfo = new PageInfo<Users>(list);
        return pageInfo;
    }

    @Override
    public boolean delete(int uid) {
        int num = usersDao.deleteByPrimaryKey(uid);
        if(num==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Users users) {
        int num = usersDao.updateByPrimaryKey(users);
        if(num==1){
            return true;
        }
        return false;
    }

    @Override
    public Users findone(int uid) {
        Users users = usersDao.selectByPrimaryKey(uid);
        return users;
    }
}
