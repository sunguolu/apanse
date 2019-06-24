package com.apanse.icabst.modules.service.impl;

import com.apanse.icabst.modules.common.Messages;
import com.apanse.icabst.modules.dto.SignUpDTO;
import com.apanse.icabst.modules.service.IcabstService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: icabst
 * @Date: 2019/5/29 8:30 PM
 * @Author: sunguolu
 * @Description:
 */

@Service
public class IcabstServiceImpl extends BaseServiceImpl implements IcabstService {



    @Override
    public Messages uploadFile(MultipartFile file) throws IOException {

        long time = System.currentTimeMillis();
        String filePath = null;
        if(file == null && file.isEmpty()){
            throw new RuntimeException("不要上传空文件");
        }else {
            /**获取文件保存路径*/
            String folder = file.getOriginalFilename();
            String fileName = String.valueOf(time) + "-" + folder;
            /**基础路径*/
            filePath = path + fileName;

            /**地址*/
            File dest = new File(filePath);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            /**上传*/
            file.transferTo(dest);
        }
        return Messages.getSuccess(filePath);
    }

    @Override
    public Messages save(SignUpDTO signUpDTO,boolean open) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        signUpDTO.setCreatTime(format.format(new Date( )));

        if(open){
            List<SignUpDTO> datas = getDatas(fileName);
            datas.add(signUpDTO);
            write(datas,fileName);
        }else {
            List<SignUpDTO> datas = getDatas(fileArticleName);
            datas.add(signUpDTO);
            write(datas,fileArticleName);
        }

        return Messages.getSuccess(null);
    }
}
