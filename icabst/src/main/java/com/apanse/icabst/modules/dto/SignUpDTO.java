package com.apanse.icabst.modules.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @program: icabst
 * @Date: 2019/6/8 4:22 PM
 * @Author: sunguolu
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SignUpDTO extends BaseRowModel {


    @ExcelProperty(index = 0 , value = "姓名")
    private String userName;
    @ExcelProperty(index = 1 , value = "手机号")
    private String phone;
    @ExcelProperty(index = 2 , value = "邮箱")
    private String email;
    @ExcelProperty(index = 3 , value = "QQ")
    private String qq;
    @ExcelProperty(index = 2 , value = "备用邮箱")
    private String secondemail;
    @ExcelProperty(index = 3 , value = "微信")
    private String wechat;
    @ExcelProperty(index = 4 , value = "报告题目")
    private String title;
    @ExcelProperty(index = 5 , value = "职称")
    private String position;
    @ExcelProperty(index = 6 , value = "单位院系")
    private String affiliation;
    @ExcelProperty(index = 7 , value = "通讯地址")
    private String address;
    @ExcelProperty(index = 8 , value = "研究领域")
    private String researchField;
    @ExcelProperty(index = 9 , value = "出生日期")
    private String passport;
    @ExcelProperty(index = 10 , value = "护照号")
    private String birthday;
    @ExcelProperty(index = 11 , value = "参会类型")
    private String conferenceType;
    @ExcelProperty(index = 12 , value = "缴费类型")
    private String registerType;
    @ExcelProperty(index = 13 , value = "支付方式")
    private String payment;
    @ExcelProperty(index = 14 , value = "发票类型")
    private String invoice;
    @ExcelProperty(index = 15 , value = "议题")
    private String issue;
    @ExcelProperty(index = 16 , value = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private String creatTime;
    @ExcelProperty(index = 17 , value = "上传文件地址")
    private String uploadFileUrl;
    @ExcelProperty(index = 18 , value = "所有作者")
    private String allAuthors;
    @ExcelProperty(index = 19 , value = "其他说明")
    private String otherInstructions;


}
