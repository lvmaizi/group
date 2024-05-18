package com.maizi.group.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {

    String upload(MultipartFile multipartFile);

    void download(String uuid, HttpServletResponse response);
}
