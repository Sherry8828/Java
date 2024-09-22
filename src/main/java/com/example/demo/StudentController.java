package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    //限制前端使用post的方法，二擇一都可以
    @PostMapping("/students")
    //@RequestMapping(value = "/students",method = RequestMethod.POST)
    public String create(@RequestBody Student student) {
        return "資料庫create";
    }

    @GetMapping ("/students/{studentId}")
    public String read(@PathVariable Integer studentId) {
        return "資料庫read";
    }
    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        //id查詢,body帶更新資訊

        return "資料庫update";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {

        return "資料庫delete";
    }
}
