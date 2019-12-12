package com.example.users.service;


import com.example.models.tables.pojos.Users;
import com.example.users.models.UserVo;
import com.google.inject.ImplementedBy;

import java.util.List;

@ImplementedBy(UserServiceImpl.class)
public interface IUserService {

    public Users createOrUpdateUser(UserVo user);

    public boolean deleteUser(String userName);

    public List<Users> fetchUsers();

    public Users fetchUser(String userName);
}
