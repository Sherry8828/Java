package com.example.demo;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController2 {
    @RequestMapping("/product")
    public Store product(){
        Store store = new Store();
        List<String> list=new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);
        return store;
    }

    @RequestMapping("/user")
    public Student user(){
        Student student = new Student();
        student.setName("Judy");
        return student;
    }
    @RequestMapping("/test1")
    public String test1(@RequestParam(defaultValue = "10",name = "qq") Integer id, @RequestParam String name){
        System.out.println("id"+id);
        System.out.println("name"+name);
        return "test1";
    }

}
