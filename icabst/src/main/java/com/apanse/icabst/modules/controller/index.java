package com.apanse.icabst.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: icabst
 * @Date: 2019/5/19 1:51 AM
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
@RequestMapping("/index")
public class index {


    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "holle word";
    }


}
