package com.maizi.quan.api.service;

import com.maizi.quan.manager.domain.File;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {

    String upload(MultipartFile multipartFile);

    void download(String uuid, HttpServletResponse response);
}
