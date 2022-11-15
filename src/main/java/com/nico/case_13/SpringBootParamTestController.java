package com.nico.case_13;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/11/15 15:53
 */

@RestController
@RequestMapping("/case13")
@Slf4j(topic = "测试springboot前后端接收参数")
public class SpringBootParamTestController {

    /**
     * get body体里面内放数据
     * get post @RequestParam都能接收url和form-data里的数据
     * springboot会根据发送数据的content-type来解析数据,一般不用设置接收数据类型
     */

    /**
     * 映射键值对象
     * 前端传参:1.url ?age=1&name=2 可接收
     *         2.body form-data 可接收
     *         3.body json 不可接收 需把接收类型改为application/json,参数加上@RequestBody
     * @param user
     */
    @GetMapping(value = "/get02")
    public void get02(@RequestBody User user) {
        log.info("user.getAge():{}",user.getAge());
        log.info("user.getName():{}",user.getName());
    }

    /**
     * 1.url 接收不到
     * 2.form-data 接收不到
     * 3.json 接收不到
     * 加上@RequestParam 1,2可以接收到
     * 加上@RequestBody json可以接收到
     * @param map
     */
    @GetMapping(value = "/get04")
    public void get04(@RequestBody Map<String, Object> map) {
        log.info("/get04");
        map.forEach((k,v) -> {
            log.info("k:{}",k);
            log.info("v:{}",v);
        });
    }

    /**
     * 参数和路径结合，适用于单个参数的情况
     * 不加参数会找不到路径
     * */
    @GetMapping("/get06/{id}")
    public void getById(@PathVariable("id")String id) {
        log.info("id:{}",id);
    }

    //post 传递json串 映射为数组和List是一样的
    /**
     * post 传递json数组
     * @param users
     */
    @PostMapping(value = "postArray",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postArray(@RequestBody User[] users) {
        for (User u : users) {
            log.info("u.getAge():{},u.getName():{}",u.getAge(),u.getName());
        }
    }

    /**
     * post 映射list
     * @param users
     */
    @PostMapping(value = "postList",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postList(@RequestBody List<User> users) {
        for (int i = 0;i < users.size();i++) {
            log.info("u.getAge():{},u.getName():{}",users.get(i).getAge(),users.get(i).getName());
        }
    }

    String baseDir = "D:\\documentFile\\code\\develop\\project\\AJustForStudyDemo\\JavaStudy\\src\\main\\java\\com\\nico\\case_13";

    /**
     * 传递二进制数据
     * */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            try {
                file.transferTo(new File(baseDir, fileName)); // 对于 SpringBoot 中使用路径还是懵逼！
                return "success";
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Fail";
    }

    /**
     *  表单数据，含文本和二进制
     * */
    @PostMapping(value = "/postMultifileAndParam")
    public String postMultifileAndParam(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("file") MultipartFile file) {

        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("fileName: " + file != null ? file.getOriginalFilename() : "null");

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            try {
                file.transferTo(new File(baseDir, fileName));
                return "success";
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "fail";
    }

    /**
     * 表单数据封装成对象
     * @param user
     * @return
     */
    @PostMapping("/submitInfo02")
    public String submitInfo02(UserInfo user) {

        MultipartFile file = user.getFile();
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());
        System.out.println("fileName: " + user != null ? file.getOriginalFilename() : "null");

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            try {
                file.transferTo(new File(baseDir, fileName));
                return "success";
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Fail";
    }
}
