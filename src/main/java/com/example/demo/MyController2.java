package com.example.demo;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student){
        System.out.println("student id "+student.getId());
        System.out.println("student name "+student.getName());
        return "test2";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader String info){
        System.out.println("info "+info);
        return "test3";
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id, @PathVariable String name){
        System.out.println("path id "+id);
        System.out.println("path name "+name);
        return "test4";
    }

}
