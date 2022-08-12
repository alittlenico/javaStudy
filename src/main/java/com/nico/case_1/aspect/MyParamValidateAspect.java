package com.nico.case_1.aspect;

import com.nico.case_1.exception.RRException;
import com.nico.case_1.utils.MyCheckNotNull;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/19 21:45
 */

@Slf4j
@Aspect
//@Order(1)
@Component
public class MyParamValidateAspect {

    @Pointcut("@annotation(com.nico.case_1.utils.MyCheckNotNull)")
    public void myParamValidatePointCut() {
        System.out.println("myParamValidatePointCut");
    }

    @Around("myParamValidatePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature =  (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        System.out.println("hhhh aspect");
        MyCheckNotNull annotation = method.getAnnotation(MyCheckNotNull.class);
        if (Objects.isNull(annotation)) {
            String value = annotation.value();
            if (value.length() > 0) {
                String[] checkParamArr = value.split(",");//注解配置需要校验的参数
                Object[] paramValue = point.getArgs();//api接口参数值
                String[] parameterNames = signature.getParameterNames();//api接口参数名称
                if (paramValue.length > 0) {
                    for (String checkParam : checkParamArr) {
                        validate(checkParam, paramValue, parameterNames);
                    }
                }else {
                    throw new RRException("参数与api接口不匹配！");
                }
            }else {
                throw new RRException("api接口若不需要校验参数，请不要使用此注解！");
            }
        }
        return point.proceed();
    }

    private static boolean isJavaClass(Class<?> clz) {
        return clz != null && clz.getClassLoader() == null;
    }

    private static void validate(String checkParam, Object[] paramValue, String[] parameterNames) {
        if(!ObjectUtils.isEmpty(paramValue)) {
            boolean flag = false;
            for(int i = 0;i < paramValue.length; ++i) {
                if (!Objects.isNull(paramValue[i])) {
                    if (!isJavaClass(paramValue[i].getClass())) {//参数是自定义对象
                        Class<?> clz = paramValue[i].getClass();
                        try {
                            Method clzMethod = clz.getMethod("get" + checkParam.substring(0, 1).toUpperCase() + checkParam.substring(1));
                            Object invoke = clzMethod.invoke(paramValue[i]);
                            if (invoke == null || invoke.toString().equals("")) {
                                throw new RRException("参数 "+checkParam+" 为空");
                            }else {
                                flag = true;
                            }
                        }catch (NoSuchMethodException e) {
                            log.error("没有在此对象中找到参数 "+checkParam+" 的getter setter方法");
                        }catch (InvocationTargetException | IllegalAccessException e) {
                            log.error(e.getMessage());
                        }catch (Exception e) {
                            log.error(e.getMessage());
                        }
                    }else {
                        //参数是系统类
                        if (paramValue[i] == null || "".equals(paramValue[i].toString())) {
                            throw new RRException("参数 "+checkParam+" 为空");
                        }else {
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) {
                //有参数没有必填
                throw new RRException("参数 "+checkParam+" 为空");
            }
        }else {
            throw new RRException("api接口入参未定义！请联系管理员！");
        }
    }

//    @Test
//    public void test() {
//        System.out.println(isJavaClass(Person.class));
//        System.out.println(StringBuilder.class.getClassLoader());
//    }
}
