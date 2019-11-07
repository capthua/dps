package com.prs.dps.controller;


import com.prs.dps.common.constants.Constants;
import com.prs.dps.common.controller.BaseController;
import com.prs.dps.common.controller.Result;
import com.prs.dps.domain.User;
import com.prs.dps.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ffulauh on 2016/6/14.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/showUserWithCors")
    @ResponseBody
//    @CrossOrigin(origins = "http://localhost:8080")
    public Result showUserWithCors(int id, HttpServletResponse response) throws Exception {
//        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
//        Result result=new Result();
//        logger.error("hehe");
//        User han = userService.getUserById(id);
//        User han2 = userService.getUserByIdNonTransaction(id);
////        User han=new User();
////        han.setEmail("email");
////        han.setFullName("hanshoahua");
//        result.setData(han);
//        result.setResultCode(Constants.SUCCESS);

        Result result=new Result();
        User han=new User();
        han.setId(id);
//        han.setUpdateByEmail(1);
//        han.setFullName(Thread.currentThread().getName());
//        logger.error("hehe");
//        User han = userService.getUserById(id);
//        User han2 = userService.getUserByIdNonTransaction(id);
//        User han=new User();
//        han.setEmail("email");
//        han.setFullName("hanshoahua");
//        result.setData(han);
        userService.getUserById(id);
        result.setResultCode(Constants.SUCCESS);
        return result;
    }

    @RequestMapping("/showUser")
    @ResponseBody
//    @CrossOrigin(origins = "http://localhost:8080")
    public Result showUser(int id) throws Exception {
        Result result=new Result();
        User han=userService.getUserById(id);
        han.setId(id);
//        han.setUpdateByEmail(1);
//        han.setFullName(Thread.currentThread().getName());
//        logger.error("hehe");
//        User han = userService.getUserById(id);
//        User han2 = userService.getUserByIdNonTransaction(id);
//        User han=new User();
//        han.setEmail("email");
//        han.setFullName("hanshoahua");
//        result.setData(han);
//        userService.updateUser(han);
        result.setResultCode(Constants.SUCCESS);
        return result;
    }

}

