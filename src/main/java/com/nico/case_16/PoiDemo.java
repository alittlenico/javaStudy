//package com.nico.case_16;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfPageEventHelper;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayInputStream;
//import java.io.FileOutputStream;
//import java.util.Map;
//
///**
// * @author liuyi
// * @version 1.0
// * @description: TODO
// * @date 2023/3/14 14:57
// */
//public class PoiDemo {
//    public static void main(String[] args) {
//
//    }
//
//    public void method1(HttpServletResponse response, HttpServletRequest request, String fileName) {
//        FileOutputStream fileOutputStream1 = null;
//        FileOutputStream fileOutputStream2 = null;
//        ByteArrayInputStream dataChartStringin1 = null;
//        ByteArrayInputStream dataChartStringin2 = null;
//        try {
//            String filename = fileName + ".pdf";
//            response.setContentType("application/pdf;chartset=utf-8");
//            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
//            Rectangle rectPageSize = new Rectangle(PageSize.A4); //  定义A4页面大小
//            rectPageSize = rectPageSize.rotate();
//            Document document = new Document(rectPageSize, 50, 50, 50, 50);
//            PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
//            PdfPageEventHelper pdfPageEventHelper = new PdfPageEventHelper();
//            pdfPageEventHelper.onEndPage(writer, document);
//            document.open();
//            addPdfTitleMsg(request, document);
//            // 获取流
//            BASE64Decoder base64Decoder = new BASE64Decoder();
//            String dataChartString1 = URLDecoder.decode(request.get("image1").substring(22), "UTF-8").replaceAll(" ", "+");
//            dataChartStringin1 = new ByteArrayInputStream(base64Decoder.decodeBuffer(dataChartString1));    //将picInfoByte作为输入流；
//            //读文件
//            byte[] b1 = new byte[128];
//            String path1 = new ClassPathResource("temp/temp1.png").getFile().getPath();
//            File file1 = new File(path1);
//            fileOutputStream1 = new FileOutputStream(file1);
//            while (dataChartStringin1.read(b1) != -1) {
//                fileOutputStream1.write(b1);
//            }
//            Image image1 = Image.getInstance(path1);
//            image1.scaleAbsolute(280, 120); // 设置图片大小
//            image1.setAccessibleAttribute(PdfName.ALT, new PdfString("temp1"));
//
//            String dataChartString2 = URLDecoder.decode(request.get("image2").substring(22), "UTF-8").replaceAll(" ", "+");
//            dataChartStringin2 = new ByteArrayInputStream(base64Decoder.decodeBuffer(dataChartString2));    //将picInfoByte作为输入流；
//            byte[] b2 = new byte[128];
//            String path2 = new ClassPathResource("temp/temp1.png").getFile().getPath();
//            File file2 = new File(path2);
//            fileOutputStream2 = new FileOutputStream(file2);
//            while (dataChartStringin2.read(b2) != -1) {
//                fileOutputStream2.write(b2);
//            }
//            Image image2 = Image.getInstance(path2);
//            image2.scaleAbsolute(280, 120); // 设置图片大小
//            image2.setAccessibleAttribute(PdfName.ALT, new PdfString("temp2"));
//            // 以上图片 完成
//            PdfPTable headerTable = new PdfPTable(2);
//            PdfPCell acell = new PdfPCell(image1, false);
//            removeBorder(acell);
//
//            headerTable.addCell(acell);
//            PdfPCell rCell = new PdfPCell(image2, false);
//            removeBorder(rCell);
//            headerTable.addCell(rCell);
//            //将主要的表格headerTable加入document文档对象中
//            document.add(headerTable);
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fileOutputStream1 != null) {
//                    fileOutputStream1.close();
//                }
//                if (dataChartStringin1 != null) {
//                    dataChartStringin1.close();
//                }
//                if (fileOutputStream2 != null) {
//                    fileOutputStream2.close();
//                }
//                if (dataChartStringin2 != null) {
//                    dataChartStringin2.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    private void addPdfTitleMsg(Map<String, String> request, Document document) throws DocumentException {
//        PdfUtil.addElement("终端审计日志统计", Element.ALIGN_CENTER, document);
//
//        PdfPTable table = new PdfPTable(1);
//        Font font = new Font(FontUtil.getBfChinese(), 12);
//        // 换行
//        document.add(new Chunk(("\n")));
//        // 时间
//        PdfUtil.pcellColorNoBorder(table, new Paragraph(getTimeMsg(request), font));
//        document.add(table);
//    }
//}
