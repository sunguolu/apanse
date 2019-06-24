package com.apanse.icabst.modules.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.apanse.icabst.modules.Listener.ExcelListener;
import com.apanse.icabst.modules.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: icabst
 * @Date: 2019/5/29 8:29 PM
 * @Author: sunguolu
 * @Description:
 */

@PropertySource("classpath:config/config.properties")
public class BaseServiceImpl {


    @Value("${uploading_path}")
    protected  String path;
    @Value("${write_path}")
    protected  String writePath;
    @Value("${file_name}")
    protected  String fileName;
    @Value("${file_article_name}")
    protected  String fileArticleName;


    protected  List<SignUpDTO> getDatas(String name) throws FileNotFoundException {
        File file = new File(writePath+name);
        List<SignUpDTO> datas = null;
        if (file.exists()) {
            FileInputStream in = new FileInputStream(file);
            try {
                ExcelListener<SignUpDTO> excelListener = new ExcelListener<SignUpDTO>();

                ExcelReader excelReader = new ExcelReader(in, ExcelTypeEnum.XLSX, null, excelListener);

                excelReader.read(new Sheet(1, 1, SignUpDTO.class));

                datas = excelListener.getDatas();
            } catch (Exception e) {
                e.printStackTrace();
                datas = new ArrayList<>();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            datas = new ArrayList<>();
        }
        return datas;
    }



    protected  void write(List<SignUpDTO> datas,String name) throws FileNotFoundException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(datas == null){
            datas =  new ArrayList<>();
        }
        FileOutputStream out = new FileOutputStream(writePath+name);
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0,SignUpDTO.class);
            writer.write(datas, sheet1);
            writer.finish();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
