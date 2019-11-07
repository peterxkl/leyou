package com.leyou.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author DillonXie
 * @version 1.0
 * @date 11/4/2019 7:11 PM
 */
public interface UploadService {
    String uploadImage(MultipartFile file);
}
