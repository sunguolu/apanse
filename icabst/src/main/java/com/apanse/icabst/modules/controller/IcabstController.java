package com.apanse.icabst.modules.controller;

import com.apanse.icabst.modules.common.Messages;
import com.apanse.icabst.modules.dto.NameAndPhoneVO;
import com.apanse.icabst.modules.dto.SignUpDTO;
import com.apanse.icabst.modules.service.IcabstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: icabst
 * @Date: 2019/5/26 7:19 AM
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
@RequestMapping("/apanse")
public class IcabstController {

    @Autowired
    private IcabstService icabstService;


    @RequestMapping("/index")
    public String index(){
        return "/page/index";
    }


    @RequestMapping("/topics")
    public String topics(){
        return "/page/topics";
    }


    @RequestMapping("/organization")
    public String organization(){
        return "/page/organization";
    }


    @RequestMapping("/speakers")
    public String speakers(){
        return "/page/speakers";
    }


    @RequestMapping("/program")
    public String program(){
        return "/page/program";
    }


    @RequestMapping("/cfp")
    public String cfp(){
        return "/page/cfp";
    }


    @RequestMapping("/registration")
    public String registration(){
        return "/page/registration";
    }


    @RequestMapping("/venue")
    public String venue(){
        return "/page/venue";
    }

    @RequestMapping("/save")
    public String save(){
        return "/page/save";
    }

    @RequestMapping("/submit")
    public String submit(){
        return "/page/submit";
    }

    @RequestMapping("/article")
    public String article(){
        return "/page/article";
    }


    @RequestMapping("/uploadFile")
    @ResponseBody
    public Messages uploadFile(@RequestParam("file") MultipartFile file, NameAndPhoneVO nameAndPhoneVO){
        Messages messages ;
        try {
            messages = icabstService.uploadFile(file);
        }catch (Exception e){
            messages = Messages.getException(e.getMessage(),null);
        }
        return messages;
    }


    @RequestMapping("/saveEXC")
    @ResponseBody
    public Messages save(@RequestBody SignUpDTO signUpDTO){
        Messages messages ;
        try {
            messages = icabstService.save(signUpDTO,true);
        }catch (Exception e){
            messages = Messages.getException(e.getMessage(),null);
        }
        return messages;
    }

    @RequestMapping("/saveArticleEXC")
    @ResponseBody
    public Messages saveArticleEXC(@RequestBody SignUpDTO signUpDTO){
        Messages messages ;
        try {
            messages = icabstService.save(signUpDTO,false);
        }catch (Exception e){
            messages = Messages.getException(e.getMessage(),null);
        }
        return messages;
    }







}
