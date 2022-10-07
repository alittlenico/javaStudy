package com.nico.case_7.defer_result_demo.scene2;

import com.nico.case_7.ResponseMsg;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/7 18:36
 */
@Component
@Data
public class TaskSet {

    private Set<DeferredResult<ResponseMsg<String>>> set = new HashSet<>();

}
