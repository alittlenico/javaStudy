package com.nico.case_13;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/11/15 21:15
 */
@Data
public class UserInfo {
    private Long id;
    private String name;
    private MultipartFile file;
}
