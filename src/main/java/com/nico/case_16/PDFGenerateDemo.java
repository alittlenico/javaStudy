package com.nico.case_16;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2023/3/14 14:39
 */
public class PDFGenerateDemo {
    public static void main(String[] args) throws DocumentException, IOException {
        Map<String, Object> data = new HashMap<>();//要插入的数据
        data.put("txtVal","用电户号lj你还不死");
        //初始化itext
        //设置编码
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        PdfReader pdfReader=new PdfReader("D:\\documentFile\\idm_download\\1.pdf");
        PdfStamper pdfStamper=new PdfStamper(pdfReader, new FileOutputStream("d:\\3.pdf"));
        AcroFields form = pdfStamper.getAcroFields();
        form.addSubstitutionFont(baseFont);

        //写入数据
        for(String key : data.keySet()){
            String value=data.get(key).toString();
            //key对应模板数据域的名称
            form.setField(key,value);
        }

        setImg(pdfStamper, "img", "d:\\1.png", form);

        //设置不可编辑
        pdfStamper.setFormFlattening(true);
        pdfStamper.close();
    }

    private static void setImg(PdfStamper pdfStamper, String imgName, String path,AcroFields form) throws DocumentException, IOException {
        //添加图片
        int pageNo = form.getFieldPositions(imgName).get(0).page;
        Rectangle signRect = form.getFieldPositions(imgName).get(0).position;
        float x = signRect.getLeft();
        float y = signRect.getBottom();
        Image image = Image.getInstance(path);
        PdfContentByte under = pdfStamper.getOverContent(pageNo);
        //设置图片大小
        image.scaleAbsolute(signRect.getWidth(), signRect.getHeight());
        //设置图片位置
        image.setAbsolutePosition(x, y);
        under.addImage(image);
    }
}
