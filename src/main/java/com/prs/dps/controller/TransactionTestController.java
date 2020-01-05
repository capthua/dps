package com.prs.dps.controller;

import com.prs.dps.domain.User;
import com.prs.dps.service.TransactionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("transactionTest")
public class TransactionTestController {

    @Autowired
    TransactionTestService service;

    @RequestMapping("t1")
    @ResponseBody
    String t1(){
        service.t1(new User());
        return "t1";
    }

    @RequestMapping("t2")
    @ResponseBody
    String t2(){
        service.t2(new User());
        return "t2";
    }

    @RequestMapping("t3")
    @ResponseBody
    String t3(){
        service.t3(new User());
        return "t3";
    }

    @RequestMapping("t4")
    @ResponseBody
    String t4(){
        service.t4(new User());
        return "t4";
    }

    @RequestMapping("t5")
    @ResponseBody
    String t5(){
        service.t5(new User());
        return "t5";
    }


}
