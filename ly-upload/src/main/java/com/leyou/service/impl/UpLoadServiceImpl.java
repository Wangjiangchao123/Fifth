package com.leyou.service.impl;

import com.leyou.service.UpLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UpLoadServiceImpl  implements UpLoadService {

    //支持文件类型
    private static final List<String> suffixes = Arrays.asList("image/png","image/jpeg");

    @Override
    public String upload(MultipartFile file) {

        //1.校验文件类型
        try {
            String fileType = file.getContentType();
            if(!suffixes.contains(fileType)){
                log.info("上传文件类型不匹配");
                return null;
            }
            //2.校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(null == image){
                log.info("上传文件不符合要求");
                return  null;
            }
            // 2、保存图片
            // 2.1、生成保存目录
            File dir = new File("D:\\heima\\upload");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 2.2、保存图片
            file.transferTo(new File(dir, file.getOriginalFilename()));

            // 2.3、拼接图片地址
            String url = "http://image.leyou.com/upload/" + file.getOriginalFilename();

            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
