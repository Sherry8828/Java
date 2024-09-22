package com.example.demo;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;


    @RequestMapping("/test")
    public String test(){
        System.out.println("Hi!");
        printer.print("Hello 你好嗎");
        return "Hello World!";
    }

    @RequestMapping("/test5")
    public ResponseEntity<String> test5(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World!");
    }


}
