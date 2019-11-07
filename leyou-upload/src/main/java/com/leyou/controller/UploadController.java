package com.leyou.controller;

import com.leyou.service.UploadServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author DillonXie
 * @version 1.0
 * @date 11/4/2019 7:01 PM
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private UploadServiceImpl uploadService;
    /**
     * 文件上传
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file) {
        String url = uploadService.uploadImage(file);
        if (StringUtils.isEmpty(url)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(url);
    }
}
