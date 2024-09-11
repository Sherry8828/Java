package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component
public class CanonPrinter implements Printer, InitializingBean {
    private int count;
    @Override
    public void print(String message) {
        System.out.println("Canon印表機:"+message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //初始化
    }
}
