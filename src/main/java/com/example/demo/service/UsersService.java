package com.example.demo.service;

import com.example.demo.domain.Users;
import com.github.pagehelper.PageInfo;

public interface UsersService {
    public boolean insert(Users users);
    public PageInfo<Users> pageinfo(int pagenum);
    public boolean delete(int uid);
    public boolean update(Users users);
    public Users findone(int uid);
}
