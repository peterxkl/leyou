package com.leyou.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author DillonXie
 * @version 1.0
 * @date 11/4/2019 7:11 PM
 */
@Service
public class UploadServiceImpl implements UploadService{

    private static final Logger logger= LoggerFactory.getLogger(UploadServiceImpl.class);

    private static final List<String> suffixes = Arrays.asList("image/png","image/jpeg","image/jpg");

    @Override
    public String uploadImage(MultipartFile file) {
        /**
         * 第一步：验证图片
         *     1.图片类型
         *     2.图片内容
         * 第二步：
         *     1.存储图片
         *     2.返回图片的url
          */
        try {
            String contentType = file.getContentType();
            if (!suffixes.contains(contentType)) {
                logger.info("上传文件失败，{}",contentType);
                return null;
            }
            //校验文件内容，如果不是图片类型，将为null
            BufferedImage image = ImageIO.read(file.getInputStream());
            logger.info("image值：{}",image);
            if (image == null) {
                logger.info("无效的文件类型");
                return null;
            }
            //准备文件路径
            File dest =  new File("D:\\image\\",file.getOriginalFilename());
            //存储文件
            file.transferTo(dest);
            //返回存储路径
            return "D:\\image\\"+file.getOriginalFilename();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
