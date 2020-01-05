package com.prs.dps.dao;

import com.prs.dps.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ffulauh on 2016/6/4.
 */
@Repository("userDao")
public interface UserDao {

    User getUserById(Integer id);

    int saveUser(User user);

    int updateUser(User user);

    List<User> listUsers(User param);
    List<User> listUser4Transaction(User param);

    int add(User user);
}