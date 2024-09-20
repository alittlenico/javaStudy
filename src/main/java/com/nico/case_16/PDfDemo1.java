package com.nico.case_16;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2023/3/15 14:15
 */
public class PDfDemo1 {
    public static void main(String[] args) throws Exception{
        LocalDateTime now = LocalDateTime.now();

        FileOutputStream out = new FileOutputStream("d:\\test1.pdf");
        BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
        Document doc = new Document();
        PdfWriter writer = PdfWriter.getInstance(doc, out);

        doc.open();

        //第一行
        Paragraph paragraphBlue = new Paragraph("", fontChinese);
        paragraphBlue.setLeading(20f);// 行间距
        paragraphBlue.setAlignment(Element.ALIGN_CENTER);
        Font fontSize20 = new Font(bfChinese, 20, Font.BOLD);

        Chunk chunk1 = new Chunk("配电能效月度运维报告");
        chunk1.setFont(fontSize20);
        paragraphBlue.add(chunk1);
        doc.add(paragraphBlue);

        //第二行
        Paragraph paragraphBlue1 = new Paragraph("", fontChinese);
        paragraphBlue.setLeading(10f);// 行间距
        paragraphBlue.setAlignment(Element.ALIGN_CENTER);
        Font fontSize12 = new Font(bfChinese, 12, Font.BOLD);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月");

        Chunk chunk2 = new Chunk("报告生成日期:"+ df.format(LocalDateTime.now()));
//        chunk2.setBackground(BaseColor.WHITE,470, 10, 10, 10 );
        chunk2.setFont(fontSize12);
        paragraphBlue1.add(chunk2);
        //设置对齐
        paragraphBlue1.setAlignment(Element.ALIGN_RIGHT);
        paragraphBlue1.setIndentationRight(0);
        doc.add(paragraphBlue1);

        Font font15 = new Font(bfChinese, 15, Font.BOLD);
        String custBranchName = "VR996无良还不倒闭公司";
        Paragraph paragraphBlue2 = new Paragraph("尊敬的:"+custBranchName, font15);
        paragraphBlue2.setAlignment(Element.ALIGN_LEFT);
        doc.add(paragraphBlue2);

        Font font15Normal = new Font(bfChinese, 15, Font.NORMAL);
        String str = "为了方便您能了解贵公司配电设备运行情况,现将本月<<配电能效运维报告>>呈送于您,如需查看详细信息,请登录贵公司监控系统浏览。";
        Paragraph paragraphBlue3 = new Paragraph(str, font15Normal);
        paragraphBlue3.setAlignment(Element.ALIGN_LEFT);
        paragraphBlue3.setFirstLineIndent(font15Normal.getSize() * 2);

        paragraphBlue3.setSpacingAfter(font15Normal.getSize() * 3);
        doc.add(paragraphBlue3);

        Paragraph paragraphBlue4 = new Paragraph("一、本月用电概况", font15);
        paragraphBlue4.setSpacingAfter(font15Normal.getSize());
        doc.add(paragraphBlue4);

        //用电概况
        //按站房来统计数据
        for(int i = 0;i < 1; ++i) {

            Paragraph stationName = new Paragraph("xx站房", font15Normal);
            stationName.setSpacingAfter(font15Normal.getSize());
            doc.add(stationName);

            PdfPTable table = new PdfPTable(6);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.getDefaultCell().setFixedHeight(30);
            table.setWidthPercentage(100);
            table.setTotalWidth(500);
            table.setTotalWidth(new float[] {30,130,90,45,85,120});
            table.getDefaultCell().setBorderWidth(1);// 边框宽度

            // 添加表头元素
            table.addCell(new Paragraph("户号", fontChinese));
            table.addCell(new Paragraph("", fontChinese));
            table.addCell(new Paragraph("总容量", fontChinese));
            table.addCell(new Paragraph("", fontChinese));
            table.addCell(new Paragraph("用电类别", fontChinese));
            table.addCell(new Paragraph("大工业", fontChinese));

            // 添加表格的内容


//        PdfPCell cell3 = new PdfPCell(new Paragraph("用电趋势图", fontChinese));
//        cell3.setColspan(6);
//        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell3);
//
//        String imgPath = "d:\\1.png";
//        // 在表格添加图片
//        Image cellimg = Image.getInstance(imgPath);
//        PdfPCell cell4 = new PdfPCell(cellimg, true);
//        cell4.setBorderColor(BaseColor.RED);
//        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell4.setColspan(6);
////        cell4.setRowspan(4);
//        table.addCell(cell4);
//        table.setSpacingBefore(10f);// 设置表格上面空白宽度
            doc.add(table);

            PdfPTable table2 = new PdfPTable(6);
            table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            table2.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table2.getDefaultCell().setFixedHeight(30);
            table2.setWidthPercentage(100);
            table2.setTotalWidth(500);
            table2.setTotalWidth(new float[] { 100, 60, 90, 130,60,60 });
            table2.getDefaultCell().setBorderWidth(1);// 边框宽度

            // 添加表头元素
            table2.addCell(new Paragraph("变压器数量(台)", fontChinese));
            table2.addCell(new Paragraph("", fontChinese));
            table2.addCell(new Paragraph("统计时段", fontChinese));
            table2.addCell(new Paragraph("", fontChinese));
            table2.addCell(new Paragraph("运行天数", fontChinese));
            table2.addCell(new Paragraph("", fontChinese));
            doc.add(table2);

            PdfPTable table3 = new PdfPTable(4);
            table3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            table3.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table3.getDefaultCell().setFixedHeight(30);
            table3.setWidthPercentage(100);
            table3.setTotalWidth(500);
            table3.setTotalWidth(new float[] { 100, 150, 130, 120 });
            table3.getDefaultCell().setBorderWidth(1);// 边框宽度

            // 添加表头元素
            table3.addCell(new Paragraph("项目", fontChinese));
            table3.addCell(new Paragraph("电量(kwh)", fontChinese));
            table3.addCell(new Paragraph("单价(元)", fontChinese));
            table3.addCell(new Paragraph("金额(元)", fontChinese));

            //
            table3.addCell(new Paragraph("尖时段", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("尖电价(含附加费)", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("峰时段", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("峰电价(含附加费)", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("平时段", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("平电价(含附加费)", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("谷时段", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("谷电价(含附加费)", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("电量", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("综合平均电价", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("基本电费", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));
            table3.addCell(new Paragraph("容量单价/需量单价", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("考核功率因素", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));
            table3.addCell(new Paragraph("当月功率因素", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("力调系数", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));
            table3.addCell(new Paragraph("力调电费金额", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));


            PdfPCell table3cell = new PdfPCell(new Paragraph("本月综合电费合计(元)", fontChinese));
            table3cell.setColspan(3);
            table3cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table3cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table3.addCell(table3cell);

            PdfPCell table3cell2 = new PdfPCell(new Paragraph("-", fontChinese));
            table3cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table3cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table3.addCell(table3cell2);

            //
            table3.addCell(new Paragraph("最大需量(kw)", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("最大需量时间", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));

            table3.addCell(new Paragraph("系统预警统计次数(次)", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("过复核实时预警次数", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("力调电费实时预警次数", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));
            table3.addCell(new Paragraph("计费方式切换提醒次数", fontChinese));
            table3.addCell(new Paragraph("-", fontChinese));

            table3.addCell(new Paragraph("本月设备巡视次数", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("累积发现缺陷项", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));

            table3.addCell(new Paragraph("已处理缺陷项", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));
            table3.addCell(new Paragraph("未处理缺陷(项)", fontChinese));
            table3.addCell(new Paragraph("", fontChinese));

            PdfPCell table3cell3 = new PdfPCell(new Paragraph("用电套餐优化建议", fontChinese));
            table3cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            table3cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table3.addCell(table3cell3);

            PdfPCell table3cell4 = new PdfPCell(new Paragraph("-", fontChinese));
            table3cell4.setColspan(3);
            table3cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            table3cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table3.addCell(table3cell4);

            //统计用电量
//            String imgPath = "d:\\1.png";
//            // 在表格添加图片
//            Image cellimg = Image.getInstance(imgPath);
//            PdfPCell cell4 = new PdfPCell(cellimg, true);
//            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell4.setColspan(4);
//        //        cell4.setRowspan(4);
//            table3.addCell(cell4);

            doc.add(table3);
        }

        Paragraph paragraphBlue5 = new Paragraph("一、变压器运维情况1", font15);
        paragraphBlue5.setSpacingAfter(font15Normal.getSize());
        doc.add(paragraphBlue5);

        //先按站房
        for (int i = 0;i < 1;++i) {
            //再按站房所有得变压器
            for(int j = 0;j < 1;++j) {
                PdfPTable table = new PdfPTable(6);
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
                table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.getDefaultCell().setFixedHeight(30);
                table.setWidthPercentage(100);
                table.setTotalWidth(500);
                table.setTotalWidth(new float[] {90,50,60,50,140,110});
                table.getDefaultCell().setBorderWidth(1);// 边框宽度

                table.addCell(new Paragraph("变压器容量(kVA)", fontChinese));
                table.addCell(new Paragraph("", fontChinese));
                table.addCell(new Paragraph("变压器类型", fontChinese));
                table.addCell(new Paragraph("", fontChinese));
                table.addCell(new Paragraph("额定电流A(高压/低压)", fontChinese));
                table.addCell(new Paragraph("-", fontChinese));
                doc.add(table);

                PdfPTable table2 = new PdfPTable(6);
                table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
                table2.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
                table2.getDefaultCell().setFixedHeight(30);
                table2.setWidthPercentage(100);
                table2.setTotalWidth(500);
                table2.setTotalWidth(new float[] {60,70,70,100,100,100});
                table2.getDefaultCell().setBorderWidth(1);// 边框宽度

                PdfPCell cell = new PdfPCell(new Paragraph("运行数据记录", fontChinese));
                cell.setRowspan(6);
                table2.addCell(cell);

                PdfPCell cell2 = new PdfPCell(new Paragraph("额定值", fontChinese));
                cell2.setColspan(2);
                table2.addCell(cell2);

                PdfPCell cell3 = new PdfPCell(new Paragraph("月度运行极值", fontChinese));
                cell3.setColspan(3);
                table2.addCell(cell3);

                table2.addCell(new PdfPCell(new Paragraph("参数", fontChinese)));

                table2.addCell(new PdfPCell(new Paragraph("范围", fontChinese)));

                table2.addCell(new PdfPCell(new Paragraph("最大值", fontChinese)));

                table2.addCell(new PdfPCell(new Paragraph("最小值", fontChinese)));

                table2.addCell(new PdfPCell(new Paragraph("平均值", fontChinese)));

                //存放实际值
                doc.add(table2);
            }
        }

        Paragraph paragraphBlue6 = new Paragraph("三、本月运行总评", font15);
        paragraphBlue6.setSpacingBefore(font15Normal.getSize());
        paragraphBlue6.setSpacingAfter(font15Normal.getSize());
        doc.add(paragraphBlue6);

        PdfPTable table = new PdfPTable(2);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setFixedHeight(30);
        table.setWidthPercentage(100);
        table.setTotalWidth(500);
        table.setTotalWidth(new float[] {50,450});
        table.getDefaultCell().setBorderWidth(1);// 边框宽度

        table.addCell(new Paragraph("序号",fontChinese));
        table.addCell(new Paragraph("评价和建议",fontChinese));

        table.addCell(new Paragraph("1",fontChinese));
        table.addCell(new Paragraph("-",fontChinese));

        table.addCell(new Paragraph("2",fontChinese));
        table.addCell(new Paragraph("-",fontChinese));

        doc.add(table);

        doc.close();
    }
}
