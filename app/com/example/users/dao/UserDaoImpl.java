package com.example.users.dao;

import com.example.models.tables.daos.UsersDao;
import org.jooq.Configuration;

public class UserDaoImpl extends UsersDao {

    public UserDaoImpl(Configuration configuration) {
        super(configuration);
    }
}
