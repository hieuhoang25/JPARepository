package com.hicode.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hicode.app.model.User;
import com.hicode.app.repository.UserRepository;

@Controller
public class UserController {
    
    @Autowired
    UserRepository dao;

    @GetMapping("demo")
    @ResponseBody
    public List<User> index(){
        return dao.findByUserPassword();
    }

    @GetMapping("finduserbyname")
    @ResponseBody
    public List<User> find1(){
        return dao.findByEmail("hieuhoang@example.com");
    }

    @GetMapping("finduserbyname1")
    @ResponseBody
    public List<User> find2(){
        return dao.findByEmail1("hieuhoang@example.com");
    }
    @GetMapping("finduserbyemail")
    @ResponseBody
    public List<User> find3(){
        return dao.findByEmail1("vonghuynh@example.com");
    }

    @GetMapping("countUsers")
    @ResponseBody
    public int find4(){
        return dao.countUsers();
    }

    @GetMapping("findByKeyword")
    @ResponseBody
    public List<User> find5(){
        return dao.findByKeyword("Huỳnh Văn Vọng");
    }
    
}
