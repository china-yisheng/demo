package com.example.collecton.controller;

import com.base.utils.log.AopLog;
import com.example.collecton.service.impl.MerchantImpl;
import com.example.collecton.entity.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Test {

    @Autowired
    public MerchantImpl merchant;

    @RequestMapping(value = "/abc",method = RequestMethod.GET)
    public String string(){
        return "Hello World";
    }

    @GetMapping("/insert")
    public int insert(){
        Merchant merchant =new Merchant();
        merchant.setId("2");
        merchant.setMobile("12345");
        merchant.setPass("123456");
        merchant.setShopName("阿斯顿");
        int a = this.merchant.count(merchant);
        return a;
    }

    @GetMapping("/select")
    @AopLog(actionType = "1")
    public List<Merchant> merchants(){
        List<Merchant> a=this.merchant.all();
        return a;
    }

    @PostMapping("/add")
    public  String add(String location, String brand, String moneyOut){
        System.out.println(location);
        return "add";
    }

}
