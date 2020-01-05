package com.prs.dps.service.impl;

import com.prs.dps.dao.UserDao;
import com.prs.dps.domain.User;
import com.prs.dps.service.TransactionTestService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionTestServiceImpl implements TransactionTestService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private SqlSession sqlSessionTemplate;

    //    //读提交测试
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public int t1(User user) {
        user.setId(1);
        User han = userDao.getUserById(user.getId());
        sqlSessionTemplate.clearCache();
        User han2 = userDao.getUserById(user.getId());
        user.setUsername("name_t1");
        int i= userDao.updateUser(user);
        return 1;
    }
    //解决抢单问题
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int t2(User user) {
        user.setId(1);
        User han = userDao.getUserById(user.getId());
        sqlSessionTemplate.clearCache();
        User han2 = userDao.getUserById(user.getId());
        user.setUsername("name_t2");
        int i= userDao.updateUser(user);
//        synchronized (this){
//            User han = userDao.getUserById(user.getId());
//            if(han.getUpdateByEmail().equals(0)){
//                user.setUpdateByEmail(1);
//                int i= userDao.updateUser(user);
//            }
//        }
        return 1;
    }

    @Transactional(isolation = Isolation.DEFAULT)
    public int t3(User user) {
        user.setId(1);
        User han = userDao.getUserById(user.getId());
        sqlSessionTemplate.clearCache();
        User han2 = userDao.getUserById(user.getId());
        user.setUsername("name_t3");
        int i= userDao.updateUser(user);
//        synchronized (this){
//            User han = userDao.getUserById(user.getId());
//            if(han.getUpdateByEmail().equals(0)){
//                user.setUpdateByEmail(1);
//                int i= userDao.updateUser(user);
//            }
//        }

        return 1;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int t4(User user) {
        user.setUpdateByEmail(1);
        user.setUsername("bill");
        user.setPassword("hehehe");
        user.setEmail("bill@ms.com");
        user.setFullName("bill gates");
        userDao.add(user);
//        synchronized (this){
//            User han = userDao.getUserById(user.getId());
//            if(han.getUpdateByEmail().equals(0)){
//                user.setUpdateByEmail(1);
//                int i= userDao.updateUser(user);
//            }
//        }

        return 1;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int t5(User user) {
        List<User> users=userDao.listUser4Transaction(user);
        sqlSessionTemplate.clearCache();
        List<User> users2=userDao.listUser4Transaction(user);
        return 1;
    }

}
