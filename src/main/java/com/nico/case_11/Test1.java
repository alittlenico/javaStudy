package com.nico.case_11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/17 11:44
 */
@Slf4j(topic = "case_11.Test1")
public class Test1 {
    private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/java-study?useSSL=false&serverTimezone=GMT%2B8";

//   private static String dbUrl = "jdbc:mysql://192.168.30.128:3306/dahaizi?useSSL=false&serverTimezone=GMT%2B8";
    private static String user = "root";
    private static String pwd = "root";

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, user, pwd);
            String sql = "insert into test01(id,name,x,y) value(?, concat('姓名',?), ?, ?)";
            ps = conn.prepareStatement(sql);
            long start = System.currentTimeMillis();
            log.info("开始");
            for(int i = 1;i <= 10e5;++i) {
                ps.setLong(1,i);
                ps.setLong(2, i);
                ps.setString(3, "xxxxxxxxxxxxx");
                ps.setString(4, "yyyyyyyyyyyyy");
                ps.executeUpdate();
            }
            long end = System.currentTimeMillis();
            log.info("用时:{}ms",end - start);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test() {
        List<Integer> a = Arrays.asList(1,2,3);
        Collections.swap(a,0,2);
        a.stream().forEach(System.out::println);
//        int temp = a.get(0);
////        a.get(0) = a.get(2);
////        a.get(2) = temp;
    }
}
