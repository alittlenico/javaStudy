package com.nico.case_1.controller;

import com.nico.case_1.entity.Person;
import com.nico.case_1.entity.Person1;
import com.nico.case_1.entity.Student;
import com.nico.case_1.utils.MyCheckNotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/19 21:08
 */
@Slf4j
@RestController
@RequestMapping("javaStudy/")
//@MyCheckNotNull("ssss")
@Validated
public class TestController {

//    @MyCheckNotNull("")
    @PostMapping(value = "/addPerson", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void checkIdCard(@RequestBody @Validated Person person) {
        log.info(person.getName());
//        System.out.println("hhh"+person.getIdCard());
    }

    @GetMapping("/checkTest")
    public void checkTest(@RequestBody @Validated Person person) {
        log.info(person.getName());
    }


    @PostMapping("/add")
    public void add(@RequestBody Student student) {

    }
    @PutMapping("/update")
    public void update(@RequestBody @Validated(Student.Update.class) Student student) {

    }

    @PostMapping(value = "testIDCardValidate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void testIDCardValidate(@RequestBody Person1 p) {
        System.out.println(p.toString());
    }
}
