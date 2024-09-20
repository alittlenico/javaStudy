//package com.nico.case_15;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import com.alibaba.excel.write.metadata.WriteTable;
//import org.junit.jupiter.api.Test;
//
//import java.io.OutputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author liuyi
// * @version 1.0
// * @description: TODO
// * @date 2023/2/19 16:13
// */
//public class EasyExcelTest {
//
//    @Test
//    public void test0() throws Exception{
//        OutputStream outputStream = Files.newOutputStream(Path.of("d://" + System.currentTimeMillis() + ".xlsx"));
//        ExcelWriter excelWriter = EasyExcel.write(outputStream).build();
//        WriteSheet writeSheet = EasyExcel.writerSheet("模板").needHead(Boolean.FALSE).build();
//        List<String> title = Arrays.asList("bigtitle", "标题2-1");
//        List<String> title1 = Arrays.asList("bigtitle", "标题2-2");
//        List<List<String>> bigtitle = new ArrayList<>();
//        bigtitle.add(title);
//        bigtitle.add(title1);
//
//        List<String> title2 = Arrays.asList("bigtitle", "标题2-3");
//        List<List<String>> bigtitle1 = new ArrayList<>();
//        bigtitle1.add(title);
//        bigtitle1.add(title1);
//        bigtitle1.add(title2);
//        WriteTable writeTable0 = EasyExcel.writerTable(0).needHead(true).head(bigtitle).build();
//        WriteTable writeTable1 = EasyExcel.writerTable(1).needHead(true).head(bigtitle1).build();
//        excelWriter.write(getData(2), writeSheet, writeTable0);
//        excelWriter.write(getData(3), writeSheet, writeTable1);
//
//    }
//
//    private static List<List<String>> getData(int r) {
//        List<List<String>> list=new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            ArrayList<String> l1 = new ArrayList<>();
//            for (int i1 = 0; i1 < r; i1++) {
//                l1.add(i1+"");
//            }
//            list.add(l1);
//        }
//        return list;
//    }
//
//    @Test
//    public void test() {
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime time = LocalDateTime.of(2023, 1, 1, 0, 0, 0);
//        System.out.println(time);
//    }
//}
