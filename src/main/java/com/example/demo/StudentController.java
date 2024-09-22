package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class StudentController {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    //限制前端使用post的方法，二擇一都可以
    @PostMapping("/students")
    //@RequestMapping(value = "/students",method = RequestMethod.POST)
    public String create(@RequestBody @Valid Student student) {
       /* if(student.getId()==null) {
            throw new RuntimeException("id不可為null");
        }*/
        return "資料庫create";
    }

    @GetMapping ("/students/{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId) {
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


    @PostMapping("/insertstudents")
    public String insert() {
        Map<String, Object> map = new HashMap<>();
        namedParameterJdbcTemplate.update("INSERT INTO student(id,name) VALUE (3,'John')",map);

        return "資料庫insert";
    }

}
