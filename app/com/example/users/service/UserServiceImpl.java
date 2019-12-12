package com.example.users.service;

import com.example.configuration.PlayConnectionProvider;
import com.example.models.tables.pojos.Users;
import com.example.models.tables.records.UsersRecord;
import com.example.users.dao.UserDaoImpl;
import com.example.users.models.UserVo;
import com.example.util.Crypto;
import com.google.inject.Inject;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.util.CollectionUtils;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements IUserService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private UserDaoImpl userDao;

    private PlayConnectionProvider playConnectionProvider;

    @Inject
    public UserServiceImpl(PlayConnectionProvider playConnectionProvider) {
        Configuration configuration = new DefaultConfiguration()
                .set(playConnectionProvider)
                .set(SQLDialect.POSTGRES);
        userDao = new UserDaoImpl(configuration);
    }

    @Override
    public Users createOrUpdateUser(UserVo user) {
        if (user.getUserId() != null) {
            List<Users> users = userDao.fetchByUserId(user.getUserId());
            if (CollectionUtils.isEmpty(users)) {
                return null;
            }
            UsersRecord record = new UsersRecord();
            record.from(user);
            Users updatedRecord = updateUserRecord(record, users.get(0));
            userDao.update(updatedRecord);
        } else {
            UsersRecord record = new UsersRecord();
            record.from(user);
            setPassword(record);
            record.setCreatedon(OffsetDateTime.now());
            record.setChangedon(OffsetDateTime.now());
            Users insertRecord = userDao.mapper().map(record);
            userDao.insert(insertRecord);
        }

        List<Users> updatedUser = userDao.fetchByUsername(user.getUsername());
        return updatedUser.get(0);
    }

    private void setPassword(UsersRecord usersRecord) {
        String firstTimePassword = Crypto.generateRandomPassword();
        logger.info("generated password " + firstTimePassword);
        String hashedPassword = BCrypt.hashpw(firstTimePassword, BCrypt.gensalt(15));
        usersRecord.setPassword(hashedPassword);
    }

    private Users updateUserRecord(UsersRecord record, Users originalRecord) {
        record.setUserId(originalRecord.getUserId());
        record.setPassword(originalRecord.getPassword());
        record.setStatus(originalRecord.getStatus());
        record.setSalt(originalRecord.getSalt());
        record.setCreatedon(originalRecord.getCreatedon());
        record.setChangedon(OffsetDateTime.now());
        return userDao.mapper().map(record);
    }


    @Override
    public boolean deleteUser(String userName) {
        List<Users> users = userDao.fetchByUsername(userName);
        if (CollectionUtils.isEmpty(users)) {
            return false;
        } else {
            userDao.delete(users.get(0));
            return true;
        }
    }

    @Override
    public List<Users> fetchUsers() {
        return userDao.findAll();
    }

    @Override
    public Users fetchUser(String userName) {
        List<Users> users = userDao.fetchByUsername(userName);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }
}
