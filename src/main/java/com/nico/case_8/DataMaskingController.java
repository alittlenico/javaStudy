package com.nico.case_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/9 11:29
 */
@RestController
@RequestMapping("/dataMasking")
public class DataMaskingController {

    @GetMapping("/getUser")
    public User getUser() {
        User user = new User(1L,"liuyi","101@mail.com",new MyAddress("江西","泰和xx路"));
        return user;
    }
}
