package com.hicode.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hicode.app.model.Product;
import com.hicode.app.repository.ProductRepository;

@Controller
public class ProductController {
    
    @Autowired
    ProductRepository dao;

    @GetMapping("price")
    @ResponseBody
    public List<Product> getProducts(){
        return dao.findByPrice(10000, 40000);
    }
    @GetMapping("sapxep1")
    @ResponseBody
    public List<Product> orderByPrice(){
        return dao.findByPrice1(1000000);
    }
    @GetMapping("sapxep2")
    @ResponseBody
    public List<Product> orderByPrice2(){
        return dao.findByPrice2(10000, Sort.by(Direction.DESC, "price"));
    }

    @GetMapping("phantrang")
    @ResponseBody
    public List<Product> orderByPrice3(){
        Pageable pager = PageRequest.of(0, 5);

        return dao.findByPrice3(10000, pager);
    }
}   
