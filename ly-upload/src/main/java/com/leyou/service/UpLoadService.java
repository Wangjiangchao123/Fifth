package com.leyou.service;

import org.springframework.web.multipart.MultipartFile;

public interface UpLoadService {


    String upload(MultipartFile file);
}
